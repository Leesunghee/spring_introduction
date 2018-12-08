package com.ready2die.exception;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataRetrievalFailureException;

public class NotFoundRoomIdException extends DataAccessException {
    public NotFoundRoomIdException(String message, DataAccessException e) {
        super(message, e);
    }
}
