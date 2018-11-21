package com.study.www.demo20mail.model.mail;

import java.util.Date;

public class AppMailConfig {
    private Integer id;

    private String mailhost;

    private String mailusername;

    private String mailpassword;

    private String nickname;

    private String senderaddress;

    private Integer sendnum;

    private Integer status;

    private Date createtime;

    private String createby;

    private Date updatetime;

    private String updateby;

    private Integer isdel;

    private Integer authcodetime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMailhost() {
        return mailhost;
    }

    public void setMailhost(String mailhost) {
        this.mailhost = mailhost == null ? null : mailhost.trim();
    }

    public String getMailusername() {
        return mailusername;
    }

    public void setMailusername(String mailusername) {
        this.mailusername = mailusername == null ? null : mailusername.trim();
    }

    public String getMailpassword() {
        return mailpassword;
    }

    public void setMailpassword(String mailpassword) {
        this.mailpassword = mailpassword == null ? null : mailpassword.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getSenderaddress() {
        return senderaddress;
    }

    public void setSenderaddress(String senderaddress) {
        this.senderaddress = senderaddress == null ? null : senderaddress.trim();
    }

    public Integer getSendnum() {
        return sendnum;
    }

    public void setSendnum(Integer sendnum) {
        this.sendnum = sendnum;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getCreateby() {
        return createby;
    }

    public void setCreateby(String createby) {
        this.createby = createby == null ? null : createby.trim();
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getUpdateby() {
        return updateby;
    }

    public void setUpdateby(String updateby) {
        this.updateby = updateby == null ? null : updateby.trim();
    }

    public Integer getIsdel() {
        return isdel;
    }

    public void setIsdel(Integer isdel) {
        this.isdel = isdel;
    }

    public Integer getAuthcodetime() {
        return authcodetime;
    }

    public void setAuthcodetime(Integer authcodetime) {
        this.authcodetime = authcodetime;
    }
}