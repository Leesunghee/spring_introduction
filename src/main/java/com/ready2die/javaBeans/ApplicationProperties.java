package com.ready2die.javaBeans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class ApplicationProperties {

    @Value("${application.adminEmail:}")
    private EmailValue adminEmail;

    @Value("${application.userEmail:}")
    private String email;

    public EmailValue getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(EmailValue adminEmail) {
        this.adminEmail = adminEmail;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "ApplicationProperties{" +
                "adminEmail=" + adminEmail +
                ", email='" + email + '\'' +
                '}';
    }
}
