package com.study.www.demo20mail.model.mail;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * MailLogRepository:
 *
 * @auther : THINK.zhuyanpeng
 * @date :  2018/11/24    6:48
 **/
public interface MailLogRepository extends JpaRepository<MailLog,Long> {

    MailLog findByAcceptaddress(String acceptAddress);
}
