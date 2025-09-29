package pages;

import bases.BasePage;
import common.keywords.WebUI;

public class ManagerPage extends BasePage {
    public ManagerPage(WebUI webUI) {
        super(webUI);
        setRepoFilePath(ManagerPage.class.getSimpleName());
    }

    public boolean shouldShowManagerId(String managerId) {
        if (webUI.verifyElementText(findLocator("LBL_MANAGER_ID"), managerId)) {
            webUI.takeScreenShot(findLocator("LBL_MANAGER_ID"));
            return true;
        }
        return false;

    }
}
