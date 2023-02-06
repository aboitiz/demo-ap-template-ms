package com.apc.template.repository;

import com.apc.template.model.PersonalInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PersonalInformationRepository extends JpaRepository<PersonalInformation, Long> {

    @Query(value = "SELECT * FROM personal_information pi WHERE pi.id =:user_id",
            nativeQuery = true)
    PersonalInformation getUserInfo(Integer user_id);

}
