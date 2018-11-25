package com.ready2die.converter;

import com.ready2die.javaBeans.EmailValue;
import org.springframework.core.convert.converter.Converter;

public class StringToEmailValueConverter implements Converter<String, EmailValue> {
    @Override
    public EmailValue convert(String source) {
        EmailValue email = new EmailValue();
        email.setValue(source);
        return email;
    }
}
