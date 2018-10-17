package com.kid.driver;

import com.kid.log4j.LoggerControler;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class AppiumDriverInit {

    public static AppiumDriver driver;
    final static LoggerControler logger = LoggerControler.getLoggerControler(AppiumDriverInit.class);

    public static void openAppInit() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","Android Emulator");
        capabilities.setCapability("platformVersion", "8.0");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("appPackage", "com.yiqizhangda.parent.test");
        capabilities.setCapability("appActivity","com.kid17.parent.ui.splash.SplashActivity" );
        capabilities.setCapability("appWaitActivity","com.kid17.parent.ui.splash.SplashActivity" );
        driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

}
