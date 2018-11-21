package com.study.www.demo20mail.service;

import cn.xunjie.www.config.MailSenderConfig;
import cn.xunjie.www.enums.CNEnum;
import cn.xunjie.www.model.common.mail.AppMailConfig;
import cn.xunjie.www.model.common.mail.AppMailConfigExample;
import cn.xunjie.www.model.common.mail.AppMailLog;
import cn.xunjie.www.model.common.mail.AppMailLogExample;
import cn.xunjie.www.model.common.mail.mapper.AppMailConfigMapper;
import cn.xunjie.www.model.common.mail.mapper.AppMailLogMapper;
import cn.xunjie.www.utils.DateUtils;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.study.www.demo20mail.model.mail.AppMailConfig;
import com.study.www.demo20mail.model.mail.AppMailConfigExample;
import com.study.www.demo20mail.model.mail.AppMailLog;
import com.study.www.demo20mail.model.mail.mapper.AppMailConfigMapper;
import com.study.www.demo20mail.model.mail.mapper.AppMailLogMapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.MessagingException;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author : Dell.zhuyanpeng
 * @Description: : 邮件服务
 * @date :Create in  2018/10/17- 14:29
 * @Version: V1.0
 * @Modified By:
 **/
@Service
@Slf4j
public class MailService {
    @Autowired
    AppMailLogMapper mailLogMapper;
    @Autowired
    AppMailConfigMapper mailConfigMapper;

    private boolean saveMailLog(AppMailLog appMailLog) throws MessagingException, IOException {
        appMailLog.setStatus(Integer.valueOf(CNEnum.SEEK_ISDEL_EXIST.getCode()));
        appMailLog.setCreatetime(new Date());
        appMailLog.setUpdatetime(new Date());
        appMailLog.setCreateby("99999");
        appMailLog.setUpdateby("99999");
        int insert = mailLogMapper.insert(appMailLog);
        return insert > 0;
    }

    public AppMailConfig findConfig(){
        AppMailConfigExample example = new AppMailConfigExample();
        PageHelper.orderBy("id desc");
        List<AppMailConfig> appMailConfigs = mailConfigMapper.selectByExample(example);
        // 修改发送次数+1
        AppMailConfig appMailConfig = appMailConfigs.get(0);
        appMailConfig.setSendnum(appMailConfig.getSendnum()+1);
        mailConfigMapper.updateByPrimaryKeySelective(appMailConfig);
        return appMailConfig;
    }
    /*每次修改就是一次保存，操作留痕*/
    public boolean saveConfig(AppMailConfig config){
        log.warn("******[date:"+ DateUtils.getDateFormat(new Date(), DateUtils.YYYYMMDDHHMMSS)+"]***********[save]===============>[saveMailLogConfig]");
        int insert = mailConfigMapper.insert(config);
        return insert > 0;
    }

    /**
     * 根据模板名称查找模板，加载模板内容后发送邮件
     * receiver  收件人地址
     * subject 邮件主题
     * map 内容
     */
    @Transactional
    public void sendMailByTemplate(String receiver, String subject,
                                   Map<String, String> map, String templateName) throws IOException,
            TemplateException, MessagingException {
        AppMailConfig config = this.findConfig();
        MailSenderConfig mail = new MailSenderConfig(config.getMailhost());
        mail.setNamePass(config.getMailusername(), config.getMailpassword(), config.getNickname());
        map.put("authCodeTime",String.valueOf(config.getAuthcodetime())+"秒");
        String maiBody = this.generateHtmlFromFtl(templateName, map);
        mail.setSubject(subject);
        mail.setBody(maiBody);
        mail.setReceiver(receiver);
        mail.setSender(config.getSenderaddress());
        mail.sendout();
        //保存记录
        writeLog(config,receiver,subject,maiBody,map);
    }

    /**
     * 编辑文本发送邮件内容
     * receiver  收件人地址
     * subject 邮件主题
     * maiBody 邮件正文
     */
    public void sendMail(String receiver, String subject, String maiBody)
            throws IOException, MessagingException {
        AppMailConfig config = this.findConfig();
        MailSenderConfig mail = new MailSenderConfig(config.getMailhost());
        mail.setNamePass(config.getMailusername(), config.getMailpassword(), config.getNickname());
        mail.setSubject(subject);
        mail.setBody(maiBody);
        mail.setReceiver(receiver);
        mail.setSender(config.getSenderaddress());
        mail.sendout();
        //保存记录
        writeLog(config,receiver,subject,maiBody,null);
    }

