package com.ready2die.spring_introduction;

public interface UserRepository {

    User save(User user);

    int countByUsername(String username);
}
