package com.crimps.learnspringboot.domain;

import com.crimps.learnspringboot.domain.dto.CountInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author crimps
 * @create 2017-11-09 10:13
 **/
@Service
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByUsername(String userName);

    UserEntity findByUsernameOrEmail(String userName, String email);

    Page<UserEntity> findByUsername(String username, Pageable pageable);

    @Modifying @Transactional
    @Query("update UserEntity user set user.username = ?1 where user.id = ?2")
    int modifyByIdAndUserName(String userName, String id);

    @Query("select u.id as userid, c.id as countid, u.username as username, u.email as email, c.balance as balance" +
            " from UserEntity u, CountEntity c where u.id = c.userid" +
            " and u.username = ?1 ")
    Page<CountInfo> findCountInfo(String userName, Pageable pageable);
    
}
