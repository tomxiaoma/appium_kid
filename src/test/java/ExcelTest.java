import com.kid.utils.ExcelUtil;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;

public class ExcelTest {

    @DataProvider(name = "testData")
    public Object[][] data() {
        ExcelUtil testcase = new ExcelUtil();
        return testcase.testData("F:\\kid.xlsx");
    }

    @Test(dataProvider = "testData")
    public void testCase(HashMap<String, String> data) {
        System.out.println(data.get("acct"));
        System.out.println(data.get("pwd"));
    }
}
