package com.kid.service;

import com.kid.driver.AppiumDriverInit;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;


/**
 * createTime:2018年10月16
 * 执行滑动
 *
 */
public class SwipeScreen extends AppiumDriverInit {

    /**
     *向上滑动屏幕
     * @param driver
     */
    public static void swipeUp() {

        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        TouchAction action = new TouchAction(driver).press(PointOption.point(width / 2, height * 4 / 5)).
                moveTo(PointOption.point(width / 2, height / 4)).release();
        action.perform();
    }

    /**
     *向下滑动屏幕
     * @param driver
     */
    public static void swipeDown() {
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        TouchAction action = new TouchAction(driver).press(PointOption.point(width / 2, height / 4))
                .moveTo(PointOption.point(width / 2, height * 3 / 4)).release();
        action.perform();
    }

    /**
     *向左滑动屏幕
     * @param driver
     */
    public static void swipeLeft() {
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        TouchAction action = new TouchAction(driver).press(PointOption.point(width * 3 / 4, height / 2))
                .moveTo(PointOption.point(width / 10, height / 2)).release().perform();
        action.perform();
    }

    /**
     *向右滑动屏幕
     * @param driver
     */
    public static void swipeRight() {
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        TouchAction action = new TouchAction(driver).press(PointOption.point(10, height / 2))
                .moveTo(PointOption.point(width * 3 / 4 + 10, height / 2)).release();
        action.perform();
    }


    public static void tochButton(){
        (new TouchAction(driver)).press(PointOption.point(152, 709))
                .moveTo(PointOption.point(169,706)).release().perform();
    }



}
