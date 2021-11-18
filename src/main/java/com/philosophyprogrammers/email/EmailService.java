package com.philosophyprogrammers.email;

import com.philosophyprogrammers.email.context.AbstractEmailContext;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;

@Service
public interface EmailService {
    void sendMail(AbstractEmailContext email) throws MessagingException;
}