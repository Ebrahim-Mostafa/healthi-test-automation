package tests.pharmacyTests;

import BasePackage.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.pharmacyScreens.NHSFluVaccinationServicePage;

public class NHSFluVaccinationServiceTest extends BaseTest {

    private static NHSFluVaccinationServicePage nhsFluVaccinationServicePage;

    @BeforeClass
    public void initialization(){
        nhsFluVaccinationServicePage=new NHSFluVaccinationServicePage();
    }

    @Test(description = "HS-6727-Automate generated dispense event when Complete button clicked multiple times")
    public void generateDispenseEvent(){
        nhsFluVaccinationServicePage.eligiblePatientGroup();
        nhsFluVaccinationServicePage.consentNHSFluVacc();
        nhsFluVaccinationServicePage.vaccinationAdministeredYes();
        nhsFluVaccinationServicePage.completeTheService();
    }
}
