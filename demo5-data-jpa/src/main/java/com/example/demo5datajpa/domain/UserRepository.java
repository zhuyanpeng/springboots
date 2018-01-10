package com.example.demo5datajpa.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * 作用说明：
 *
 * @author mirror.zhuyanpeng
 * @create 2017-08-29 0:30
 **/
public interface UserRepository extends JpaRepository<User,Long> {
    User findByName(String name);
    User findByNameAndAge(String name,Integer age);
    @Query("from User u where u.name=:name")
    User findUser(@Param("name") String name);

    @Modifying
    @Query("update User u set  u.age=:age where u.name=:name")
    int setNameById(@Param("name") String name,@Param("age") Integer age);

}
