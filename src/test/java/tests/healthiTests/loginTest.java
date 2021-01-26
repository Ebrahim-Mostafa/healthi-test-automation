package tests.healthiTests;

import BasePackage.BasePage;
import BasePackage.BaseTest;
import Jira.JiraPolicy;
import Pages.healthiScreens.loginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class loginTest extends BaseTest {
    public static loginPage loginPage;

    @BeforeClass
    public void initialization() {
        loginPage = new loginPage();
    }

    @JiraPolicy(logTicketReady=false)
    @Test  //(retryAnalyzer = RetryAnalyzer.class)
    public void signIn() {
//      BrowserMobProxyLogger.printBrowserMobProxyResults();
//      MonteScreenRecorder.startRecording("signIn");
        loginPage.fillUserTextBox("sa001");
        loginPage.fillPasswordTextBox("goport!!");
        loginPage.clickOnSignInButton();
        String expectedURL = "https://healthi-test.cegedim.com/dtf-healthi/view.xhtml";
        Assert.assertEquals(BasePage.getPageCurrentURL(), expectedURL);
//       Assert.fail();
//      MonteScreenRecorder.stopRecording();
    }
}

