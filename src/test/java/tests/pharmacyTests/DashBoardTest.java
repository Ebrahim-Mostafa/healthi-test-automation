package tests.pharmacyTests;

import BasePackage.BaseTest;
import Jira.JiraTestCase;
import Pages.pharmacyScreens.DashBoardPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DashBoardTest extends BaseTest {

    private static DashBoardPage DashBoard;

    @BeforeClass
    public void initialization() {
        DashBoard = new DashBoardPage();
    }

    @JiraTestCase(logTicketReady=false)
    @Test  //(retryAnalyzer = RetryAnalyzer.class)
    public void PrintFirstRow() {
        DashBoard.ReturnActionTableTitle();
        DashBoard.patientRecordsClick();
//      String patientRecordsURL="https://healthi-test.cegedim.com/pharmacy/Dashboard/PatientRecords";
//      Assert.assertEquals(getPageCurrentURL(),patientRecordsURL);
    }
}
