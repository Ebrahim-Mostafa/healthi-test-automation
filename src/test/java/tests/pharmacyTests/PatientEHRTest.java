package tests.pharmacyTests;

import BasePackage.BaseTest;
import Pages.pharmacyScreens.PatientEHRPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PatientEHRTest extends BaseTest {

    public static PatientEHRPage patientEHRPage;

    @BeforeClass
    public void initialization(){
        patientEHRPage=new PatientEHRPage();
    }

    @Test(enabled = false,description = "Choose New Medicine Service from Patient EHR screen")
    public void getIntoNMS(){
        patientEHRPage.deliveredClinicalServicesCount();
        patientEHRPage.clickOnAvailableClinicalServicesNMS();
    }

    @Test(description = "Choose NHS Flu Vaccination Service from Patient EHR screen")
    public void getIntoNHS(){
        patientEHRPage.clickOnAvailableClinicalServicesNHSFluVac();
        patientEHRPage.handleClinicalSafetyWarning();
    }
}
