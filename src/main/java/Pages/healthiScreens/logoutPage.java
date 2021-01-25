package Pages.healthiScreens;

import BasePackage.BasePage;
import BasePackage.DriverFactory;
import Utilities.JSUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class logoutPage extends BasePage {
    @FindBy(xpath = "//div[@class='profile-image fa']")
    //div[@class='profile-info']
    //span[@class='topbar-item-name profile-role']
    //span[@class='topbar-item-name profile-name truncate100']
    WebElement profileInfo;

    @FindBy(xpath = "//a[@class='logoutLink']")
    WebElement logOut;

    public logoutPage() {
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
