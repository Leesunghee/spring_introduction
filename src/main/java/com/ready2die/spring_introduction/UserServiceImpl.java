package com.ready2die.spring_introduction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    Optional<PasswordEncoder> passwordEncoder;

    @Autowired
    UserRepository userRepository;

//    @Autowired
//    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
//        this.userRepository = userRepository;
//        this.passwordEncoder = passwordEncoder;
//    }

    @Override
    public void register(User user, String rawPassword) {

    }

    public void createUser(User user, String rawPassword) {
        String encodedPassword = passwordEncoder.map(p -> p.encode(rawPassword))
                .orElse(rawPassword);
    }
}
