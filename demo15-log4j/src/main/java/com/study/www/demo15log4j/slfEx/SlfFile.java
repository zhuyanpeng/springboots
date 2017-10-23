package com.study.www.demo15log4j.slfEx;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * SlfFile:
 *
 * @auther : Administrator.zhuyanpeng
 * @date : 2017/10/11    15:24
 **/
@Component
public class SlfFile {
    private Logger logger = LogManager.getLogger(getClass().getName());
    public void log() throws Exception {
        logger.info("logEx---info");
        logger.debug("logEx---debug");
        logger.error("logEx---error");
    }
}
