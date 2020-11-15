package healthiTests;

import BasePackage.BasePage;
import BasePackage.BaseTest;
import Jira.JiraPolicy;
import Pages.healthiScreens.LoginPageJsonPOC;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class loginTestJsonPOC extends BaseTest {
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
        loginPage.fillUserTextBox("sa001");
        loginPage.fillPasswordTextBox("goport!!");
        loginPage.clickOnSignInButton();
        String expectedURL = "https://healthi-test.cegedim.com/dtf-healthi/view.xhtml";
        Assert.assertEquals(BasePage.getPageCurrentURL(), expectedURL);
//       Assert.fail();
//      MonteScreenRecorder.stopRecording();
    }
}

