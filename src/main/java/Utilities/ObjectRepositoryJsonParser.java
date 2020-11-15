package Utilities;

import BasePackage.DriverFactory;
import com.jayway.jsonpath.JsonPath;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;

public class ObjectRepositoryJsonParser {

    static File jsonFile;

    public ObjectRepositoryJsonParser (String filename){
        jsonFile = new File(filename);
    }

    public WebElement getObjectLocator(String jsonpath)
    {
        String locatorProperty = null;
        try {
            locatorProperty = JsonPath.read(jsonFile, jsonpath).toString();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String locatorType = locatorProperty.split(";")[0];
        String locatorValue = locatorProperty.split(";")[1];
        WebDriver driver = DriverFactory.getDriver();

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