    /**
     * 校验邮箱有效时间是否超过
     * @param mailStr
     * @param time
     * @return
     */
    public boolean validateMail(String mailStr,Date time){
        AppMailConfig config = this.findConfig();
        AppMailLogExample example = new AppMailLogExample();
        example.createCriteria().andAcceptaddressEqualTo(mailStr);
        PageHelper.orderBy("CreateTime desc");
        List<AppMailLog> appMailLogs = mailLogMapper.selectByExample(example);
        if (appMailLogs == null || appMailLogs.size() == 0){
            return false;
        }
        Date createtime = appMailLogs.get(0).getCreatetime();
        Integer authcodetime = config.getAuthcodetime();
        return authcodetime > ((time.getTime() - createtime.getTime()) / 1000);
    }


    public AppMailLog query(String mailStr,Date time){
        AppMailConfig config = this.findConfig();
        AppMailLogExample example = new AppMailLogExample();
        AppMailLogExample.Criteria criteria = example.createCriteria();
        criteria.andAcceptaddressEqualTo(mailStr);
        if (time != null){
            criteria.andCreatetimeBetween(new Date(time.getTime()-config.getAuthcodetime()*1000),time);
        }
        PageHelper.orderBy(" CreateTime desc");
        List<AppMailLog> appMailLogs = mailLogMapper.selectByExample(example);
        if (appMailLogs != null && appMailLogs.size() > 0){
            return appMailLogs.get(0);
        }
        return null;
    }

    private  String generateHtmlFromFtl(String name,
                                        Map<String, String> map) throws IOException, TemplateException {
        Writer out = new StringWriter(2048);
        Template temp = MailSenderConfig.TEMPLATECONF.getTemplate(name);
        temp.process(map, out);
        return out.toString();
    }

    /**
     * 发送邮件写入日志
     * @param config
     * @param receiver
     * @param subject
     * @param maiBody
     * @param map
     * @return
     * @throws IOException
     * @throws MessagingException
     */
    private boolean writeLog(AppMailConfig config, String receiver, String subject, String maiBody,Map<String, String> map) throws IOException, MessagingException {
        AppMailLog appMailLog = new AppMailLog();
        appMailLog.setMailhost(config.getMailhost());
        appMailLog.setSenderaddress(config.getSenderaddress());
        appMailLog.setSendmailusername(config.getMailusername());
        appMailLog.setAcceptaddress(receiver);
        appMailLog.setSubject(subject);
        appMailLog.setContent(maiBody);
        appMailLog.setAuthcode(JSON.toJSONString(map));
        return this.saveMailLog(appMailLog);

    }

    /**
     * 校验邮箱配置
     * @param mailUserName
     * @param mailHost
     * @param mailPassword
     * @param map
     */
    public void validateMailConfig(String mailUserName, String mailHost, String mailPassword, String subject,
                                   Map<String, String> map, String templateName)  throws IOException,
            TemplateException, MessagingException {
        MailSenderConfig mail = new MailSenderConfig(mailHost);
        mail.setNamePass(mailUserName, mailPassword, mailUserName);
        map.put("authCodeTime","120秒");
        String maiBody = this.generateHtmlFromFtl(templateName, map);
        mail.setSubject(subject);
        mail.setBody(maiBody);
        mail.setReceiver(mailUserName);
        mail.setSender(mailUserName);
        mail.sendout();
        //保存记录
        AppMailLog appMailLog = new AppMailLog();
        appMailLog.setMailhost(mailHost);
        appMailLog.setSenderaddress(mailUserName);
        appMailLog.setSendmailusername(mailUserName);
        appMailLog.setAcceptaddress(mailUserName);
        appMailLog.setSubject(subject);
        appMailLog.setContent(maiBody);
        appMailLog.setAuthcode(JSON.toJSONString(map));
        this.saveMailLog(appMailLog);
    }
}
