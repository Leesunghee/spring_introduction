package com.ready2die.spring_introduction;

public class DummyUserRepository implements UserRepository {
    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public int countByUsername(String username) {
        return 0;
    }
}