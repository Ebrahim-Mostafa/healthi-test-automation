package tests.pharmacyTests;

import BasePackage.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.pharmacyScreens.PatientEHRPage;

public class PatientEHRTest extends BaseTest {

    public static PatientEHRPage patientEHRPage;

    @BeforeClass
    public void initialization(){
        patientEHRPage=new PatientEHRPage();
    }

    @Test
    public void getIntoNMS(){
        patientEHRPage.deliveredClinicalServicesCount();
        patientEHRPage.clickOnAvailableClinicalServicesNMS();
    }
}
