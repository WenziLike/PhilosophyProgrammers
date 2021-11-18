package com.philosophyprogrammers.email.context;

import com.philosophyprogrammers.entity.UserEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.util.UriComponentsBuilder;

@Getter
@NoArgsConstructor
public class AccountVerificationEmailContext extends AbstractEmailContext {

    private String token;

    @Override
    public <T> void init(T context) {
        //we can do any common configuration setup here
        // like setting up some base URL and context
        UserEntity user = (UserEntity) context; // we pass the customer informati
        put("firstName", user.getFirstName());
        setTemplateLocation("email/email-verification");
        setSubject("Complete your registration");
        setFrom("no-reply@philosophyprogrammers.com");
        setTo(user.getEmail());
    }

    public void setToken(String token) {
        this.token = token;
        put("token", token);
    }

    public void buildVerificationUrl(String baseURL, String token) {
        String url = UriComponentsBuilder.fromHttpUrl(baseURL)
                .path("/register/verify").queryParam("token", token).toUriString();
        put("verificationURL", url);
    }
}
