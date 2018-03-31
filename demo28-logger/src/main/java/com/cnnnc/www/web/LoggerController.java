package com.cnnnc.www.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Administrator.zhuyanpeng
 * @Description: :
 * @date :Create in  2018/2/1- 19:16
 * @Version: V1.0
 * @Modified By:
 **/
@RestController
public class LoggerController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @GetMapping("/testLog")
    public String testLogLevel() {
        logger.debug("debug 级别的");
        logger.info("info 级别的");
        logger.error("eror 级别的");
        return "";
    }
}