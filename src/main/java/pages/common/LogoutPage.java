package pages.common;

import BasePackage.BasePage;
import BasePackage.DriverFactory;
import Utilities.JSUtils;
import Utilities.ObjectRepositoryJsonParser;
import org.openqa.selenium.WebElement;

public class LogoutPage extends BasePage {

    //profile Info button WebElement declaration
    WebElement profileInfo = ObjectRepositoryJsonParser.getObjectLocator("$.Logout.ProfileInfoButtonPharmacy");

    //Logout button webElement declaration
    WebElement logOut = ObjectRepositoryJsonParser.getObjectLocator("$.Logout.LogoutButtonPharmacy");

    public LogoutPage() {
        BasePage.switchToWindow();
    }

    public void clickOnProfileInfo() {
        JSUtils.clickElementByJS(profileInfo);
    }

    public boolean isAlertPresents() {
        try {
            DriverFactory.getDriver().switchTo().alert();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void clickOnLogout() {
        JSUtils.clickElementByJS(logOut);
        if (isAlertPresents()) {
            acceptConfirmBox();
            DriverFactory.getDriver().switchTo().defaultContent();
        }
    }

    public void acceptConfirmBox() {
        DriverFactory.getDriver().switchTo().alert().accept();
    }

    public void dismissConfrimBox() {
        DriverFactory.getDriver().switchTo().alert().dismiss();

    }

    public void getTextOfConfirmBox() {
        DriverFactory.getDriver().switchTo().alert().getText();
    }
}
