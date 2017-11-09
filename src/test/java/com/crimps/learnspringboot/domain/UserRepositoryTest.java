package com.crimps.learnspringboot.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.UUID;

/**
 * Created by crimps on 2017/11/9.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void testSaveUser() {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(UUID.randomUUID().toString());
        userEntity.setUsername("king01");
        userEntity.setPassword("1");
        userEntity.setEmail("king@1.com");
        userEntity.setNickname("kk");
        userEntity.setRegtime(new Date().toString());

        userRepository.save(userEntity);
    }

    @Test
    public void testFindByUserName() {
        UserEntity userEntity = userRepository.findByUsername("king");
        System.out.println(userEntity);
    }
}