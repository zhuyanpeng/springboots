package com.study.www.demo20mail.model.mail;


import freemarker.template.Configuration;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import freemarker.template.Template;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

/**
 * @author : Dell.zhuyanpeng
 * @Description: : 邮件发送
 * @date :Create in  2018/10/17- 13:55
 * @Version: V1.0
 * @Modified By:
 **/
@Slf4j
@Getter
@Setter
public class MailSenderConfig {
    private MimeMessage mimeMsg; // MIME邮件对象
    private Session session; // 邮件会话对象
    private Properties props; // 系统属性
    private Multipart mp; // Multipart对象,邮件内容,标题,附件等内容均添加到其中后再生成
    private String username;// 发件人的用户名
    private String password;// 发件人的密码
    private String receiverAddress;//收件人地址
    private String senderAddress;//发件人地址
    private String subject; //主题

    public static Configuration TEMPLATECONF = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
    static {
        TEMPLATECONF.setClassForTemplateLoading(MailSenderConfig.class,"/templates/");
    }


    public MailSenderConfig() {
    }

    public MailSenderConfig(String smtp) {
        if (props == null){
            props = new Properties();
        }
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", smtp);
        createMimeMessage();
    }

    public void createMimeMessage() {
        // 获得邮件会话对象
        session = Session.getDefaultInstance(props, null);
        // 创建MIME邮件对象
        mimeMsg = new MimeMessage(session);
        mp = new MimeMultipart();
    }

    /**
     * 设置发送邮件的主题
     */
    public void setSubject(String subject) throws UnsupportedEncodingException,
            MessagingException {
        mimeMsg.setSubject(MimeUtility.encodeText(subject, "utf-8", "B"));
        log.debug("set mail subject success, subject= " + subject);

    }

    /**
     *  邮件的正文内容
     */
    public void setBody(String mailBody) throws MessagingException {
        BodyPart bp = new MimeBodyPart();
        bp.setContent("" + mailBody, "text/html;charset=utf-8");
        mp.addBodyPart(bp);
        log.debug("set mail body content success,mailBody= " + mailBody);
    }

    /**
     * 添加邮件附件
     */
    public void addFileAffix(String filePath) throws MessagingException {
        BodyPart bp = new MimeBodyPart();
        FileDataSource fileds = new FileDataSource(filePath);
        bp.setDataHandler(new DataHandler(fileds));
        bp.setFileName(fileds.getName());
        mp.addBodyPart(bp);
        log.debug("mail add file success,filename= " + filePath);
    }

    /**
     * 设置发件人邮箱地址
     */
    public void setSender(String sender) throws UnsupportedEncodingException,
            AddressException, MessagingException {
        mimeMsg.setFrom(new InternetAddress(MimeUtility.encodeText(sender, "utf-8", "B") + " <" + sender + ">"));
        this.senderAddress=sender;

    }

    /**
     * 设置收件人邮箱地址
     */
    public void setReceiver(String receiver) throws AddressException,
            MessagingException {
        mimeMsg.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(receiver));
        log.debug("set mail receiver success,receiver = " + receiver);
        this.receiverAddress = receiver;
    }

    /**
     * 设置发件人用户名密码进行发送邮件操作
     */
    public void sendout() throws MessagingException {
        mimeMsg.setContent(mp);
        mimeMsg.saveChanges();
        Session mailSession = Session.getInstance(props, null);
        Transport transport = mailSession.getTransport("smtp");
        transport.connect((String) props.get("mail.smtp.host"), username,
                password);
        transport.sendMessage(mimeMsg,
                mimeMsg.getRecipients(Message.RecipientType.TO));
        transport.close();
        log.debug(" send mail success");
    }

    /**
     * 注入发件人用户名 ，密码 ，昵称
     */
    public void setNamePass(String username, String password, String nickname) throws UnsupportedEncodingException, MessagingException {
        this.username = username;
        this.password = password;
        //默认情况下发件人邮件地址为发件人的用户名和密码若无特殊需求不用进行修改
        this.setSender(nickname);
    }



}
