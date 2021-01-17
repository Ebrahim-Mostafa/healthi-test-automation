package tests.pharmacyTests;

import BasePackage.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import Pages.pharmacyScreens.NewMedicineServicePage;

import static tests.pharmacyTests.PatientEHRTest.patientEHRPage;

public class NewMedicineServiceTest extends BaseTest {

    private static NewMedicineServicePage newMedicineServicePage;
    private static SoftAssert softAssert;

    @BeforeClass
    public void initialization(){
        softAssert=new SoftAssert();
        newMedicineServicePage=new NewMedicineServicePage();
    }

    @Test
    public void NMSSunnyDayScenario(){
        newMedicineServicePage.ProceedNMSPopup();
//      newMedicineServicePage.CancelNMSPopup();
        newMedicineServicePage.SelectEngagementTab();
        newMedicineServicePage.clickOnSelectEditBtn();
        newMedicineServicePage.productSearch("Warfarin");
        newMedicineServicePage.clickOnConsentCheckBox();
        newMedicineServicePage.clickOnHealthyLivingAdviceCheckBox();
        newMedicineServicePage.ClickOnEngagementSessionCompletedCheckBox();
        newMedicineServicePage.clickOnSaveBtn();
        Integer inProgressClinicalServices = newMedicineServicePage.InProgressClinicalServicesCount()+1;
        softAssert.assertNotEquals(newMedicineServicePage.InProgressClinicalServicesCount(),inProgressClinicalServices);
        softAssert.assertEquals(inProgressClinicalServices,"36");
        newMedicineServicePage.clickOnNMSFromInProgressClinicalServices();
        newMedicineServicePage.sendInterventionDate("13/01/2021");
        newMedicineServicePage.clickOnInterventionReviewBtn();
        newMedicineServicePage.productReview();
        newMedicineServicePage.clickOnInterventionCompleteRadioBtn();
        newMedicineServicePage.clickOnSaveBtn();
        newMedicineServicePage.clickOnNMSFromInProgressClinicalServices();
        newMedicineServicePage.sendFollowUpDate("13/01/2021");
        newMedicineServicePage.clickOnFollowUpReviewBtn();
        newMedicineServicePage.productReview();
        newMedicineServicePage.clickOnFollowupCompleteRadioBtn();
        newMedicineServicePage.clickOnServiceCompleteBtn();
        Integer deliveredClinicalServices = patientEHRPage.deliveredClinicalServicesCount()+1;
        softAssert.assertNotEquals(patientEHRPage.deliveredClinicalServicesCount(),deliveredClinicalServices);
        softAssert.assertEquals(deliveredClinicalServices,"30");
    }
}
