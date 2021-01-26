package tests.pharmacyTests;

import BasePackage.BaseTest;
<<<<<<< HEAD
import Utilities.ExcelUtils;
import com.codoid.products.exception.FilloException;
=======
import Pages.pharmacyScreens.NewMedicineServicePage;
>>>>>>> f6b53434879a3a034fe58a3cd8442b25e0b9a7d7
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static Utilities.ExcelUtils.SelectCell;
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
    public void NMSSunnyDayScenario() throws FilloException {
        newMedicineServicePage.ProceedNMSPopup();
//      newMedicineServicePage.CancelNMSPopup();
        newMedicineServicePage.SelectEngagementTab();
        newMedicineServicePage.clickOnSelectEditBtn();
        newMedicineServicePage.productSearch(SelectCell("Select * from NewMedicineService where TestCaseName='NewMedicine1'","ProductSearch"));
        newMedicineServicePage.clickOnConsentCheckBox();
        newMedicineServicePage.clickOnHealthyLivingAdviceCheckBox();
        newMedicineServicePage.ClickOnEngagementSessionCompletedCheckBox();
        newMedicineServicePage.clickOnSaveBtn();
        Integer inProgressClinicalServices = newMedicineServicePage.InProgressClinicalServicesCount()+1;
        softAssert.assertNotEquals(newMedicineServicePage.InProgressClinicalServicesCount(),inProgressClinicalServices);
        softAssert.assertEquals(inProgressClinicalServices,SelectCell("Select * from NewMedicineService where TestCaseName='NewMedicine1'","inProgressClinicalServicesExpected"));
        newMedicineServicePage.clickOnNMSFromInProgressClinicalServices();
        newMedicineServicePage.sendInterventionDate(SelectCell("Select * from NewMedicineService where TestCaseName='NewMedicine1'","InterventionDate"));
        newMedicineServicePage.clickOnInterventionReviewBtn();
        newMedicineServicePage.productReview();
        newMedicineServicePage.clickOnInterventionCompleteRadioBtn();
        newMedicineServicePage.clickOnSaveBtn();
        newMedicineServicePage.clickOnNMSFromInProgressClinicalServices();
        newMedicineServicePage.sendFollowUpDate(SelectCell("Select * from NewMedicineService where TestCaseName='NewMedicine1'","FollowUpDate"));
        newMedicineServicePage.clickOnFollowUpReviewBtn();
        newMedicineServicePage.productReview();
        newMedicineServicePage.clickOnFollowupCompleteRadioBtn();
        newMedicineServicePage.clickOnServiceCompleteBtn();
        Integer deliveredClinicalServices = patientEHRPage.deliveredClinicalServicesCount()+1;
        softAssert.assertNotEquals(patientEHRPage.deliveredClinicalServicesCount(),deliveredClinicalServices);
        softAssert.assertEquals(deliveredClinicalServices,SelectCell("Select * from NewMedicineService where TestCaseName='NewMedicine1'","deliveredClinicalServicesExpected"));
        ExcelUtils.CloseExcelSheet();
    }
}
