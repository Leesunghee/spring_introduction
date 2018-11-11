package com.ready2die.spring_introduction;

import com.ready2die.config.AppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringIntroductionApplication {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext("com.ready2die.config");
//        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        UserService userService = context.getBean(UserServiceImpl.class);

        UserRepository userRepository = context.getBean(UserRepository.class);



    }
}
