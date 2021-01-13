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
        elementClear(dateOfConsultation);
        elementClick(dateOfConsultation);
        elementSendKeys(dateOfConsultation,"01/01/2021");
    }

    public void insertTimeOfConsultation() {
        elementClear(timeOfConsultation);
        elementClick(timeOfConsultation);
        elementSendKeys(timeOfConsultation,"09:00 AM");
    }

    public void selectConsultationMethod() {
        elementClick(consultationMethodDropdownList);
        elementClick(consultationMethodItem);
    }

    public void selectRightEyeOfVisualAcuity() {
        elementClick(rightEyeDropdownList);
        elementClick(rightEye);
    }

    public void selectLeftEyeOfVisualAcuity() {
        elementClick(leftEyeDropdownList);
        elementClick(leftEye);
    }

    public void insertExaminationNotes() {
        elementClick(examinationNotes);
        elementSendKeys(examinationNotes,"Happy Automation Testing");
    }

    public void selectFromDiagnosisSearch() {
        elementClick(diagnosisSearchDropdownList);
        elementClick(diagnosisSearchItem);
        elementClick(selectDiagnosisRightEyeCheckBox);
        elementClick(selectDiagnosisLeftEyeCheckBox);
        elementClick(primaryPresentingConditionRadioBtn);
    }

    public void clickOnNextManagementPlanBtn() {
        elementClick(nextManagementPlanBtn);
    }

    public void clickOnSaveAndExitBtn() {
        elementClick(saveAndExitBtn);
    }

    public void clickOnBackBtn() {
        elementClick(backBtn);
    }
}
