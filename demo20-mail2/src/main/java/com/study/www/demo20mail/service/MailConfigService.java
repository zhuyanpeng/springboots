package com.study.www.demo20mail.service;

import com.study.www.demo20mail.model.mail.MailConfig;
import com.study.www.demo20mail.model.mail.MailConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author : THINK.zhuyanpeng
 * @Description: : 获得配置信息，
 * @date :Create in  2018/11/24- 6:56
 * @Version: V1.0
 * @Modified By:
 **/
@Service
public class MailConfigService {
    //在配置信息没有更改得情况下应使用缓存中得配置 ，在本处使用静态全局属性做例子
    public static MailConfig mailConfig=null;

    public static Integer configId = null;

    @Autowired
    MailConfigRepository mailConfigRepository;

    /**
     * 获得最新得配置
     * @return
     */
    public MailConfig findNow(){
        if (mailConfig == null){
            synchronized (MailConfigService.class) {
                if (mailConfig == null){
                    PageRequest pageRequest = new PageRequest(0, 1, Sort.Direction.DESC, "createtime");
                    Page<MailConfig> all = mailConfigRepository.findAll(pageRequest);
                    if (all.getContent() != null && all.getContent().size() > 0) {
                        mailConfig = all.getContent().get(0);
                        configId = mailConfig.getId();
                    }
                }
            }
        }
        return mailConfig;
    }

    /*保存发送次数 当前操作不会影响到静态的全局*/
    public boolean addNumber(){
        MailConfig mailConfig = mailConfigRepository.findOne(Long.valueOf(configId));
        Integer sendnum = mailConfig.getSendnum();
        sendnum =sendnum +1;
        int insert = mailConfigRepository.setNumber(configId, sendnum);
        return insert > 0;
    }
}
