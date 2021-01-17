package tests.healthiTests;

import BasePackage.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Pages.healthiScreens.logoutPage;

public class logoutTest extends BaseTest {
    public static logoutPage logoutPage;

    @BeforeClass
    public void initialization(){
        logoutPage=new logoutPage();
    }

    @Test
    public void logoutFunctionality(){
        logoutPage.clickOnProfileInfo();
        logoutPage.clickOnLogout();
    }
}
