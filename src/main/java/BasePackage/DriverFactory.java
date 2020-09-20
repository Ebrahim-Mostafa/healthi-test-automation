package BasePackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory {

    //    public static DriverFactory driverfactory = null;
    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    //= new ThreadLocal<WebDriver>();

    //todo Old Implementation
//    public static DriverFactory getInstance() {
//        if (driverfactory == null) {
//            driverfactory = new DriverFactory();
//        }
//        return driverfactory;
//    }

    //    }

    /*(3)    public WebDriver getDriver(){
        return  driver;
    }*/
    public synchronized static WebDriver getDriver() {
        return driver.get();
    }

    //todo brand new Implementation
    //(1)
    public synchronized static void setDriver(String browserName) {
 /*       switch (browserName.toLowerCase()) {

            case "Chrome":
                System.out.println("Chrome browser will start!");
                driver = ThreadLocal.withInitial(() -> new ChromeDriver(BrowserOptions.chromeOptions()));
                proxy.enableHarCaptureTypes(CaptureType.REQUEST_CONTENT, CaptureType.RESPONSE_CONTENT);

            case "Firefox":
                System.out.println("Chrome browser will start!");
                driver = ThreadLocal.withInitial(() -> new FirefoxDriver(BrowserOptions.firefoxOptions()));
                proxy.enableHarCaptureTypes(CaptureType.REQUEST_CONTENT, CaptureType.RESPONSE_CONTENT);

            case "Edge":
                System.out.println("Edge browser will start!");
                driver = ThreadLocal.withInitial(() -> new EdgeDriver(BrowserOptions.edgeOptions()));
                proxy.enableHarCaptureTypes(CaptureType.REQUEST_CONTENT, CaptureType.RESPONSE_CONTENT);

            case "IE":
                System.out.println("InternetExplorer browser will start!");
                driver = ThreadLocal.withInitial(() -> new InternetExplorerDriver(BrowserOptions.internetExplorerOptions()));
                proxy.enableHarCaptureTypes(CaptureType.REQUEST_CONTENT, CaptureType.RESPONSE_CONTENT);

            default:
                throw new RuntimeException("Unsupported browser! will not start any browser");*/

        if (browserName.equalsIgnoreCase("Chrome")) {
            System.out.println("Chrome browser will start!");
            driver = ThreadLocal.withInitial(() -> new ChromeDriver(BrowserOptions.chromeOptions()));
        } else if (browserName.equalsIgnoreCase("Firefox")) {
            System.out.println("FireFox browser will start!");
            driver = ThreadLocal.withInitial(() -> new FirefoxDriver(BrowserOptions.firefoxOptions()));
        } else if (browserName.equalsIgnoreCase("Edge")) {
            System.out.println("Edge browser will start!");
            driver = ThreadLocal.withInitial(() -> new EdgeDriver(BrowserOptions.edgeOptions()));
        } else if (browserName.equalsIgnoreCase("IE")) {
            System.out.println("InternetExplorer browser will start!");
            driver = ThreadLocal.withInitial(() -> new InternetExplorerDriver(BrowserOptions.internetExplorerOptions()));
        } else {
            throw new RuntimeException("Unsupported browser! will not start any browser");
        }
    }
}
