package com.example.agora.Service.User;

import com.example.agora.Entity.Post.Post;
import com.example.agora.Entity.RefreshToken.RefreshToken;
import com.example.agora.Entity.RefreshToken.RefreshTokenRepository;
import com.example.agora.Entity.User.User;
import com.example.agora.Entity.User.UserRepository;
import com.example.agora.Exception.AlreadyExistException;
import com.example.agora.Exception.InvalidTokenException;
import com.example.agora.Exception.UserNotFoundException;
import com.example.agora.Payload.Request.User.LoginRequest;
import com.example.agora.Payload.Request.User.UserRequest;
import com.example.agora.Payload.Response.Post.Search.SearchData;
import com.example.agora.Payload.Response.User.LoginResponse;
import com.example.agora.Payload.Response.User.MypageResponse;
import com.example.agora.Security.AuthorityType;
import com.example.agora.Security.Jwt.Auth.AuthDetails;
import com.example.agora.Security.Jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final RefreshTokenRepository refreshTokenRepository;

    @Value("${jwt.exp.refresh}")
    private Long RefreshToken_exp;

    @Override
    public String register(UserRequest request) {
        try{
            userRepository.save(
                    User.builder()
                            .authorityType(AuthorityType.ROLE_USER)
                            .userId(request.getUserId())
                            .userPw(passwordEncoder.encode(request.getUserPw()))
                            .build()
            );
            return "Success";
        }catch (Exception e){
            throw new AlreadyExistException();
        }
    }

    @Override
    public LoginResponse userLogin(LoginRequest request) {
        return userRepository.findByUserId(request.getUserId())
                .filter(user-> passwordEncoder.matches(request.getUserPw(), user.getUserPw()))
                .map(User::getUserCode)
                .map(userCode->{
                    try{
                        authenticationManager.authenticate(request.getAuthToken(userCode));
                    }catch (Exception e){
                        throw new InvalidTokenException();
                    }
                    String accessToken = jwtTokenProvider.generateAccessToken(userCode);
                    String refreshToken = jwtTokenProvider.generateRefreshToken(userCode);
                    refreshTokenRepository.save(new RefreshToken(userCode, refreshToken));
                    return new LoginResponse(accessToken, refreshToken, RefreshToken_exp);
                })
                .orElseThrow(UserNotFoundException::new);
    }

    @Override
    public MypageResponse myPage() {
        AuthDetails User = (AuthDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<SearchData> dataList = new ArrayList<>();
        List<Post> postList = User.getPost();
        for(Post post:postList){

            dataList.add(new SearchData(Integer.toString(post.getPostId()), post.getTitle(), post.getUser().getUserId(), post.getCreateAt(), post.getModifyAt()));
        }

        return new MypageResponse(User.getUsername(), dataList);
    }
}
