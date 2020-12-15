package tests.pharmacyTests;

import BasePackage.BaseTest;
import Jira.JiraPolicy;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.pharmacyScreens.dashBoardPage;

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
