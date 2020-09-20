package BasePackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.Iterator;
import java.util.Set;

import static BasePackage.BaseTest.driver;


public class BasePage {

    public BasePage(){
        PageFactory.initElements(driver,this);
    }
    public static void setTextElementText(WebElement textElement, String value) {
        textElement.sendKeys(value);
    }
    public static void swtichToFrame(WebElement element) {
        DriverFactory.getDriver().switchTo().frame(element);
    }
    public static void switchToWindow() {
        String childWindow = DriverFactory.getDriver().getWindowHandle();
        DriverFactory.getDriver().switchTo().window(childWindow);
    }

    public static void switchWindow() {

        Set<String> urls = DriverFactory.getDriver().getWindowHandles();
        Iterator<String> it = urls.iterator();
        String parentWindowID = it.next();
        String childWindowID = it.next();

        //To switch to child window
        DriverFactory.getDriver().switchTo().window(childWindowID);

        // To switch back to parent ID after complete the test
        DriverFactory.getDriver().switchTo().window(parentWindowID);

    }
    public static String getPageCurrentURL() {
        String currentURL = null;
        try {
            currentURL = driver.getCurrentUrl();
        } catch (Exception e) {
            System.out.println("some exception occurred while getting the current url " + currentURL);
        }
        return currentURL;
    }

    public static String getPageTitle() {
        String title = null;
        try {
            title = driver.getTitle();
        } catch (Exception e) {
            System.out.println("some exception occurred while getting the title " + title);
        }
        return title;
    }
}
