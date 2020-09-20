package mecsTests;

import BasePackage.BaseTest;
import Pages.mecScreens.consultationPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class consultationTest extends BaseTest {
    public static consultationPage consultationPage;

    @BeforeClass
    public void initialization() {
        consultationPage = new consultationPage();
    }

    @Test
    public void nextManagementPlan() {
        consultationPage.insertDateOfConsultation();
        consultationPage.insertTimeOfConsultation();
        consultationPage.selectConsultationMethod();
        consultationPage.selectRightEyeOfVisualAcuity();
        consultationPage.selectLeftEyeOfVisualAcuity();
        consultationPage.insertExaminationNotes();
        consultationPage.selectFromDiagnosisSearch();
        consultationPage.clickOnNextManagementPlanBtn();
    }
}
