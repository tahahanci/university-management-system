package com.hncdev.authservice.services.concretes;

import com.hncdev.authservice.entities.User;
import com.hncdev.authservice.repositories.UserRepository;
import com.hncdev.authservice.services.abstracts.UserService;
import com.hncdev.authservice.services.dtos.requests.RegisterStudentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void add(RegisterStudentRequest registerStudentRequest) {
        User user = new User();
        user.setUsername(registerStudentRequest.getUsername());
        user.setPassword(passwordEncoder.encode(registerStudentRequest.getPassword()));
        user.setFirstName(registerStudentRequest.getFirstName());
        user.setLastName(registerStudentRequest.getLastName());
        userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
