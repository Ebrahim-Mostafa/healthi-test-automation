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
        userName.clear();
        userName.click();
//        String username = "sa001";
        userName.sendKeys(username);
//        Utils.setTextElementText(userName,username);
    }

    public void fillPasswordTextBox(String password) {
        Password.clear();
        Password.clear();
//        String password="goport!!";
          Password.sendKeys(password);
//        BasePage.setTextElementText(Password,password);
    }

    public void clickOnSignInButton() {
        signIn.click();
//      JSUtils.clickElementByJS(signIn);
    }

    public void clickOnCantAccessAccount() {
        recoverPassId.click();
    }

}
