package com.study.www.domain;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * 描述:
 *
 * @outhor Administrator
 * @create 2017-11-14 05:48
 */
@CacheConfig(cacheNames = "users")
public interface UserRepository extends JpaRepository<User,Long>{
    User findByName(String name);

    @Cacheable
    User findByAccount(String account);
    User findByNameAndAccount(String name,String account);
    @Query("from User u where u.id=:id")
    User findById(Long id);
}
