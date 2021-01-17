package tests.pharmacyTests;

import BasePackage.BaseTest;
import Jira.JiraPolicy;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Pages.pharmacyScreens.DashBoardPage;

public class DashBoardTest extends BaseTest {

    private static DashBoardPage DashBoard;

    @BeforeClass
    public void initialization() {
        DashBoard = new DashBoardPage();
    }

    @JiraPolicy(logTicketReady=false)
    @Test  //(retryAnalyzer = RetryAnalyzer.class)
    public void PrintFirstRow() {
        DashBoard.ReturnActionTableTitle();
        DashBoard.patientRecordsClick();
//      String patientRecordsURL="https://healthi-test.cegedim.com/pharmacy/Dashboard/PatientRecords";
//      Assert.assertEquals(getPageCurrentURL(),patientRecordsURL);
    }
}
