package com.ready2die.spring_introduction;

import com.ready2die.javaBeans.ApplicationProperties;
import com.ready2die.javaBeans.EmailValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Locale;

@Component
public class UserServiceImpl implements UserService {

//    @Autowired
//    ApplicationContext context;

//    @Autowired
//    @Lightweight
//    Optional<PasswordEncoder> passwordEncoder;

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);



    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;

    @Autowired
    MessageSource messageSource;

    public UserServiceImpl() {
        System.out.println("Constuctor");
    }

    //    @Autowired
//    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
//        this.userRepository = userRepository;
//        this.passwordEncoder = passwordEncoder;
//    }

    @Override
    public void register(User user, String rawPassword) {
        PasswordEncoder passwordEncoder = passwordEncoder();
        String encodedPassword = passwordEncoder.encode(rawPassword);
        System.out.println("encodedPassword = " + encodedPassword);
    }

    @Lookup
    PasswordEncoder passwordEncoder() {
        return null;
    }

    public void createUser(User user, String rawPassword) {
//        String encodedPassword = passwordEncoder.map(p -> p.encode(rawPassword))
//                .orElse(rawPassword);
    }

    @PostConstruct
    void populateCache() {
        //캐시 등록
        System.out.println("PopulateCache");
    }

    @PreDestroy
    void clearCache() {
        //캐시 삭제
        System.out.println("UserServiceImpl.clearCache");
    }

    public User findOne(String username) {

        log.debug("local 메서드 시작: UserServiceImpl.findOne 인수 = {}", username);
        // 생략
        User user = new User();
        log.debug("local 메서드 종료: UserServiceImpl.findOne 반환값 = {}", user);
        return user;
    }

    public void printWelcomeMessage() {

//        String message = messageSource.getMessage(
//                "result.succeed",
//                new String [] {"사용자 등록"},
//                Locale.KOREAN
//        );

        MessageSourceResolvable functionName = new DefaultMessageSourceResolvable("functionName.userRegistration");

        String message = messageSource.getMessage(
                "result.succeed",
                new MessageSourceResolvable[] {functionName},
                Locale.KOREAN
        );

        System.out.println(message);
    }

}
