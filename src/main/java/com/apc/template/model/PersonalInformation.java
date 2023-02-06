package com.apc.template.model;

import com.apc.template.model.base.AuditableEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "personal_information")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonalInformation extends AuditableEntity {

    @Column(length = 10)
    private String employeeNum;
    @Column(length = 50)
    private String firstName;
    @Column(length = 50)
    private String middleName;
    @Column(length = 50)
    private String lastName;
    @Column
    private int age;
    @Column
    private Date birthDate;

}
