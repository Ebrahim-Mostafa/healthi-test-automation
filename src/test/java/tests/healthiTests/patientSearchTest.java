package tests.healthiTests;

import BasePackage.BaseTest;
import pages.healthiScreens.patientSearchPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class patientSearchTest extends BaseTest {
    public static patientSearchPage patientSearchPage;

    @BeforeClass
    public void initialization() {
        patientSearchPage = new patientSearchPage();
    }

    @Test
    public void searchForPatient() {
        patientSearchPage.fillSurname();
        patientSearchPage.fillDateOfBirth();
        patientSearchPage.clickOnSearchButton();
        patientSearchPage.clickOnPopupYesBtn();
        patientSearchPage.clickOnopticianEHRIcon();

    }
}
