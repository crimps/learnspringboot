package com.crimps.learnspringboot.mapper;

import com.crimps.learnspringboot.domain.UserEntity;

import java.util.List;

/**
 * Created by crimps on 2017/11/14.
 */

public interface UserXMLMapper {
    List<UserEntity> getAll();

    UserEntity getOne(String id);

    void insert(UserEntity userEntity);

    void update(UserEntity userEntity);

    void delete(String id);
}
