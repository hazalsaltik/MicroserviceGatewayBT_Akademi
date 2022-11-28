package com.bt_akademi.user_management.model.repository;

import com.bt_akademi.user_management.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer>
{


    /*
    Optional is primarily intended for use as a method return type
    where there is a clear need to represent "no result,"
    and where using null is likely to cause errors.
    A variable whose type is Optional should never itself be null;
    it should always point to an Optional instance.
     */
    // SELECT * FROM USERS WHERE USERNAME = ?;
    Optional<User> findByUsername(String username); // aranan username'e sahip user
}

