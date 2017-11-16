package com.crimps.learnspringboot.mapper;

import com.crimps.learnspringboot.domain.UserEntity;
import com.crimps.learnspringboot.mapper.data.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by crimps on 2017/11/13.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void getAll() throws Exception {
        List<UserEntity> userEntityList = userMapper.getAll();
        for (UserEntity userEntity : userEntityList) {
            System.out.println(userEntity.getUsername());
        }
    }

    @Test
    public void getOne() {
        UserEntity userEntity = userMapper.getOne("4d91c54d-429d-4e6d-a55d-02310394b37a");
        System.out.println(userEntity.getUsername());
    }

    @Test
    public void insert() {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(UUID.randomUUID().toString());
        userEntity.setUsername("tea bag");
        userEntity.setPassword("3");
        userEntity.setEmail("tea@bag.com");
        userEntity.setNickname("TT");
        userEntity.setRegtime(new Date().toString());
        userMapper.insert(userEntity);
    }

    @Test
    public void updatePassword() {
        List<UserEntity> userEntityList = userMapper.getAll();
        for(int i = 0; i < userEntityList.size(); i++) {
            UserEntity userEntity = userEntityList.get(i);
            userEntity.setPassword(String.valueOf(i));
            userMapper.updatePassword(userEntity);
        }
    }

    @Test
    public void delete() {
        List<UserEntity> userEntityList = userMapper.getAll();
        if (!userEntityList.isEmpty()) {
            userMapper.delete(userEntityList.get(0).getId());
        }
    }
}