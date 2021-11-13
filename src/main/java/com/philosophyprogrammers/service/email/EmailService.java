package com.philosophyprogrammers.service.email;

import com.philosophyprogrammers.service.email.context.AbstractEmailContext;

import javax.mail.MessagingException;

public interface EmailService {
    void sendMail(final AbstractEmailContext email) throws MessagingException;
}