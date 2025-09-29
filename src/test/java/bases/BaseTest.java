package bases;

import com.jayway.jsonpath.JsonPath;
import common.keywords.WebUI;
import io.qameta.allure.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;
import pages.LoginPage;
import utils.JsonUtils;

import java.io.File;
import java.lang.reflect.Method;

public class BaseTest {
    protected WebUI webUI;
    protected final Logger LOGGER = LoggerFactory.getLogger(BaseTest.class);
    private String dataFilePath;
    protected LoginPage objLogin;

    protected void setDataFilePath(String dataFileName){
        this.dataFilePath = JsonUtils.getDataJsonFilePath(dataFileName);
    }
    protected String findTestData(String testData) {
        try {
            File file = new File(dataFilePath);
            return JsonPath.parse(file).read("$." + testData);

        } catch (Exception e) {
            LOGGER.error("Failed to find test data '{}' in json file.Root cause: {}", testData, e.getMessage());
        }
        return null;
    }

    @BeforeTest(alwaysRun = true)
    @Parameters(value = {"browser","loginUrl"})
    public void beforeTest(String browser,String loginUrl) {
        LOGGER.info("====================Before Test=======================");
        webUI = new WebUI();
        webUI.openBrowser(browser);
        webUI.maximumWindow();
        objLogin = moveToLoginPage(loginUrl);
    }

    @BeforeClass
    public void beforeClass() {
        LOGGER.info("====================Before Class {} ===================", this.getClass().getName());

    }

    @BeforeMethod
    public void setUp(Method method) {
        LOGGER.info("=================Before Method {} =====================", method.getName());

    }

    @AfterMethod
    public void tearDown(Method method) {
        LOGGER.info("==================After method {} ======================", method.getName());
    }

    @AfterClass
    public void afterClass() {
        LOGGER.info("===================After Class {} =====================", this.getClass().getName());
    }

    @AfterTest(alwaysRun = true)
    public void afterTest() {
        LOGGER.info("=====================After Test======================");
        webUI.closeBrowser();
    }
    @Step("Move to login page")
    public LoginPage moveToLoginPage(String loginUrl) {
        webUI.navigateToUrl(loginUrl);
        return new LoginPage(webUI);

    }

}
