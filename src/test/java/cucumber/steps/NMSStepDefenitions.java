package cucumber.steps;

import BasePackage.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;
import pages.common.LoginPage;
import pages.common.LogoutPage;
import pages.pharmacyScreens.DashBoardPage;
import pages.pharmacyScreens.NewMedicineServicePage;
import pages.pharmacyScreens.PatientEHRPage;
import pages.pharmacyScreens.patientRecordsPage;

public class NMSStepDefenitions extends BaseTest {

    private static NewMedicineServicePage newMedicineServicePage;
    private static SoftAssert softAssert;

    @Given("^the NMS service is held in the Available Clinical Services section of the EHR$")
    public void the_nms_service_is_held_in_the_available_clinical_services_section_of_the_ehr() {
        LoginPage loginPage = new LoginPage();
        loginPage.fillUserTextBox("apple01");
        loginPage.fillPasswordTextBox("goport!!");
        loginPage.clickOnSignInButton();
        loginPage.clickOnStandard();
        DashBoardPage DashBoard = new DashBoardPage();
        DashBoard.patientRecordsClick();
        patientRecordsPage recordsPage = new patientRecordsPage();
        recordsPage.fillSurname("Smith");
        recordsPage.fillFirstName("Robert");
        recordsPage.clickOnSearchBtn();
        recordsPage.clickOnSearchResult();
        PatientEHRPage patientEHRPage = new PatientEHRPage();
        patientEHRPage.deliveredClinicalServicesCount();
        patientEHRPage.clickOnAvailableClinicalServicesNMS();
    }

    @And("^RESIP is available$")
    public void resip_is_available() {
        newMedicineServicePage = new NewMedicineServicePage();
        newMedicineServicePage.ProceedNMSPopup();
        newMedicineServicePage.SelectEngagementTab();
    }

    @When("^the Pharmacist completes the Engagement screen, selects Products from RESIP and saves$")
    public void the_pharmacist_completes_the_engagement_screen_selects_products_from_resip_and_saves() {
        newMedicineServicePage.clickOnSelectEditBtn();
        newMedicineServicePage.productSearch("Warfarin");
        newMedicineServicePage.clickOnConsentCheckBox();
        newMedicineServicePage.clickOnHealthyLivingAdviceCheckBox();
        newMedicineServicePage.ClickOnEngagementSessionCompletedCheckBox();
        newMedicineServicePage.clickOnSaveBtn();
    }

    @And("^completes the Intervention screen and saves$")
    public void completes_the_intervention_screen_and_saves() {
        newMedicineServicePage.clickOnNMSFromInProgressClinicalServices();
        newMedicineServicePage.sendInterventionDate("13/01/2021");
        newMedicineServicePage.clickOnInterventionReviewBtn();
        newMedicineServicePage.productReview();
        newMedicineServicePage.clickOnInterventionCompleteRadioBtn();
        newMedicineServicePage.clickOnSaveBtn();
    }

    @And("^completes the Follow Up screen$")
    public void completes_the_follow_up_screen() {
        softAssert=new SoftAssert();
        Integer inProgressClinicalServices = newMedicineServicePage.InProgressClinicalServicesCount()+1;
        softAssert.assertNotEquals(newMedicineServicePage.InProgressClinicalServicesCount(),inProgressClinicalServices);
        softAssert.assertEquals(inProgressClinicalServices,"36");
        newMedicineServicePage.clickOnNMSFromInProgressClinicalServices();
        newMedicineServicePage.sendFollowUpDate("13/01/2021");
        newMedicineServicePage.clickOnFollowUpReviewBtn();
        newMedicineServicePage.productReview();
        newMedicineServicePage.clickOnFollowupCompleteRadioBtn();
    }

    @And("^selects Service Complete$")
    public void selects_service_complete() {
        newMedicineServicePage.clickOnServiceCompleteBtn();
    }

    @Then("^the NMS is saved$")
    public void the_nms_is_saved() {
        softAssert=new SoftAssert();
        PatientEHRPage patientEHRPage = new PatientEHRPage();
        Integer deliveredClinicalServices = patientEHRPage.deliveredClinicalServicesCount()+1;
        softAssert.assertNotEquals(patientEHRPage.deliveredClinicalServicesCount(),deliveredClinicalServices);
        softAssert.assertEquals(deliveredClinicalServices,"29");
    }

    @And("^appears in the Completed Clinical Service section of the EHR$")
    public void appears_in_the_completed_clinical_service_section_of_the_ehr() {
        LogoutPage logoutPage = new LogoutPage();
        logoutPage.clickOnProfileInfo();
        logoutPage.clickOnLogout();
    }
}
