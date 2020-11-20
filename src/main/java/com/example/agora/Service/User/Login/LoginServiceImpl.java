package com.example.agora.Service.User.Login;

import com.example.agora.Entity.RefreshToken.RefreshToken;
import com.example.agora.Entity.RefreshToken.RefreshTokenRepository;
import com.example.agora.Entity.User.User;
import com.example.agora.Entity.User.UserRepository;
import com.example.agora.Exception.InvalidTokenException;
import com.example.agora.Exception.UserNotFoundException;
import com.example.agora.Payload.Request.User.LoginRequest;
import com.example.agora.Payload.Response.User.LoginResponse;
import com.example.agora.Security.Jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService{

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final RefreshTokenRepository refreshTokenRepository;

    @Value("${jwt.exp.refresh}")
    private Long RefreshToken_exp;

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


}
