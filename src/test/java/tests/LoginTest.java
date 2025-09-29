package tests;

import bases.BaseTest;
import org.testng.annotations.Test;
import pages.ManagerPage;

import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {
    private ManagerPage objManager;

    public LoginTest (){
        setDataFilePath(LoginTest.class.getSimpleName());
    }

    @Test(description = "Show error message 'User-ID must not be blank' after press key TAB")
    public void LG001_should_show_user_id_must_not_be_blank_after_pressed_key_tab() {
        objLogin.inputUserId(findTestData("LG001.USER_ID"));
        objLogin.shouldShowUserIdErrorMessage(findTestData("LG001.ERROR_MESSAGE"));
    }

    @Test(description = "Show error message 'Password must not be blank' after press key TAB")
    public void LG002_should_show_password_must_not_be_blank_after_pressed_key_tab() {
        objLogin.inputPassword(findTestData("LG002.USER_ID"));
        objLogin.shouldShowPasswordErrorMessage(findTestData("LG002.ERROR_MESSAGE"));
    }

    @Test(description = "Login successfully")
    public void LG003_login_successfully() {

        objManager = objLogin.loginWith(findTestData("LG003.USER_ID"), findTestData("LG003.PASSWORD"));
        assertTrue(objManager.shouldShowManagerId(findTestData("LG003.MANAGER_ID") + findTestData("LG003.USER_ID")));
    }
}
