package BasePackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import com.jayway.jsonpath.JsonPath;
import org.openqa.selenium.By;
import static BasePackage.BaseTest.driver;


public class BasePage {
    static File jsonFile;

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

    public static WebElement getObjectLocator(String jsonpath)
    {

        String filename = System.getProperty("user.dir") + "/src/test/resources/ObjRepo.json";
        jsonFile = new File(filename);
        String locatorProperty = null;

        try {
            locatorProperty = JsonPath.read(jsonFile, jsonpath).toString();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String locatorType = locatorProperty.split(";")[0];
        String locatorValue = locatorProperty.split(";")[1];

        WebElement Element = null;
        switch(locatorType)
        {
            case "id":
                Element = driver.findElement(By.id(locatorValue));
                break;
            case "name":
                Element = driver.findElement(By.name(locatorValue));
                break;

            case "class":
                Element = driver.findElement(By.className(locatorValue));
                break;
            case "css":
                Element = driver.findElement(By.cssSelector(locatorValue));
                break;
            case "link":
                Element = driver.findElement(By.linkText(locatorValue));
                break;
            case "partial":
                Element = driver.findElement(By.partialLinkText(locatorValue));
                break;
            case "tag":
                Element = driver.findElement(By.tagName(locatorValue));
                break;
            case "xpath":
                Element = driver.findElement(By.xpath(locatorValue));
                break;
        }
        return Element;
    }
}
