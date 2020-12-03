package healthiTests;

import BasePackage.BaseTest;
import Jira.JiraPolicy;
import Pages.pharmacyScreens.dashBoardPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GetActionsTableTextTest extends BaseTest {

    public static dashBoardPage DashBoard;

    @BeforeClass
    public void initialization() {
        DashBoard = new dashBoardPage();
    }

    @JiraPolicy(logTicketReady=false)
    @Test  //(retryAnalyzer = RetryAnalyzer.class)
    public void PrintFirstRow() {
        DashBoard.ReturnActionTableTitle();
    }
}
