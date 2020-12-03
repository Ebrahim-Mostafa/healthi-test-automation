package healthiTests;

import BasePackage.BasePage;
import BasePackage.BaseTest;
import Jira.JiraPolicy;
import Pages.common.LoginPageJsonPOC;
import Pages.pharmacyScreens.rolePage;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginNewScreenTest extends BaseTest {
    public static LoginPageJsonPOC loginPage;


    @BeforeClass
    public void initialization() {
        loginPage = new LoginPageJsonPOC();
    }

    @JiraPolicy(logTicketReady=false)
    @Test  //(retryAnalyzer = RetryAnalyzer.class)
    public void signIn() {
//      BrowserMobProxyLogger.printBrowserMobProxyResults();
//      MonteScreenRecorder.startRecording("signIn");
        loginPage.fillUserTextBox("apple01");
        loginPage.fillPasswordTextBox("goport!!");
        loginPage.clickOnSignInButton();
        String expectedURL = "https://healthi-test.cegedim.com/suite-webapp/role/list.html";
        Assert.assertEquals(BasePage.getPageCurrentURL(), expectedURL);
//       Assert.fail();
//      MonteScreenRecorder.stopRecording();
    }
    @Test (dependsOnMethods = "signIn")
    public void StandardUser(){
        rolePage RolePageObject = new rolePage();
        RolePageObject.clickOnStandard();
        String expectedURL = "https://healthi-test.cegedim.com/pharmacy/Dashboard";
        Assert.assertEquals(BasePage.getPageCurrentURL(), expectedURL);
    }
}

