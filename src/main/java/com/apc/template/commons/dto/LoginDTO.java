package com.apc.template.commons.dto;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class LoginDTO {

    @NotNull
    @Size(min = 2, message = "Username should not be empty")
    private String username;

    @NotNull
    @Size(min = 2, message = "Password should not be empty")
    private String password;
}
