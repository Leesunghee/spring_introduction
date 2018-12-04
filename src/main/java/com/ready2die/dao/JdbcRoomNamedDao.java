package com.ready2die.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class JdbcRoomNamedDao {

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public String findRoomNameById(String roomId) {
        String sql = "SELECT room_name FROM room WHERE room_id = :roomId";
        Map<String, Object> params = new HashMap<>();
        params.put("roomId", roomId);
        return namedParameterJdbcTemplate.queryForObject(sql, params, String.class);
    }
}
