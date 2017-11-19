package com.study.www.application.domain;

import org.hibernate.annotations.Cache;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * 描述:
 *
 * @outhor Administrator
 * @create 2017-11-17 07:08
 */
@CacheConfig(cacheNames = "redisName")
public interface UserRepository extends   JpaRepository<User,Long> {

    @Cacheable(key = "#p0")
    User findByAccount(String account);
    @Cacheable(key="#p1",condition = "#p0.length()<4")
    User findByNameAndAccount(String name,String account);

    User findByName(String name);

    @Transactional
    @Modifying
    @Query("update User u set u.name=:name where u.account=:account")
    void updateUserByAccount(@Param("account") String account,@Param("name") String name);

    @Transactional
    @Modifying
    int removeByAccount(@Param("account") String account);

    @Cacheable(key = "#p1",unless = "#result.account.length()<7")//定义输出的判断
    User findByIdAndAccount(@Param("id") Long id,@Param("account") String account);

    @Query("  from User u where u.account=:account")
    User findByAccuntNoCache(@Param("account") String account);
}