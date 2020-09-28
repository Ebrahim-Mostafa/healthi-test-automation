package BasePackage;

import Loggers.BrowserConsoleLogger;
import Utilities.TimeUtils;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import static BasePackage.BrowserOptions.proxyServer;
import static Loggers.Log4JLogger.logger;

//import Loggers.Log4JLogger;

public class BaseTest extends AbstractTestNGCucumberTests {
    //public static ATUTestRecord recorder;
    public static WebDriver driver;

    @Parameters(value = {"Browser","ENV", "URL"})
    @BeforeTest(alwaysRun = true)
    public void setup(String browserName,@Optional String environment ,String url) throws IOException {
        logger.info("****************************** Starting test cases execution on "+environment+" environment "+"*****************************************");
        DriverFactory.setDriver(browserName);
        TimeUtils.pageLoadTimeout(150);
        TimeUtils.explicitWait(50);
        TimeUtils.implicitlyWait(50);
        TimeUtils.setScriptTimeout(150);
        DriverFactory.getDriver().manage().deleteAllCookies();
        driver = DriverFactory.getDriver();
        proxyServer.newHar("healthi-test");
//      DriverFactory.getDriver().get(url);
        driver.get(url);
//      BrowserMobProxyLogger.printBrowserMobProxyResults();
    }

    @AfterMethod
    @Parameters(value = {"URL"})
    public void consoleNotificationTestStart(ITestResult result, String url) throws Throwable {
        //Prepare the Sysout log to show which tests are being run and the environment against...
        System.out.println("//---------------------------");
        System.out.println("RUNNING IN ENVIRONMENT: " + url);
        System.out.println("STARTING TEST Class Name : " + result.getTestClass().getName() + " ====== " + "MethodName:" + result.getMethod().getMethodName() + ".");
        System.out.println("//---------------------------");
    }


    @AfterTest(alwaysRun = true)
    public synchronized void tearDown() throws FileNotFoundException {
        BrowserConsoleLogger.getBrowserConsoleLogs();
        proxyServer.stop();
        logger.info("****************************** Browser is closed *****************************************");
        DriverFactory.getDriver().quit();
    }
}
