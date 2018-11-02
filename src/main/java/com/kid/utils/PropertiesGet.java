package com.kid.utils;

import com.kid.log4j.LoggerControler;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * 读取初始化配置文件
 */
public class PropertiesGet {
    final static LoggerControler logger = LoggerControler.getLoggerControler(Properties.class);

    public static String getValueProperties(String text){

        String path = System.getProperty("user.dir");
        FileInputStream fs = null ;
        Properties properties = null;
        try {
            File file = new File(path+"/configs/project.properties");
            fs  = new FileInputStream(file);
            properties = new Properties();
            properties.load(fs);
            logger.info("加载配置成功");
        } catch (Exception e) {
            logger.error("加载配置失败");
            e.printStackTrace();
        }
        return  properties.getProperty(text);
    }
}
