package tests.pharmacyTests;

import BasePackage.BaseTest;
import com.codoid.products.exception.FilloException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Pages.pharmacyScreens.NHSFluVaccinationServicePage;

public class NHSFluVaccinationServiceTest extends BaseTest {

    private static NHSFluVaccinationServicePage nhsFluVaccinationServicePage;

    @BeforeClass
    public void initialization(){
        nhsFluVaccinationServicePage=new NHSFluVaccinationServicePage();
    }

    @Test(description = "HS-6727-Automate generated dispense event when Complete button clicked multiple times")
    public void generateDispenseEvent() throws FilloException {
        nhsFluVaccinationServicePage.eligiblePatientGroup();
        nhsFluVaccinationServicePage.consentNHSFluVacc();
        nhsFluVaccinationServicePage.vaccinationAdministeredYes();
        nhsFluVaccinationServicePage.completeTheService();
    }
}
