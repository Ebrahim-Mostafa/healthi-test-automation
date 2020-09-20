package Pages.mecScreens;

import BasePackage.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class managementPlanPage extends BasePage {
    @FindBy(id = "advice")
    WebElement adviceGivenToPatientCheckBox;
    @FindBy(id = "adviceList-1")
    WebElement reassuredProblemSettled;
    @FindBy(xpath = "//span[@class='MuiButton-label'][contains(text(),'Outcome')]")
    WebElement nextOutcomeBtn;
    @FindBy(xpath = "//span[contains(text(),'Save & Exit')]")
    WebElement saveAndExitBtn;
    @FindBy(xpath = "//span[contains(text(),'Back')]")
    WebElement backBtn;

    public void clickOnAdviceGivenToPatientCheckBox() {
        adviceGivenToPatientCheckBox.click();
    }

    public void clickOnReassuredProblemSettled() {
        reassuredProblemSettled.click();
    }

    public void clickOnNextOutcomeBtn() {
        nextOutcomeBtn.click();
    }

    public void clickOnSaveAndExitBtn() {
        saveAndExitBtn.click();
    }

    public void clickOnBackBtn() {
        backBtn.click();
    }
}
