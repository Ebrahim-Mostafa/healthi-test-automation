package Pages.healthiScreens;

import BasePackage.BasePage;
import org.openqa.selenium.WebElement;


public class LoginPageJsonPOC extends BasePage {


    //ObjectRepositoryJsonParser json = new ObjectRepositoryJsonParser(filename);

    //username webElement declaration
    WebElement userName = BasePage.getObjectLocator("$.Login.txt_username");

    //password webElement declaration
    WebElement Password = BasePage.getObjectLocator("$.Login.txt_password");

    //Sign in button webElement declaration
    WebElement signIn = BasePage.getObjectLocator("$.Login.btn_login");

    //Recover Password button webElement declaration
    WebElement recoverPassId = BasePage.getObjectLocator("$.Login.RecoverPass");


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
