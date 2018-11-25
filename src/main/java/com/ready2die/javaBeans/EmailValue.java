package com.ready2die.javaBeans;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

public class EmailValue {

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "EmailValue{" +
                "value='" + value + '\'' +
                '}';
    }
}
