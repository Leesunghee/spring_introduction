package com.ready2die.dao;

import com.ready2die.pojo.Equipment;
import com.ready2die.pojo.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JdbcRoomDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public int findMaxCapacity() {
        String sql = "SELECT MAX(capacity) FROM room";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    public Room getRoomById(String roomId) {
        String sql = "SELECT room_id, room_name, capacity" +
                " FROM room WHERE room_id = ?";
        RoomRowMapper rowMapper = new RoomRowMapper();
        return jdbcTemplate.queryForObject(sql, rowMapper, roomId);
    }

    public List<Room> getAllRoom() {
        String sql = "SELECT room_id, room_name, capacity FROM room";
        RoomRowMapper rowMapper = new RoomRowMapper();
        return jdbcTemplate.query(sql, rowMapper);
    }

    public List<Room> getAllRoomUsingLambda() {
        String sql = "SELECT room_id, room_name, capacity FROM room";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
           Room room = new Room();
           room.setRoomId(rs.getString("room_id"));
           room.setRoomName(rs.getString("room_name"));
           room.setCapacity(rs.getInt("capacity"));
           return room;
        });
    }

    public List<Room> getAllRoomWithEquipment() {
        String sql = "SELECT r.room_id, r.room_name, r.capacity," +
                " e.equipment_id, e.equipment_name, e.equipment_count," +
                " e.equipment_remarks FROM room r LEFT JOIN equipment e" +
                " ON r.room_id = e.room_id";
        RoomListResultSetExtractor extractor = new RoomListResultSetExtractor();
        return jdbcTemplate.query(sql, extractor);
    }

    public Room getRoomWithEquipmentById(String roomId) {
        String sql = "SELECT r.room_id, r.room_name, r.capacity," +
                " e.equipment_id, e.equipment_name, e.equipment_count," +
                " e.equipment_remarks FROM room r LEFT JOIN equipment e" +
                " ON r.room_id = e.room_id" +
                " WHERE r.room_id = ?";

        RoomListResultSetExtractor extractor = new RoomListResultSetExtractor();
        List<Room> roomList = jdbcTemplate.query(sql, extractor, roomId);
        return roomList.get(0);
    }

    public void reportRoom() {
        String sql = "SELECT room_id, room_name, capacity FROM room";
        RoomRowCallbackHandler handler = new RoomRowCallbackHandler();
        jdbcTemplate.query(sql, handler);
    }

    public void insertRoom(Room room) {
    }

    public void insertEquipment(Equipment item) {
    }
}
