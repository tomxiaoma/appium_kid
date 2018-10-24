package com.kid.po;

/**
 * 登录页面(包含首页和下一页)
 */
public class LoginPo {

    /**
     * 登录文本框选择
     */
    public static String lginInputText = "com.yiqizhangda.parent.test:id/et_phone_activity_login";

    /**
     * 下一步按钮
     */
    public static String loginNextButton = "com.yiqizhangda.parent.test:id/btn_nextstep_activity_login";

    /**
     * 下一步输入密码文本框
     */
    public static String loginNextInputText = "com.yiqizhangda.parent.test:id/et_pwd_activity_input_pwd";

    /**
     * 登录按钮
     */
    public static String loginButton = "com.yiqizhangda.parent.test:id/btn_next_step_activity_input_pwd";


    /**
     * 跳过
     */

    public static String nextButton="com.yiqizhangda.parent.test:id/btn_skip_activity_guide";

    /**
     * 权限设置允许
     */

    public static String allowButton = "com.android.packageinstaller:id/permission_allow_button";


    /**
     * 登录成功
     */
    public static String loginSuccess = ".//*[contains(@text,'\"登录成功\"')]";
}
