package tests.pharmacyTests;

import BasePackage.BaseTest;
import Jira.JiraPolicy;
import Pages.common.LoginPage;
import Utilities.ExcelUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static BasePackage.BasePage.getPageCurrentURL;
import static Utilities.ExcelUtils.SelectCell;
import static Utilities.ExcelUtils.recordset;

public class LoginNewScreenTest extends BaseTest {
    public static LoginPage loginPage;


    @BeforeClass
    public void initialization() {
        loginPage = new LoginPage();
    }

    @JiraPolicy(logTicketReady=false)
    @Test  //(retryAnalyzer = RetryAnalyzer.class)
    public void signIn() throws Exception {
//      BrowserMobProxyLogger.printBrowserMobProxyResults();
//      MonteScreenRecorder.startRecording("signIn");
        loginPage.fillUserTextBox(SelectCell("Select * from Sheet1 where TestCaseName='NewScreen'","Username"));
        loginPage.fillPasswordTextBox(recordset.getField("Password"));
        loginPage.clickOnSignInButton();
        Assert.assertEquals(getPageCurrentURL(), SelectCell("Select * from Sheet1 where TestCaseName='NewScreen'","expectedRoleURL"));
        loginPage.clickOnStandard();
        Assert.assertEquals(getPageCurrentURL(), SelectCell("Select * from Sheet1 where TestCaseName='NewScreen'","expectedDashBoardURL"));
        ExcelUtils.CloseExcelSheet();
//      Assert.fail();
//      MonteScreenRecorder.stopRecording();
    }
}

