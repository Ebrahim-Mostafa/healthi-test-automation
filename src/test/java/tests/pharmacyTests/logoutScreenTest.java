package tests.pharmacyTests;

import BasePackage.BaseTest;
import pages.common.LogoutPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

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
