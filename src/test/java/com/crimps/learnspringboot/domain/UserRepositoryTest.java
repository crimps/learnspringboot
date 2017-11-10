package com.crimps.learnspringboot.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    @Test
    public void testPageQuery() throws Exception {
        int page = 1;
        int size = 10;
        Pageable pageable = new PageRequest(page, size);
        userRepository.findByUsername("kk", pageable);
    }

    @Test
    public void testmodifyByIdAndUserName() {
        userRepository.modifyByIdAndUserName("queen", "4d91c54d-429d-4e6d-a55d-02310394b37a");
    }
}