package com.study.www.demo20mail.model.mail;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.Date;
@Entity
@Data
@Table(name="mail_log")
public class MailLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition = "发件人地址")
    private String senderaddress;
    @Column(columnDefinition = "收件人地址")
    private String acceptaddress;
    @Column(columnDefinition = "主题--对应着邮件中得title")
    private String subject;
    @Column(columnDefinition = "验证码")
    private String authcode;
    @Column(columnDefinition = "内容-可为空")
    private String content;
    @Column(columnDefinition = "验证码有效时间")
    private String authcodeTime;
    private Integer status;

    private Date createtime;

    private String createby;

    private Date updatetime;

    private String updateby;

    private Integer isdel;

}