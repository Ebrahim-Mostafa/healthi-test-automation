package Pages.pharmacyScreens;

import BasePackage.BasePage;
import org.openqa.selenium.WebElement;
import Utilities.TimeUtils;

public class rolePage extends BasePage{


    //Standard Role Button
    public static TimeUtils WaitFunctions = new TimeUtils();
    WebElement StandardRole = BasePage.getObjectLocator("$.RolePage.StandardRoleButton");

    public void clickOnStandard()
    {
        WaitFunctions.waitElement(StandardRole,30);
        StandardRole.click();
    }

}
