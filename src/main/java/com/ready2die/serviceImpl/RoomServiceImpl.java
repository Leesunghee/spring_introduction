package com.ready2die.serviceImpl;

import com.ready2die.dao.JdbcRoomDao;
import com.ready2die.pojo.Equipment;
import com.ready2die.pojo.Room;
import com.ready2die.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

@Transactional
@Service("roomService")
public class RoomServiceImpl implements RoomService {

    @Autowired
    TransactionTemplate transactionTemplate;

    @Autowired
    JdbcRoomDao jdbcRoomDao;

    @Transactional(readOnly = true)
    @Override
    public Room getRoom(String roomId) {
        return jdbcRoomDao.getRoomById(roomId);
    }

    @Override
    public void insertRoom(Room room) {

        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                jdbcRoomDao.insertRoom(room);
                List<Equipment> equipmentList = room.getEquipmentList();
                for (Equipment item : equipmentList) {
                    jdbcRoomDao.insertEquipment(item);
                }
            }
        });
    }
}
