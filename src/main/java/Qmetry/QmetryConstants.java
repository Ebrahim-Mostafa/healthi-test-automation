package Qmetry;

import java.io.File;
import java.util.Properties;

import static Utilities.LoadProperties.loadProperties;

public class QmetryConstants {

    public static final String INTEGRATION_EANBLED = "automation.qmetry.enabled";
    public static final String API_TYPE = "automation.qmetry.apitype";
    public static final String API_KEY = "automation.qmetry.apikey";
    public static final String API_URL = "automation.qmetry.url";
    public static final String FILE_PATH = "automation.qmetry.filepath";
//    public static String FILE_PATH = new File("/target/surefire-reports/testng-results.xml").getAbsolutePath();
    public static final String AUTHORIZATION = "automation.qmetry.authorization";
    public static final String USERNAME = "automation.qmetry.username";
    public static final String PASSWORD = "automation.qmetry.password";
    public static final String TEST_RUN_NAME = "automation.qmetry.testrunname";
    public static final String LABELS = "automation.qmetry.labels";
    public static final String COMPONENTS = "automation.qmetry.components";
    public static final String VERSION = "automation.qmetry.version";
    public static final String SPRINT = "automation.qmetry.sprint";
    public static final String PLATFORM = "automation.qmetry.platform";
    public static final String COMMENT = "automation.qmetry.comment";
    public static final String TEST_RUN_KEY = "automation.qmetry.testrunkey";
    public static final String TEST_ASSET_HIERARCHY = "automation.qmetry.testassethierarchy";
    public static final String JIRA_FIELDS = "automation.qmetry.jirafields";
    public static final String DEBUG = "automation.qmetry.debug";
    public static final String TESTCASE_UPDATE_LEVEL = "automation.qmetry.testcaseupdatelevel";
    public static final String ATTACHE_FILE = "automation.qmetry.attachefile";
//    public static Properties p;
public static Properties p =
        loadProperties(System.getProperty("user.dir") + File.separator + "qmetry.properties");

}
