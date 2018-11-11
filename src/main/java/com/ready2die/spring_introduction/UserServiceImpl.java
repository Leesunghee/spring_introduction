package com.ready2die.spring_introduction;

import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {
    PasswordEncoder passwordEncoder;
    UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

//
//    public UserServiceImpl(javax.sql.DataSource dataSource) {
//        this.userRepository = new JdbcU
//    }

    @Override
    public void register(User user, String rawPassword) {

    }
}
