package com.ready2die.service;

import com.ready2die.pojo.Room;

public interface RoomService {
    Room getRoom(String roomId);

    void insertRoom(Room room);
}
