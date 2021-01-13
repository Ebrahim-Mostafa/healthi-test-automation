package tests.pharmacyTests;

import BasePackage.BaseTest;
import Jira.JiraPolicy;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.common.LoginPage;

import static BasePackage.BasePage.getPageCurrentURL;

//import pages.pharmacyScreens.rolePage;

public class loginTest extends BaseTest {

    private static LoginPage loginPage;

    @BeforeClass
    public void initialization() {
        loginPage = new LoginPage();
    }

    @JiraPolicy(logTicketReady=false)
    @Test  //(retryAnalyzer = RetryAnalyzer.class)
    public void signIn() {
//      BrowserMobProxyLogger.printBrowserMobProxyResults();
//      MonteScreenRecorder.startRecording("signIn");
        loginPage.fillUserTextBox("apple01");
        loginPage.fillPasswordTextBox("goport!!");
        loginPage.clickOnSignInButton();
        String roleURL = "https://healthi-test.cegedim.com/suite-webapp/role/list.html";
        Assert.assertEquals(getPageCurrentURL(), roleURL);
        loginPage.clickOnStandard();
        String dashboardURL = "https://healthi-test.cegedim.com/pharmacy/Dashboard";
        Assert.assertEquals(getPageCurrentURL(), dashboardURL);
//      Assert.fail();
//      MonteScreenRecorder.stopRecording();
    }

}

