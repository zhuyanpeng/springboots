package com.study.www.demo20mail.model.mail;

import java.util.Date;

public class AppMailLog {
    private Integer id;

    private String mailhost;

    private String sendmailusername;

    private String senderaddress;

    private String acceptaddress;

    private String subject;

    private Integer status;

    private Date createtime;

    private String createby;

    private Date updatetime;

    private String updateby;

    private Integer isdel;

    private String authcode;

    private String content;

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

    public String getSendmailusername() {
        return sendmailusername;
    }

    public void setSendmailusername(String sendmailusername) {
        this.sendmailusername = sendmailusername == null ? null : sendmailusername.trim();
    }

    public String getSenderaddress() {
        return senderaddress;
    }

    public void setSenderaddress(String senderaddress) {
        this.senderaddress = senderaddress == null ? null : senderaddress.trim();
    }

    public String getAcceptaddress() {
        return acceptaddress;
    }

    public void setAcceptaddress(String acceptaddress) {
        this.acceptaddress = acceptaddress == null ? null : acceptaddress.trim();
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject == null ? null : subject.trim();
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

    public String getAuthcode() {
        return authcode;
    }

    public void setAuthcode(String authcode) {
        this.authcode = authcode == null ? null : authcode.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}