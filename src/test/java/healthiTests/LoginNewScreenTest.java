package healthiTests;

import BasePackage.BasePage;
import BasePackage.BaseTest;
import Jira.JiraPolicy;
import Pages.common.LoginPageJsonPOC;
import Pages.pharmacyScreens.rolePage;
import Utilities.ExcelUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
//import static Utilities.driver;


public class LoginNewScreenTest extends BaseTest {
    public static LoginPageJsonPOC loginPage;


    @BeforeClass
    public void initialization() {
        loginPage = new LoginPageJsonPOC();
    }

    @JiraPolicy(logTicketReady=false)
    @Test  //(retryAnalyzer = RetryAnalyzer.class)
    public void signIn() throws Exception {
//      BrowserMobProxyLogger.printBrowserMobProxyResults();
//      MonteScreenRecorder.startRecording("signIn");
        String Username = Utilities.ExcelUtils.SelectCell("Select * from Sheet1 where TestCaseName='NewScreen'","Username");
        String Password = ExcelUtils.SelectCell("Select * from Sheet1 where TestCaseName='NewScreen'","Password");
        String URL1 = Utilities.ExcelUtils.SelectCell("Select * from Sheet1 where TestCaseName='NewScreen'","expectedRoleURL");
        ExcelUtils.CloseExcelSheet();

        loginPage.fillUserTextBox(Username);
        loginPage.fillPasswordTextBox(Password);
        loginPage.clickOnSignInButton();
        Assert.assertEquals(BasePage.getPageCurrentURL(), URL1);
//       Assert.fail();
//      MonteScreenRecorder.stopRecording();
    }
    @Test (dependsOnMethods = "signIn")
    public void StandardUser() throws Exception {
        rolePage RolePageObject = new rolePage();
        RolePageObject.clickOnStandard();
        String URL2 = Utilities.ExcelUtils.SelectCell("Select * from Sheet1 where TestCaseName='NewScreen'","expectedDashBoardURL");
        ExcelUtils.CloseExcelSheet();
        Assert.assertEquals(BasePage.getPageCurrentURL(), URL2);
    }
}

