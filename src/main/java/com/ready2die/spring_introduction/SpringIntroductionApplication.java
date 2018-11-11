package com.ready2die.spring_introduction;

import com.ready2die.service.DomainService;
import com.ready2die.serviceImpl.DomainServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringIntroductionApplication {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext("com.ready2die.config");
//        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        UserService userService = context.getBean(UserServiceImpl.class);

        UserRepository userRepository = context.getBean(UserRepository.class);

        DomainService domainService = context.getBean(DomainServiceImpl.class);

    }
}
