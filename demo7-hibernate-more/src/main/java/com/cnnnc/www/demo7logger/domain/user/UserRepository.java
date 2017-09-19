package com.cnnnc.www.demo7logger.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 作用说明：持久层
 *
 * @author mirror.zhuyanpeng
 * @create 2017-09-13 0:56
 **/
@Repository
public interface UserRepository extends JpaRepository<UserPO,Long>{

}
