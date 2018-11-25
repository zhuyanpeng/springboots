package com.study.www.demo20mail.service;

import com.study.www.demo20mail.model.mail.MailConfig;
import com.study.www.demo20mail.model.mail.MailLog;
import com.study.www.demo20mail.model.mail.MailLogRepository;
import com.study.www.demo20mail.model.mail.MailSenderConfig;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.MessagingException;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Date;
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
    //此参数可以从枚举中去配置获得
  private final Integer STATUS=0;
  // 是否保存邮件内容，此操作看需求进行开启若开启得话会对表得数据量有点大
  private final boolean isContentExit = false;


    @Autowired
    MailLogRepository mailLogRepository;
    @Autowired
    MailConfigService configService;



    /**
     * 根据模板名称查找模板，加载模板内容后发送邮件
     * receiver  收件人地址
     * subject 邮件主题 和模板名称一模一样 可以做个字典配置
     * map 内容 必须包含   authCode:验证码
     *
     */
    @Transactional
    public void sendMailByTemplate(String receiver, String subject,
                                   Map<String, String> map, String templateName) throws IOException,
            TemplateException, MessagingException {
        MailConfig config = configService.findNow();
        MailSenderConfig mail = new MailSenderConfig(config.getSmtp());
        map.put("userName",receiver); //具体模板具体对待
        mail.setNamePass(config.getSenderaddress(), config.getMailpassword(), config.getMailpassword());
        map.put("authCodeTime",String.valueOf(config.getAuthcodetime()));
        String maiBody = this.generateHtmlFromFtl(templateName, map);
        mail.setSubject(subject);
        mail.setBody(maiBody);
        mail.setReceiver(receiver);
        mail.setSender(config.getSenderaddress());
        mail.sendout();
        //保存记录
        writeLog(config,receiver,mail,map);
    }

    /**
     * 编辑文本发送邮件内容
     * receiver  收件人地址
     * subject 邮件主题
     * maiBody 邮件正文
     */
    public void sendMail(String receiver, String subject,Map<String, String> map, String maiBody)
            throws IOException, MessagingException {
        MailConfig config = configService.findNow();
        MailSenderConfig mail = new MailSenderConfig(config.getSmtp());
        mail.setNamePass(config.getSenderaddress(), config.getMailpassword(), config.getMailpassword());
        mail.setSubject(subject);
        mail.setBody(maiBody);
        mail.setReceiver(receiver);
        mail.setSender(config.getSenderaddress());
        mail.sendout();
        //保存记录
        writeLog(config,receiver,mail,map);
    }

    /**
     * 校验邮箱有效时间是否超过
     * @param mailStr
     * @param time
     * @return
     */
    public boolean validateMail(String mailStr,Date time){
        MailConfig config = configService.findNow();
        PageRequest qageRequest = new PageRequest(0, 1, Sort.Direction.DESC, "createtime");
        Page<MailLog> mailLogs = mailLogRepository.findAll(qageRequest);
        if (mailLogs == null || mailLogs.getContent().size() == 0){
            return false;
        }
        Date createtime = mailLogs.getContent().get(0).getCreatetime();
        Integer authcodetime = config.getAuthcodetime();
        return authcodetime > ((time.getTime() - createtime.getTime()) / 1000);
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
     * @param map
     * @return
     * @throws IOException
     * @throws MessagingException
     */

    @Async
    public void writeLog(MailConfig config, String receiver, MailSenderConfig mail,Map<String, String> map) {
        MailLog mailLog = new MailLog();
        mailLog.setSenderaddress(config.getSenderaddress());
        mailLog.setAcceptaddress(receiver);
        mailLog.setSubject(mail.getSubject());
        mailLog.setAuthcode(map.get("authcode"));
        mailLog.setAuthcodeTime(map.get("authcodeTime"));
        mailLog.setStatus(STATUS);
        mailLog.setCreatetime(new Date());
        mailLog.setUpdatetime(new Date());
        if (!isContentExit){
            mailLog.setContent(null);
        }
        mailLog.setCreateby("99999");
        mailLog.setUpdateby("99999");
        MailLog save = mailLogRepository.save(mailLog);
    }

}
