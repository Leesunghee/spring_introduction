package com.ready2die.spring_introduction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JdbcRoomDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public int findMaxCapacity() {
        String sql = "SELECT MAX(capacity) FROM room";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

}
