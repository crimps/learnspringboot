package com.crimps.learnspringboot.controller;

import com.crimps.learnspringboot.domain.UserEntity;
import com.crimps.learnspringboot.domain.UserRepository;
import com.crimps.learnspringboot.mapper.data.UserMapper;
import com.crimps.learnspringboot.mapper.data.UserXMLMapper;
import com.crimps.learnspringboot.mapper.databack.UserXMLBackMapper;
import com.crimps.learnspringboot.util.ConstantProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author crimps
 * @create 2017-11-08 10:11
 **/
@RestController
public class DestoryWorldController {

    @Autowired
    ConstantProperties constantProperties;

    @Autowired
    UserRepository userRepository;

    @Autowired
    private UserXMLMapper userXMLMapper;

    @Autowired
    private UserXMLBackMapper userXMLBackMapper;

    @RequestMapping("/destory")
    public String index() {
        return "Destory World !!!" + constantProperties.getTitle();
    }


    @RequestMapping("/getUser")
    @Cacheable(value = "user-key")
    public UserEntity getUser() {
        UserEntity userEntity = userRepository.findByUsername("king");
        System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");
        return userEntity;
    }

    @RequestMapping("/uid")
    public String uid(HttpSession session) {
        UUID uuid = (UUID) session.getAttribute("uid");
        if (null == uuid) {
            uuid = UUID.randomUUID();
        }
        session.setAttribute("uid", uuid);
        return session.getId();
    }

    @RequestMapping("/getUsers")
    public List<UserEntity> getUsers() {
        return userXMLMapper.getAll();
    }

    @RequestMapping("/getUsersBack")
    public List<UserEntity> getUsersBack() {
        return userXMLBackMapper.getAll();
    }

    @RequestMapping("/addUser")
    public void addUser() {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(UUID.randomUUID().toString());
        userEntity.setUsername("1");
        userEntity.setPassword("1");
        userEntity.setEmail("1@1.com");
        userEntity.setNickname("1");
        userEntity.setRegtime(new Date().toString());
        userXMLMapper.insert(userEntity);
    }
}
