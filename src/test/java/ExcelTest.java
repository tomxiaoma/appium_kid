import com.kid.utils.ExcelUtil;
import io.qameta.allure.Feature;
import io.qameta.allure.Stories;
import io.qameta.allure.Story;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;

public class ExcelTest {

    @DataProvider(name = "testData")
    public Object[][] data() {
        ExcelUtil testcase = new ExcelUtil();
        return testcase.testData("F:\\kid.xlsx");
    }


    @Feature("数据源")
    @Stories(value = {@Story(value="提取数据源中数据")})
    @Test(dataProvider = "testData")
    public void testCase(HashMap<String, String> data) {
        System.out.println(data.get("acct"));
        System.out.println(data.get("pwd"));
    }
}
