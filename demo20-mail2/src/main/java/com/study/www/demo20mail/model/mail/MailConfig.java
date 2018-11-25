package com.study.www.demo20mail.model.mail;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.Date;
@Entity
@Data
@Table(name="mailConfig")
public class MailConfig {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition = "smtp地址")
    private String smtp;
    @Column(columnDefinition = "邮箱密码")
    private String mailpassword;
    @Column(columnDefinition = "邮箱地址")
    private String senderaddress;
    @Column(columnDefinition = "发送次数")
    private Integer sendnum;
    @Column(columnDefinition = "状态")
    private Integer status;
    @Column(columnDefinition = "邮箱验证码有效时间")
    private Integer authcodetime;
    private Date createtime;

    private String createby;

    private Date updatetime;

    private String updateby;

    private Integer isdel;




}