package com.ready2die.spring_introduction;

import org.springframework.stereotype.Component;

@Component
public class UserRepositoryImpl implements UserRepository {
    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public int countByUsername(String username) {
        return 0;
    }

    public void print() {
        System.out.println("test");
    }
}
