package com.ready2die.config;

import com.ready2die.spring_introduction.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class AppConfig {

    @Bean
    UserRepository userRepository() {
        return new UserRepository() {
            @Override
            public User save(User user) {
                return null;
            }

            @Override
            public int countByUsername(String username) {
                return 0;
            }
        };
    }

    @Bean
    UserRepository userRepository2() {
        return new UserRepositoryImpl();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    UserService userService() {
//        return new UserServiceImpl(userRepository(), passwordEncoder());
//    }

    @Bean
    UserService userService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return new UserServiceImpl(userRepository, passwordEncoder);
    }


}
