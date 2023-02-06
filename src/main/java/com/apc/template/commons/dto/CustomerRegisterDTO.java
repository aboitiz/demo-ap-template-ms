package com.apc.template.commons.dto;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRegisterDTO {
    @NotNull(message = "username is required")
    @Size(min = 2, message = "username should be valid")
    private String username;
    @NotNull(message = "password is required")
    @Size(min = 2, message = "password should be valid")
    private String password;
    @NotNull(message = "First Name is required")
    @Size(min = 2, message = "first name should be valid")
    private String firstName;
    @NotNull(message = "Last Name is required")
    @Size(min = 2, message = "last name should be valid")
    private String lastName;
    private Date birthDate;
    private String address;
}
