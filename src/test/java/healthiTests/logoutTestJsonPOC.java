package healthiTests;

import BasePackage.BaseTest;
import Pages.common.logoutPageJsonPOC;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class logoutTestJsonPOC extends BaseTest {
    public static logoutPageJsonPOC logoutPage;

    @BeforeClass
    public void initialization(){
        logoutPage=new logoutPageJsonPOC();
    }

    @Test
    public void logoutFunctionality(){
        logoutPage.clickOnProfileInfo();
        logoutPage.clickOnLogout();
    }
}
