package com.ready2die.serviceImpl;

import com.ready2die.dao.JdbcRoomDao;
import com.ready2die.pojo.Equipment;
import com.ready2die.pojo.Room;
import com.ready2die.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.List;

@Transactional
@Service("roomService")
public class RoomServiceImpl implements RoomService {

    @Autowired
    PlatformTransactionManager txManager;

    @Autowired
    JdbcRoomDao jdbcRoomDao;

    @Transactional(readOnly = true)
    @Override
    public Room getRoom(String roomId) {
        return jdbcRoomDao.getRoomById(roomId);
    }

    @Override
    public void insertRoom(Room room) {

        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setName("InsertRoomWithEquipmentTx");
        def.setReadOnly(false);
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        TransactionStatus status = txManager.getTransaction(def);

        try {
            jdbcRoomDao.insertRoom(room);
            List<Equipment> equipmentList = room.getEquipmentList();
            for (Equipment item : equipmentList) {
                jdbcRoomDao.insertEquipment(item);
            }
        } catch (Exception e) {
            txManager.rollback(status);
            throw new DataAccessException("error occured by insert room", e) {};
        }
        txManager.commit(status);

    }
}
