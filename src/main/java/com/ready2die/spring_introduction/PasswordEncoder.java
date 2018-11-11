package com.ready2die.spring_introduction;

public interface PasswordEncoder {
    String encode(CharSequence rawPassword);
}
