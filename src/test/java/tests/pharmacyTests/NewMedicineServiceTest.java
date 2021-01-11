package tests.pharmacyTests;

import BasePackage.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.pharmacyScreens.NewMedicineServicePage;

public class NewMedicineServiceTest extends BaseTest {

    private static NewMedicineServicePage newMedicineServicePage;

    @BeforeClass
    public void initialization(){
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
        newMedicineServicePage.clickOnNMSFromInProgressClinicalServices();
        newMedicineServicePage.sendInterventionDate("11/01/2021");
        newMedicineServicePage.clickOnInterventionReviewBtn();
        newMedicineServicePage.productReview();
        newMedicineServicePage.clickOnInterventionCompleteRadioBtn();
        newMedicineServicePage.clickOnSaveBtn();
        newMedicineServicePage.clickOnNMSFromInProgressClinicalServices();
        newMedicineServicePage.sendFollowUpDate("11/01/2021");
        newMedicineServicePage.clickOnFollowUpReviewBtn();
        newMedicineServicePage.productReview();
        newMedicineServicePage.clickOnFollowupCompleteRadioBtn();
        newMedicineServicePage.clickOnServiceCompleteBtn();
    }
}
