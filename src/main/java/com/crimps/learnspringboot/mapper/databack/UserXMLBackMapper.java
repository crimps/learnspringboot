package com.crimps.learnspringboot.mapper.databack;

import com.crimps.learnspringboot.domain.UserEntity;

import java.util.List;

/**
 * @author crimps
 * @create 2017-11-16 14:05
 **/
public interface UserXMLBackMapper {
    List<UserEntity> getAll();

    UserEntity getOne(String id);

    void insert(UserEntity userEntity);

    void update(UserEntity userEntity);

    void delete(String id);
}
