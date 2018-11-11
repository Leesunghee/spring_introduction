package com.ready2die.spring_introduction;

import org.junit.Test;

public class UserServiceTest {

    @Test
    public void testCreate() {
        UserServiceImpl userService = new UserServiceImpl();
        userService.userRepository = new DummyUserRepository();
    }
}
