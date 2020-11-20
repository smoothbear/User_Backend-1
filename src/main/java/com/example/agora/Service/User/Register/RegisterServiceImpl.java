package com.example.agora.Service.User.Register;

import com.example.agora.Entity.User.User;
import com.example.agora.Entity.User.UserRepository;
import com.example.agora.Exception.AlreadyExistException;
import com.example.agora.Payload.Request.User.UserRequest;
import com.example.agora.Security.AuthorityType;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterServiceImpl implements RegisterService{
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

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
}
