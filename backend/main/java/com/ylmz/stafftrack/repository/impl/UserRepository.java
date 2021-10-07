package com.ylmz.stafftrack.repository.impl;

import com.ylmz.stafftrack.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface UserRepository extends JpaRepository<User,Integer> {
    @Query(value = "SELECT u from User u where u.email = ?1")
    User getUserByEmail(String email);

    @Query(value = "SELECT u from User u where u.email = ?1 and u.password = ?2")
    User checkUserEmailAndPass(String email, String password);
}
