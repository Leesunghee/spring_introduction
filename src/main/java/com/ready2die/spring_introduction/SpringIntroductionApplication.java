package com.ready2die.spring_introduction;

import com.ready2die.javaBeans.ApplicationProperties;
import com.ready2die.service.DomainService;
import com.ready2die.serviceImpl.DomainServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringIntroductionApplication {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext("com.ready2die.config");


//        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        UserService userService = context.getBean(UserServiceImpl.class);

//        UserService userService1 = context.getBean(UserServiceImpl.class);

//        userService.register(new User(), "1235");

        ((UserServiceImpl) userService).findOne("test");

        UserRepository userRepository = context.getBean(UserRepository.class);

        DomainService domainService = context.getBean(DomainServiceImpl.class);

        ApplicationProperties applicationProperties = context.getBean(ApplicationProperties.class);

        System.out.println("adminEmail :::: " + applicationProperties.getAdminEmail().getValue());
        System.out.println("userEmail :::: " + applicationProperties.getEmail());

        ((AnnotationConfigApplicationContext) context).close();

        ((AnnotationConfigApplicationContext) context).registerShutdownHook();
    }
}
