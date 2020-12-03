package Pages.common;

import BasePackage.BasePage;
import BasePackage.DriverFactory;
import Utilities.JSUtils;
import org.openqa.selenium.WebElement;

public class logoutPageJsonPOC extends BasePage {

        /*@FindBy(xpath = "//div[@class='profile-image fa']")
    //div[@class='profile-info']
            //span[@class='topbar-item-name profile-role']
            //span[@class='topbar-item-name profile-name truncate100']
            WebElement profileInfo;

    @FindBy(xpath = "//a[@class='logoutLink']")
    WebElement logOut;*/

    //profile Info button WebElement declaration
    WebElement profileInfo = BasePage.getObjectLocator("$.Logout.ProfileInfoButton");

    //Logout button webElement declaration
    WebElement logOut = BasePage.getObjectLocator("$.Logout.LogoutButton");

    public logoutPageJsonPOC() {
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
