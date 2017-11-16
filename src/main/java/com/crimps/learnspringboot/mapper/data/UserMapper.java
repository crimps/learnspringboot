package com.crimps.learnspringboot.mapper.data;

import com.crimps.learnspringboot.domain.UserEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by crimps on 2017/11/13.
 */
public interface UserMapper {

    @Select("select * from user")
    List<UserEntity> getAll();

    @Select("select * from user where id = #{id}")
    UserEntity getOne(String id);

    @Insert("insert into user(id, username, password, email, nickname, regtime) " +
            "values(#{id}, #{username}, #{password}, #{email}, #{nickname}, #{regtime})")
    void insert(UserEntity userEntity);

    @Update("update user set password = #{password} where id = #{id}")
    void updatePassword(UserEntity userEntity);

    @Delete("delete from user where id = #{id}")
    void delete(String id);
}
