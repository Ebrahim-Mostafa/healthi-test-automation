package pages.mecScreens;

import BasePackage.BasePage;
import Utilities.JSUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class consultationPage extends BasePage {
    @FindBy(name = "consultationDate")
    WebElement dateOfConsultation;
    @FindBy(name = "consultationTime")
    WebElement timeOfConsultation;
    @FindBy(id = "consultationMethod")
    WebElement consultationMethodDropdownList;
    @FindBy(xpath = "//li[contains(text(),'Video Call')]")
    WebElement consultationMethodItem;
    @FindBy(xpath = "//em[contains(text(),'VA (RE)')]")
    WebElement rightEyeDropdownList;
    @FindBy(xpath = "//li[contains(text(),'6/7')]")
    WebElement rightEye;
    @FindBy(xpath = "//em[contains(text(),'VA (LE)')]")
    WebElement leftEyeDropdownList;
    @FindBy(xpath = "//li[contains(text(),'6/7')]")
    WebElement leftEye;
    @FindBy(id = "examinationNotes")
    WebElement examinationNotes;
    @FindBy(id = "diagnosisSearch")
    WebElement diagnosisSearchDropdownList;
    @FindBy(xpath = "//*[contains(text(),'Foreign Body')]")
    WebElement diagnosisSearchItem;
    @FindBy(name = "selectedDiagnosis.0.rightEye")
    WebElement selectDiagnosisRightEyeCheckBox;
    @FindBy(name = "selectedDiagnosis.0.leftEye")
    WebElement selectDiagnosisLeftEyeCheckBox;
    @FindBy(name = "selectedDiagnosis.0.primary")
    WebElement primaryPresentingConditionRadioBtn;
    @FindBy(xpath = "//span[@class='MuiButton-label'][contains(text(),'Management Plan')]")
    WebElement nextManagementPlanBtn;
    @FindBy(xpath = "//span[contains(text(),'Save & Exit')]")
    WebElement saveAndExitBtn;
    @FindBy(xpath = "//span[contains(text(),'Back')]")
    WebElement backBtn;

    public consultationPage() {
        JSUtils.scrollPageDown();
    }

    public void insertDateOfConsultation() {
        dateOfConsultation.clear();
        dateOfConsultation.click();
        dateOfConsultation.sendKeys("01/12/2020");
    }

    public void insertTimeOfConsultation() {
        timeOfConsultation.clear();
        timeOfConsultation.click();
        timeOfConsultation.sendKeys("09:00 AM");
    }

    public void selectConsultationMethod() {
        consultationMethodDropdownList.click();
        consultationMethodItem.click();
    }

    public void selectRightEyeOfVisualAcuity() {
        rightEyeDropdownList.click();
        rightEye.click();
    }

    public void selectLeftEyeOfVisualAcuity() {
        leftEyeDropdownList.click();
        leftEye.click();
    }

    public void insertExaminationNotes() {
        examinationNotes.click();
        examinationNotes.sendKeys("Happy Automation Testing");
    }

    public void selectFromDiagnosisSearch() {
        diagnosisSearchDropdownList.click();
        diagnosisSearchItem.click();
        selectDiagnosisRightEyeCheckBox.click();
        selectDiagnosisLeftEyeCheckBox.click();
        primaryPresentingConditionRadioBtn.click();

    }

    public void clickOnNextManagementPlanBtn() {
        nextManagementPlanBtn.click();
    }

    public void clickOnSaveAndExitBtn() {
        saveAndExitBtn.click();
    }

    public void clickOnBackBtn() {
        backBtn.click();
    }
}
