package tests.pharmacyTests;

import BasePackage.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Pages.pharmacyScreens.patientRecordsPage;

public class patientRecordsTest extends BaseTest{

    private static patientRecordsPage recordsPage;

    @BeforeClass
    public void initialization(){
        recordsPage=new patientRecordsPage();
    }

    @Test
    public void searchForPatientRecords(){
        recordsPage.fillSurname("Smith");
        recordsPage.fillFirstName("Robert");
        recordsPage.clickOnSearchBtn();
        recordsPage.clickOnSearchResult();
    }
}
