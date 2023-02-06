package com.apc.template.repository;

import com.apc.template.model.CustomerAuth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerAuthRepository extends JpaRepository<CustomerAuth, Integer> {
    @Query(value = "select * FROM customer_auth ca where ca.username =:username and ca.password =:password",
            nativeQuery=true)
    CustomerAuth getByUsernameAndPassword(String username, String password);
}
