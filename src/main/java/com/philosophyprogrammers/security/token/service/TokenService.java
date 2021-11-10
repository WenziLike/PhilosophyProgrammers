package com.philosophyprogrammers.security.token.service;

import com.philosophyprogrammers.entity.TokenEntity;
import org.springframework.stereotype.Service;

@Service
public interface TokenService {

    TokenEntity createToken();

    void saveToken(TokenEntity token);

    TokenEntity findByToken(String token);

    void removeToken(TokenEntity token);

    void removeTokenByToken(String token);

}
