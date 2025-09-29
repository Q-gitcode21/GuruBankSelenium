package pages;

import bases.BasePage;
import common.keywords.WebUI;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;

public class LoginPage extends BasePage {
    public LoginPage(WebUI webUI){
        super(webUI);
        setRepoFilePath(LoginPage.class.getSimpleName());
    }

    @Step("Input User Id: {0}")
    public void inputUserId(String userId) {
        // if check lbl userid error
        if (userId.isEmpty()) {
            webUI.pressKeys(findLocator("TXT_USER_ID"), Keys.TAB);
        } else {
            webUI.inputText(findLocator("TXT_USER_ID"), userId);
        }
        webUI.takeScreenShotAndMarkElement(findLocator("TXT_USER_ID"));

    }

    @Step("Input Password: {0}")
    public void inputPassword(String password) {
        // if check lbl password error
        if (password.isEmpty()) {
            webUI.pressKeys(findLocator("TXT_PASSWORD"), Keys.TAB);
        } else {
            webUI.inputText(findLocator("TXT_PASSWORD"), password);
        }
        webUI.takeScreenShotAndMarkElement(findLocator("TXT_PASSWORD"));

    }

    @Step("Click Login button")
    public ManagerPage clickLoginBtn() {
        webUI.takeScreenShot(findLocator("BTN_LOGIN"));
        webUI.click(findLocator("BTN_LOGIN"));
        webUI.delayInSecond(3);
        webUI.takeScreenShot();
        return new ManagerPage(webUI);
    }

    @Step("Login Guru with userId '{0}' and password '{1}'")
    public ManagerPage loginWith(String userId,String password){
        inputUserId(userId);
        inputPassword(password);
        return clickLoginBtn();
    }

    @Step("Should show User Id error message: {0}")
    public boolean shouldShowUserIdErrorMessage(String expectedErrorMessage) {
        if (webUI.verifyElementText(findLocator("LBL_USER_ID_ERROR"), expectedErrorMessage)) {
            webUI.takeScreenShot(findLocator("LBL_USER_ID_ERROR"));
            return true;
        }
        return false;
    }
    @Step("Should show Password error message: {0}")
    public boolean shouldShowPasswordErrorMessage(String expectedErrorMessage) {
        if (webUI.verifyElementText(findLocator("LBL_PASSWORD_ERROR"), expectedErrorMessage)) {
            webUI.takeScreenShot(findLocator("LBL_PASSWORD_ERROR"));
            return true;
        }
        return false;
    }

}
