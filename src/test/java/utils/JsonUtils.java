package utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class JsonUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonUtils.class);
    private static final String DATA_FOLDER_PATH =
            System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
                    + File.separator + "resources" + File.separator + "data";

    private static final String REPO_FOLDER_PATH =
            System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
                    + File.separator + "resources" + File.separator + "repo";


    public static String getDataJsonFilePath(String dataFileName){
        return DATA_FOLDER_PATH + File.separator +dataFileName+ ".json";
    }
    public static String getRepoJsonFilePath(String repoFileName){
        return REPO_FOLDER_PATH + File.separator +repoFileName+ ".json";
    }
}
