package pages.healthiScreens;

import BasePackage.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginPage extends BasePage {

    @FindBy(id = "username")
    WebElement userName;

    @FindBy(id = "password")
    WebElement Password;

    @FindBy(id = "entrar")
    WebElement signIn;

    @FindBy(id = "recoverPassId")
    WebElement recoverPassId;

    public void fillUserTextBox(String username) {
        elementClear(userName);
        elementClick(userName);
//      String username = "sa001";
        elementSendKeys(userName,username);
    }

    public void fillPasswordTextBox(String password) {
        elementClear(Password);
        elementClick(Password);
//      String password="goport!!";
        elementSendKeys(Password,password);
//      BasePage.setTextElementText(Password,password);
    }

    public void clickOnSignInButton() {
        elementClick(signIn);
//      JSUtils.clickElementByJS(signIn);
    }

    public void clickOnCantAccessAccount() {
        elementClick(recoverPassId);
    }

}
