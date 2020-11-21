package com.example.agora.Security.Jwt.Auth;

import com.example.agora.Entity.User.UserRepository;
import com.example.agora.Exception.UserNotFoundException;
import com.example.agora.Security.AuthorityType;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public AuthDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        return userRepository.findById(Integer.parseInt(id))
                .map(AuthDetails::new)
                .orElseThrow(UserNotFoundException::new);
    }
}
