package com.crimps.learnspringboot.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author crimps
 * @create 2017-11-09 10:13
 **/
@Service
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByUsername(String userName);

    UserEntity findByUsernameOrEmail(String userName, String email);

}
