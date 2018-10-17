package com.kid.service;

import com.kid.driver.AppiumDriverInit;
import com.kid.log4j.LoggerControler;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class FindElementUtils extends AppiumDriverInit {

    final static LoggerControler logger = LoggerControler.getLoggerControler(FindElementUtils.class);

    /**
     * 查找单个元素
     * @param by
     * @return
     */
    public static WebElement findElement(By by){
        try {
            WebDriverWait webDriverWait = new WebDriverWait(driver,10);
            webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
        }catch (Exception e){
            logger.error("元素"+by+"查找失败");
            e.printStackTrace();
        }
        return driver.findElement(by);
    }

    /**
     * 查找一个list
     * @param by
     * @return
     */
    public static List<WebElement> findElements(By by){
        List<WebElement> elements = null;
        try{
            WebDriverWait webDriverWait = new WebDriverWait(driver,10);
            webDriverWait.equals(ExpectedConditions.presenceOfElementLocated(by));
        }catch (Exception e){
            logger.error("元素"+by+"查找失败");
            e.printStackTrace();
        }
        return driver.findElements(by);
    }

}
