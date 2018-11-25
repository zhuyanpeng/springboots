package com.study.www.demo20mail.model.mail;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * MailConfigRepository:
 *
 * @auther : THINK.zhuyanpeng
 * @date :  2018/11/24    6:47
 **/
public interface MailConfigRepository extends JpaRepository<MailConfig,Long>, JpaSpecificationExecutor<MailConfig> {
    @Query("from MailConfig mc order by createtime desc")
    List<MailConfig> findNow();


    @Transactional
    @Modifying
    @Query("update MailConfig mc set  mc.sendnum=:sendnum where mc.id= :id")
    int setNumber(@Param("sendnum") Integer sendnum, @Param("id") Integer id);
}
