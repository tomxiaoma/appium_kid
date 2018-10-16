import com.kid.driver.AppiumDriverInit;
import com.kid.log4j.LoggerControler;
import com.kid.server.SwipeScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;


public class KidParentTest extends AppiumDriverInit{
    final static LoggerControler logger = LoggerControler.getLoggerControler(KidParentTest.class);

    @BeforeTest
    public void InitDriver(){
        try {
            AppiumDriverInit.openAppInit();
            Thread.sleep(3000);
            logger.error("初始化成功，执行中.....");
        } catch (Exception e) {
            logger.error("初始化失败，执行错误");
        }
    }

    @Test
    public void TestKid() throws Exception{
        for (int i=1;i<6;i++){
            logger.info("引导页面滑动,第"+i+"次....");
            SwipeScreen.swipeLeft(driver);
        }
        Thread.sleep(1000);
        new TouchAction(driver).tap(PointOption.point(392, 980)).perform().release();
        driver.findElementById("com.yiqizhangda.parent.test:id/et_phone_activity_login").sendKeys("15900796431");
        driver.findElementById("com.yiqizhangda.parent.test:id/btn_nextstep_activity_login").click();
        Thread.sleep(1000);
        driver.findElementById("com.yiqizhangda.parent.test:id/et_pwd_activity_input_pwd").sendKeys("123123");
        driver.findElementById("com.yiqizhangda.parent.test:id/btn_next_step_activity_input_pwd").click();
    }

    @AfterTest
    public void endTest(){
        try {
            Thread.sleep(1000);
            driver.closeApp();
            driver.quit();
            logger.info("退出成功");
        } catch (InterruptedException e) {
            logger.error("退出异常");
        }

    }
}
