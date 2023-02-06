package com.apc.template.model;

import com.apc.template.model.base.AuditableEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "customer")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Customer extends AuditableEntity {

    private Long customerAuthId;
    @Column(length = 50)
    private String firstName;

    @Column(length = 50)
    private String lastName;

    @Column(length = 100)
    private Date birthDate;

    @Column(length = 50)
    private String address;
}
