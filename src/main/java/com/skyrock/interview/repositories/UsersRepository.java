package com.skyrock.interview.repositories;


import com.skyrock.interview.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {

  Users findByFirstNameAndSurnameAndId(String firstName, String lastName, Long id);

}
