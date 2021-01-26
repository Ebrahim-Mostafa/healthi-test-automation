package tests.pharmacyTests;

import BasePackage.BaseTest;
<<<<<<< HEAD
import com.codoid.products.exception.FilloException;
=======
import Pages.pharmacyScreens.patientRecordsPage;
>>>>>>> f6b53434879a3a034fe58a3cd8442b25e0b9a7d7
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static Utilities.ExcelUtils.SelectCell;

public class patientRecordsTest extends BaseTest{

    private static patientRecordsPage recordsPage;

    @BeforeClass
    public void initialization(){
        recordsPage=new patientRecordsPage();
    }

    @Test
    public void searchForPatientRecords() throws FilloException {
        recordsPage.fillSurname(SelectCell("Select * from PatientRecords where TestCaseName='PatientSearch1'","Surname"));
        recordsPage.fillFirstName(SelectCell("Select * from PatientRecords where TestCaseName='PatientSearch1'","FirstName"));
        recordsPage.clickOnSearchBtn();
        recordsPage.clickOnSearchResult();
    }
}
