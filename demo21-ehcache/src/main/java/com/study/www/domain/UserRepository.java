package com.study.www.domain;

import org.springframework.cache.annotation.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 描述:
 *
 * @outhor Administrator
 * @create 2017-11-14 05:48
 */
@CacheConfig(cacheNames = "users")
public interface UserRepository extends JpaRepository<User,Long>{
    @Cacheable(key = "#p0")
    User findByName(String name);

    @Cacheable(key = "#p0",value = "users")
    User findByAccount(String account);

    @Transactional
    @Modifying
    @Query("update User u set u.name=:name where u.account=:account")
    int updateNameByAccount(@Param("account") String account,@Param("name") String name);

    @Cacheable(key = "#p0", condition = "#p0.length()<4")
    User findByNameAndAccount(String name, String account);

    @Query(" from User u where u.id=:id")
    User findById(Long id);

    @Transactional
    @Modifying
    void removeByAccount(String account);

    @Cacheable(key = "#p1", unless = "#result.name.length() >= 4")
    User findByIdAndAccount(Long id, String account);
    @Query(" from User u where u.account=:account")
    User findByAccount1(@Param("account") String account);
}