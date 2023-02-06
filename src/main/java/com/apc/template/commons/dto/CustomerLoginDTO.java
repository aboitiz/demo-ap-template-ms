package com.apc.template.commons.dto;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerLoginDTO {
    @NotNull(message = "username is required")
    @Size(min = 2, message = "username cannot be empty")
    private String username;
    @NotNull(message = "password is required")
    @Size(min = 2, message = "password cannot be empty")
    private String password;
}
