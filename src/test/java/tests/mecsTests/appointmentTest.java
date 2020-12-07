package tests.mecsTests;

import BasePackage.BasePage;
import BasePackage.BaseTest;
import pages.mecScreens.appointmentPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class appointmentTest extends BaseTest {
    public static appointmentPage appointmentPage;

    @BeforeClass
    public void initialization() {
        appointmentPage = new appointmentPage();
    }

    @Test
    public void getAppointmentURL() {
        System.out.println(BasePage.getPageCurrentURL());
    }

    @Test
    public void saveAndContinueBtn() {
        appointmentPage.insertDateOfInitialContact();
        appointmentPage.inserTimeOfInitialContact();
        appointmentPage.insertInternalTriageNotes();
        appointmentPage.selectReferralSource();
        appointmentPage.selectReferralReason();
        appointmentPage.insertWasAppointmentGivenCheckbox();
        appointmentPage.selectappointmenType();
        appointmentPage.insertDateOfAppointment();
        appointmentPage.insertTimeOfAppointment();
        appointmentPage.clickOnSaveAndContinueBtn();

    }

    @Test
    public void saveAndExitBtn() {
        appointmentPage.insertDateOfInitialContact();
        appointmentPage.inserTimeOfInitialContact();
        appointmentPage.insertInternalTriageNotes();
        appointmentPage.selectReferralSource();
        appointmentPage.selectReferralReason();
        appointmentPage.insertWasAppointmentGivenCheckbox();
        appointmentPage.selectappointmenType();
        appointmentPage.insertDateOfAppointment();
        appointmentPage.insertTimeOfAppointment();
        appointmentPage.clickOnSaveAndExitBtn();
    }
}
