package com.crimps.learnspringboot.mapper;

import com.crimps.learnspringboot.domain.UserEntity;
import com.crimps.learnspringboot.mapper.data.UserXMLMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by crimps on 2017/11/14.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserXMLMapperTest {

    @Autowired
    UserXMLMapper userXMLMapper;

    @Test
    public void getAll() throws Exception {
        List<UserEntity> userEntityList = userXMLMapper.getAll();
        for (UserEntity userEntity : userEntityList) {
            System.out.println(userEntity.getUsername());
        }
    }

    @Test
    public void getOne() throws Exception {
        UserEntity userEntity = userXMLMapper.getOne("4d91c54d-429d-4e6d-a55d-02310394b37a");
        System.out.println(userEntity.getUsername());
    }

    @Test
    public void insert() throws Exception {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(UUID.randomUUID().toString());
        userEntity.setUsername("ck");
        userEntity.setPassword("5");
        userEntity.setEmail("ck@ck.com");
        userEntity.setNickname("kk");
        userEntity.setRegtime(new Date().toString());
        userXMLMapper.insert(userEntity);
    }

    @Test
    public void update() throws Exception {
        UserEntity userEntity = userXMLMapper.getOne("4fb12974-6ec2-4f80-bd6b-54b5481877d6");
        if (null != userEntity) {
            userEntity.setNickname("ck");
            userEntity.setPassword("01");
        }
        userXMLMapper.update(userEntity);
    }

    @Test
    public void delete() throws Exception {
        UserEntity userEntity = userXMLMapper.getOne("8e32be15-11b1-451f-8a02-d1ecff555729");
        userXMLMapper.delete(userEntity.getId());
    }

}