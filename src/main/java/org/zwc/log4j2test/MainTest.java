package org.zwc.log4j2test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by zhangwenchao on 2017/10/30.
 */
public class MainTest {


    private static final Logger logger = LoggerFactory.getLogger(MainTest.class);

    public static void main(String[] args) {

        logger.debug("log4j2日志测试--debug");
        logger.info("log4j2日志测试--info");
        logger.warn("log4j2日志测试--warn");
        logger.error("log4j2日志测试--error");


    }



}
