package Qmetry;

import java.io.File;
import java.util.Properties;

import static Utilities.LoadProperties.loadProperties;

public class QmetryConstants {

    public static final String INTEGRATION_EANBLED = "automation.Qmetry.enabled";
    public static final String API_TYPE = "automation.Qmetry.apitype";
    public static final String API_KEY = "automation.Qmetry.apikey";
    public static final String API_URL = "automation.Qmetry.url";
    public static final String FILE_PATH = "automation.Qmetry.filepath";
//    public static String FILE_PATH = new File("/target/surefire-reports/testng-results.xml").getAbsolutePath();
    public static final String AUTHORIZATION = "automation.Qmetry.authorization";
    public static final String USERNAME = "automation.Qmetry.username";
    public static final String PASSWORD = "automation.Qmetry.password";
    public static final String TEST_RUN_NAME = "automation.Qmetry.testrunname";
    public static final String LABELS = "automation.Qmetry.labels";
    public static final String COMPONENTS = "automation.Qmetry.components";
    public static final String VERSION = "automation.Qmetry.version";
    public static final String SPRINT = "automation.Qmetry.sprint";
    public static final String PLATFORM = "automation.Qmetry.platform";
    public static final String COMMENT = "automation.Qmetry.comment";
    public static final String TEST_RUN_KEY = "automation.Qmetry.testrunkey";
    public static final String TEST_ASSET_HIERARCHY = "automation.Qmetry.testassethierarchy";
    public static final String JIRA_FIELDS = "automation.Qmetry.jirafields";
    public static final String DEBUG = "automation.Qmetry.debug";
    public static final String TESTCASE_UPDATE_LEVEL = "automation.Qmetry.testcaseupdatelevel";
    public static final String ATTACHE_FILE = "automation.Qmetry.attachefile";
//    public static Properties p;
public static Properties p =
        loadProperties(System.getProperty("user.dir") +
                File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "qmetry.properties");

}
