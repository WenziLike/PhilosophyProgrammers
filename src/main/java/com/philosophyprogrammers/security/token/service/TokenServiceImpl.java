package com.philosophyprogrammers.security.token.service;

import com.philosophyprogrammers.entity.TokenEntity;
import com.philosophyprogrammers.security.token.repository.TokenRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.keygen.BytesKeyGenerator;
import org.springframework.security.crypto.keygen.KeyGenerators;
import org.springframework.stereotype.Service;

import java.nio.charset.Charset;
//import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

import org.apache.tomcat.util.codec.binary.Base64;

@Service
public class TokenServiceImpl implements TokenService {
    /**
     * Generation Token
     */
    private final static BytesKeyGenerator
            DEFAULT_TOKEN_KEY_GENERATOR = KeyGenerators.secureRandom(24);
    private final static Charset US_ASCII = Charset.forName("US-ASCII");

    /**
     * Validation Token in Seconds
     */
    @Value("${jdj.secure.token.validity}")
    private int tokenValidationsInSeconds;


    private  TokenRepository tokenRepository;

    public TokenServiceImpl(TokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }

    /**
     * Implements methods Token Repository {@link TokenRepository}
     */

    @Override
    public TokenEntity createToken() {

        String tokenValue =
                new String(Base64.encodeBase64URLSafe(DEFAULT_TOKEN_KEY_GENERATOR.generateKey()), US_ASCII);

        TokenEntity tokenEntity = new TokenEntity();
        tokenEntity.setToken(tokenValue);
        tokenEntity.setExpireAt(LocalDateTime.now().plusSeconds(getTokenValidationsInSeconds()));
        this.saveToken(tokenEntity);
        return tokenEntity;
    }

    @Override
    public void saveToken(TokenEntity tokenEntity) {
        tokenRepository.save(tokenEntity);
    }

    @Override
    public TokenEntity findByToken(String token) {
        return tokenRepository.findByToken(token);
    }

    public int getTokenValidationsInSeconds() {
        return tokenValidationsInSeconds;
    }
}
