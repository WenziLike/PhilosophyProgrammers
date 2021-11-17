package com.philosophyprogrammers.service.email;

import com.philosophyprogrammers.service.email.context.AbstractEmailContext;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;

@Service
public interface EmailService {
    void sendMail(AbstractEmailContext email) throws MessagingException;
}
