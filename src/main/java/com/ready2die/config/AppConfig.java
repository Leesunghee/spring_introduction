package com.ready2die.config;

import com.ready2die.annotation.Lightweight;
import com.ready2die.service.DomainService;
import com.ready2die.spring_introduction.BCryptPasswordEncoder;
import com.ready2die.spring_introduction.PasswordEncoder;
import com.ready2die.spring_introduction.Sha256PasswordEncoder;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackages = "com.ready2die", includeFilters = {
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {DomainService.class})
})
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
