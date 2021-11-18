package com.philosophyprogrammers.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * For configurable messages and internationalization.
 *
 * @author Viacheslav Murakhin
 * @version 1.0
 */

@Getter
@Setter
public class UserDTO implements Serializable {

    @NotEmpty(message = "First Name can not be empty")
    private String firstName;
    @NotEmpty(message = "Last Name can not be empty")
    private String lastName;
    @NotEmpty(message = "Username can not be empty")
    private String username;
    @NotEmpty(message = "Email can not be empty")
    @Email(message = "Please provide a valid email id")
    private String email;
    @NotEmpty(message = "Password can not be empty")
    private String password;
    @NotEmpty(message = "Password can not be empty")
    private String confirmPassword;
}
