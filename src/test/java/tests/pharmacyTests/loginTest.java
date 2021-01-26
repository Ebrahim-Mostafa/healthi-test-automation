package tests.pharmacyTests;

import BasePackage.BaseTest;
import Jira.JiraPolicy;
<<<<<<< HEAD
import com.codoid.products.exception.FilloException;
=======
import Pages.common.LoginPage;
>>>>>>> f6b53434879a3a034fe58a3cd8442b25e0b9a7d7
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static BasePackage.BasePage.getPageCurrentURL;
import static Utilities.ExcelUtils.SelectCell;

//import pages.pharmacyScreens.rolePage;

public class loginTest extends BaseTest {

    private static LoginPage loginPage;

    @BeforeClass
    public void initialization() {
        loginPage = new LoginPage();
    }

    @JiraPolicy(logTicketReady=false)
    @Test  //(retryAnalyzer = RetryAnalyzer.class)
    public void signIn() throws FilloException {
//      BrowserMobProxyLogger.printBrowserMobProxyResults();
//      MonteScreenRecorder.startRecording("signIn");
        loginPage.fillUserTextBox(SelectCell("Select * from LoginTest where TestCaseName='NewScreen'","Username"));
        loginPage.fillPasswordTextBox(SelectCell("Select * from LoginTest where TestCaseName='NewScreen'","Password"));
        loginPage.clickOnSignInButton();
        String roleURL = SelectCell("Select * from LoginTest where TestCaseName='NewScreen'","expectedRoleURL");
        Assert.assertEquals(getPageCurrentURL(), roleURL);
        loginPage.clickOnStandard();
        String dashboardURL = SelectCell("Select * from LoginTest where TestCaseName='NewScreen'","expectedDashBoardURL");
        Assert.assertEquals(getPageCurrentURL(), dashboardURL);
//      Assert.fail();
//      MonteScreenRecorder.stopRecording();
    }

}

