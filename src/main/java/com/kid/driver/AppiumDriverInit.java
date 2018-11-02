package com.kid.driver;

import com.kid.log4j.LoggerControler;
import com.kid.utils.PropertiesGet;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class AppiumDriverInit {

    public static AppiumDriver driver;
    final static LoggerControler logger = LoggerControler.getLoggerControler(AppiumDriverInit.class);

    public static void openAppInit() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName",PropertiesGet.getValueProperties("deviceName"));
        capabilities.setCapability("platformVersion", PropertiesGet.getValueProperties("platformVersion"));
        capabilities.setCapability("platformName",PropertiesGet.getValueProperties("platformName"));
        capabilities.setCapability("appPackage", PropertiesGet.getValueProperties("appPackage"));
        capabilities.setCapability("appActivity",PropertiesGet.getValueProperties("appActivity"));
        capabilities.setCapability("automationName", PropertiesGet.getValueProperties("automationName"));
        capabilities.setCapability("autoAcceptAlerts",  PropertiesGet.getValueProperties("autoAcceptAlerts"));

        driver = new AppiumDriver(new URL(PropertiesGet.getValueProperties("url")), capabilities);
    }

}
