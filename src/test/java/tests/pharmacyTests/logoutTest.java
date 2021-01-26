package tests.pharmacyTests;

import BasePackage.BaseTest;
import Pages.common.LogoutPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

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
