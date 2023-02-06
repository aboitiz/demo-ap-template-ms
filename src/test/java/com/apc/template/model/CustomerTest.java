package com.apc.template.model;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CustomerTest {
    private String firstName = "User";
    private String lastname = "Test";
    private Date birthDate = new Date(2010, 01,02);
    private String address = "Manila";
    private Long customerAuthId = 1L;

    @Test
    void success(){
        Customer cust = new Customer();
        cust.setCustomerAuthId(customerAuthId);
        cust.setFirstName(firstName);
        cust.setLastName(lastname);
        cust.setAddress(address);
        cust.setBirthDate(birthDate);

        assertThat(cust.getFirstName()).isEqualTo(firstName);
        assertThat(cust.getLastName()).isEqualTo(lastname);
        assertThat(cust.getAddress()).isEqualTo(address);
        assertThat(cust.getCustomerAuthId()).isEqualTo(customerAuthId);
        assertThat(cust.getBirthDate()).isEqualTo(birthDate);
    }

    @Test
    void success_overloading_constructor(){
        Customer cust = new Customer(
                customerAuthId,
                firstName,
                lastname,
                birthDate,
                address
        );

        assertThat(cust.getFirstName()).isEqualTo(firstName);
        assertThat(cust.getLastName()).isEqualTo(lastname);
        assertThat(cust.getAddress()).isEqualTo(address);
        assertThat(cust.getCustomerAuthId()).isEqualTo(customerAuthId);
        assertThat(cust.getBirthDate()).isEqualTo(birthDate);
    }

    @Test
    void success_toString(){
        String cust = new Customer().toString();

        assertThat(cust).isInstanceOf(String.class);
    }
}
