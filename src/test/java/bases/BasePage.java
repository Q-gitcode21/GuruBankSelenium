package bases;

import com.jayway.jsonpath.JsonPath;
import common.keywords.WebUI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.JsonUtils;

import java.io.File;

public class BasePage {
    protected WebUI webUI;
    protected final Logger LOGGER = LoggerFactory.getLogger(BasePage.class);
    private String repoFilePath;

    public BasePage (WebUI webUI){
        this.webUI=webUI;
    }

    protected void setRepoFilePath(String repoName){
        this.repoFilePath = JsonUtils.getRepoJsonFilePath(repoName);
    }
    protected String findLocator(String locatorName) {
        try {
            File file = new File(repoFilePath);
            return JsonPath.parse(file).read("$." + locatorName);

        } catch (Exception e) {
            LOGGER.error("Failed to find locator '{}' in json file.Root cause: {}", locatorName, e.getMessage());
        }
        return null;
    }
}


