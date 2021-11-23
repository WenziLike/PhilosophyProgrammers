package com.philosophyprogrammers.service.account;

import com.philosophyprogrammers.exceptions.InvalidTokenException;
import com.philosophyprogrammers.exceptions.UnknownIdentifierException;
import org.springframework.stereotype.Service;

@Service
public interface AccountService {
    void forgottenPassword(final String userName) throws  UnknownIdentifierException;

    void updatePassword(final String password, final String token) throws InvalidTokenException, UnknownIdentifierException;

    boolean loginDisabled(final String username);
}
