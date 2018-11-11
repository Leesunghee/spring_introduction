package com.ready2die.spring_introduction;

import com.ready2die.annotation.Lightweight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    @Lightweight
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
