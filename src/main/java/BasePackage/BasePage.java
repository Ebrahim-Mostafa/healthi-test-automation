package BasePackage;

import Utilities.TimeUtils;
import org.openqa.selenium.By;
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

    public static WebElement getElement(By locator) {
        WebElement element = null;
        try {
            element = driver.findElement(locator);
        } catch (Exception e) {
            System.out.println("Some exception occured while creating webelement " + locator);
        }
        return element;
    }

    public static boolean elementIsDisplayed(By locator) {
        TimeUtils.waitElement((WebElement) locator,15);
        return getElement(locator).isDisplayed();
    }

    public static boolean elementIsEnabled(By locator) {
        TimeUtils.waitElement((WebElement) locator,15);
        return getElement(locator).isEnabled();
    }

    public static String getText(By locator) {
        TimeUtils.waitElement((WebElement) locator,15);
        return getElement(locator).getText();
    }

    public static void elementClick(By locator) {
        getElement(locator).click();
    }

    public static void elementClear(By locator) {
        getElement(locator).clear();
    }

    public static void elementSendKeys(By locator, String value) {
        getElement(locator).sendKeys(value);
    }
}
