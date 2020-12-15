package tests.pharmacyTests;

import BasePackage.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.common.LogoutPage;

public class logoutScreenTest extends BaseTest {
    public static LogoutPage logoutPage;

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
