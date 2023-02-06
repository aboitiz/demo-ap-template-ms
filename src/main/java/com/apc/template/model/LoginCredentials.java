package com.apc.template.model;

import com.apc.template.model.base.AuditableEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "login_credentials")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginCredentials extends AuditableEntity {

    @Column
    private int userId;
    @Column(length = 50)
    private String username;
    @Column(length = 50)
    private String password;
}
