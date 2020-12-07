package pages.common;

import BasePackage.BasePage;
import Utilities.ObjectRepositoryJsonParser;
import org.openqa.selenium.WebElement;


public class LoginPage extends BasePage {

    //username webElement declaration
    WebElement userName = ObjectRepositoryJsonParser.getObjectLocator("$.Login.txt_username");

    //WebElement userName = null;
//    ObjectRepositoryJsonParser.getObjectLocator("$.Login.txt_username",WebElement userName);

    //password webElement declaration
    WebElement Password = ObjectRepositoryJsonParser.getObjectLocator("$.Login.txt_password");

    //Sign in button webElement declaration
    WebElement signIn = ObjectRepositoryJsonParser.getObjectLocator("$.Login.btn_login");

    //Recover Password button webElement declaration
    WebElement recoverPassId = ObjectRepositoryJsonParser.getObjectLocator("$.Login.RecoverPass");

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


    public void clickOnStandard()
    {
        WebElement StandardRole = ObjectRepositoryJsonParser.getObjectLocator("$.RolePage.StandardRoleButton");
        StandardRole.click();
    }

    public void clickOnRestricte()
    {
        WebElement RestricteRole = ObjectRepositoryJsonParser.getObjectLocator("$.RolePage.RestricteRoleButton");
        RestricteRole.click();
    }

}
