package com.cnnnc.www.demo7logger.domain.message;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 作用说明：
 *
 * @author mirror.zhuyanpeng
 * @create 2017-09-13 1:02
 **/
@Repository
public interface MessageRepository extends JpaRepository<MessagePO,Long>{

}
