package com.ready2die.config;

import com.ready2die.annotation.Lightweight;
import com.ready2die.spring_introduction.BCryptPasswordEncoder;
import com.ready2die.spring_introduction.PasswordEncoder;
import com.ready2die.spring_introduction.Sha256PasswordEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan("com.ready2die.spring_introduction")
public class AppConfig {

    @Bean
    @Primary
    PasswordEncoder bcryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Lightweight
    PasswordEncoder sha256PasswordEncoder() {
        return new Sha256PasswordEncoder();
    }
}
