package com.kid.service;

import com.kid.driver.AppiumDriverInit;
import com.kid.log4j.LoggerControler;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * 查找元素和赋值可以直接调用方法，增加了局部等待
 * create_time 2018年10月17日
 */
public class Actions extends AppiumDriverInit {

    final static LoggerControler logger  = LoggerControler.getLoggerControler(Actions.class);

    public static void clickButton(By by){
        try {
            WebDriverWait webDriverWait = new WebDriverWait(driver,10);
            webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
            WebElement element = driver.findElement(by);
            element.click();
            logger.info("您点击的元素是:"+by+"");
        }catch (Exception e){
            logger.error("元素"+by+"查找失败");
            e.printStackTrace();
        }
    }

    public static void sendKeyValue(By by,String value){
        try {
            WebDriverWait webDriverWait = new WebDriverWait(driver,10);
            webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
            WebElement element = driver.findElement(by);
            element.sendKeys(value);
            logger.info("您输入的元素是："+value+"");
        }catch (Exception e){
            logger.error("元素"+by+"查找失败");
            e.printStackTrace();
        }

    }


}
