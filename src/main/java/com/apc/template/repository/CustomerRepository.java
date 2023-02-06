package com.apc.template.repository;

import com.apc.template.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Customer findByCustomerAuthId(Long AuthId);
}
