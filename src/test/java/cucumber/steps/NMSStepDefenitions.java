package cucumber.steps;

import BasePackage.BaseTest;
import Pages.common.LoginPage;
import Pages.common.LogoutPage;
import Pages.pharmacyScreens.DashBoardPage;
import Pages.pharmacyScreens.NewMedicineServicePage;
import Pages.pharmacyScreens.PatientEHRPage;
import Pages.pharmacyScreens.patientRecordsPage;
import com.codoid.products.exception.FilloException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;

import static Utilities.ExcelUtils.SelectCell;

public class NMSStepDefenitions extends BaseTest {

    private static NewMedicineServicePage newMedicineServicePage;
    private static SoftAssert softAssert;

    @Given("^the NMS service is held in the Available Clinical Services section of the EHR$")
    public void the_nms_service_is_held_in_the_available_clinical_services_section_of_the_ehr() throws FilloException {
        LoginPage loginPage = new LoginPage();
        loginPage.fillUserTextBox(SelectCell("Select * from LoginTest where TestCaseName='NewScreen'","Username"));
        loginPage.fillPasswordTextBox(SelectCell("Select * from LoginTest where TestCaseName='NewScreen'","Password"));
        loginPage.clickOnSignInButton();
        loginPage.clickOnStandard();
        DashBoardPage DashBoard = new DashBoardPage();
        DashBoard.patientRecordsClick();
        patientRecordsPage recordsPage = new patientRecordsPage();
        recordsPage.fillSurname(SelectCell("Select * from PatientRecords where TestCaseName='PatientSearch1'","Surname"));
        recordsPage.fillFirstName(SelectCell("Select * from PatientRecords where TestCaseName='PatientSearch1'","FirstName"));
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
    public void the_pharmacist_completes_the_engagement_screen_selects_products_from_resip_and_saves() throws FilloException {
        newMedicineServicePage.clickOnSelectEditBtn();
        newMedicineServicePage.productSearch(SelectCell("Select * from NewMedicineService where TestCaseName='NewMedicine1'","ProductSearch"));
        newMedicineServicePage.clickOnConsentCheckBox();
        newMedicineServicePage.clickOnHealthyLivingAdviceCheckBox();
        newMedicineServicePage.ClickOnEngagementSessionCompletedCheckBox();
        newMedicineServicePage.clickOnSaveBtn();
    }

    @And("^completes the Intervention screen and saves$")
    public void completes_the_intervention_screen_and_saves() throws FilloException {
        newMedicineServicePage.clickOnNMSFromInProgressClinicalServices();
        newMedicineServicePage.sendInterventionDate(SelectCell("Select * from NewMedicineService where TestCaseName='NewMedicine1'","InterventionDate"));
        newMedicineServicePage.clickOnInterventionReviewBtn();
        newMedicineServicePage.productReview();
        newMedicineServicePage.clickOnInterventionCompleteRadioBtn();
        newMedicineServicePage.clickOnSaveBtn();
    }

    @And("^completes the Follow Up screen$")
    public void completes_the_follow_up_screen() throws FilloException {
        softAssert=new SoftAssert();
        Integer inProgressClinicalServices = newMedicineServicePage.InProgressClinicalServicesCount()+1;
        softAssert.assertNotEquals(newMedicineServicePage.InProgressClinicalServicesCount(),inProgressClinicalServices);
        softAssert.assertEquals(inProgressClinicalServices,"36");
        newMedicineServicePage.clickOnNMSFromInProgressClinicalServices();
        newMedicineServicePage.sendFollowUpDate(SelectCell("Select * from NewMedicineService where TestCaseName='NewMedicine1'","FollowUpDate"));
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
