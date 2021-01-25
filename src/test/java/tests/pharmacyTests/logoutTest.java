package tests.pharmacyTests;

import BasePackage.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Pages.common.LogoutPage;

public class logoutTest extends BaseTest {

    private static LogoutPage logoutPage;

    @BeforeClass
    public void initialization(){
        logoutPage=new LogoutPage();
    }

    @Test
    public void logoutFunctionality(){
        logoutPage.clickOnProfileInfo();
        logoutPage.clickOnLogout();
    }
}
