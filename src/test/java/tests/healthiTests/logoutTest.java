package tests.healthiTests;

import BasePackage.BaseTest;
import Pages.healthiScreens.logoutPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

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
