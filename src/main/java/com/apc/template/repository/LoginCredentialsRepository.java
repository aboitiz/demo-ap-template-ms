package com.apc.template.repository;

import com.apc.commons.response.BaseResponse;
import com.apc.template.model.LoginCredentials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LoginCredentialsRepository extends JpaRepository<LoginCredentials, Long> {

    @Query(value = "SELECT * FROM login_credentials lc WHERE lc.username =:username AND lc.password =:password",
            nativeQuery = true)
    LoginCredentials getUserCred(String username, String password);
}
