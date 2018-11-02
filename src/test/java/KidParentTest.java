import com.kid.driver.AppiumDriverInit;
import com.kid.log4j.LoggerControler;
import com.kid.po.LoginPo;
import com.kid.service.Actions;
import com.kid.service.SwipeScreen;
import com.kid.utils.ExcelUtil;
import com.kid.utils.ScreenShot;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;


public class KidParentTest extends AppiumDriverInit{
    final static LoggerControler logger = LoggerControler.getLoggerControler(KidParentTest.class);

    @BeforeTest
    public void InitDriver(){
        try {
            AppiumDriverInit.openAppInit();
            Thread.sleep(3000);
            logger.info("初始化成功，执行中.....");
        } catch (Exception e) {
            logger.error("初始化失败，执行错误");
        }
    }

    @DataProvider(name = "testData")
    public Object[][] data() {
        ExcelUtil testcase = new ExcelUtil();
        return testcase.testData("F:\\kid.xlsx");
    }


    @Test(dataProvider = "testData")
    public void TestKid(HashMap<String, String> data) throws Exception{
            logger.info("开始滑动引导页......");
        for (int i=1;i<5;i++){
            SwipeScreen.swipeLeft();
            logger.info("引导页面滑动,第"+i+"次....");
        }
        Thread.sleep(1000);
        new TouchAction(driver).tap(PointOption.point(392, 980)).perform().release();
        logger.info("开始查找并读取excel中的测试数据.....");
        Actions.sendKeyValue(By.id(LoginPo.lginInputText),data.get("acct"));
        Actions.clickButton(By.id(LoginPo.loginNextButton));
        Actions.sendKeyValue(By.id(LoginPo.loginNextInputText),data.get("pwd"));
        Actions.clickButton(By.id(LoginPo.loginButton));

        String toast="登录成功";
        try {
            Assert.assertNotNull(Actions.findElement(By.xpath(".//*[contains(@text,'"+ toast + "')]")));
            ScreenShot.screenShots();
            logger.info("找到了==》"+toast);
        } catch (Exception e) {
            logger.error("未找到"+toast+",登录失败");
        }

        Actions.clickButton(By.id(LoginPo.nextButton));
        Actions.clickButton(By.id(LoginPo.allowButton));



    }

    @AfterTest
    public void endTest(){
        try {
            Thread.sleep(5000);
            driver.closeApp();
            driver.quit();
            logger.info("退出成功");
        } catch (InterruptedException e) {
            logger.error("退出异常");
        }

    }
}
