package pages.mecScreens;

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
        elementClick(adviceGivenToPatientCheckBox);
    }

    public void clickOnReassuredProblemSettled() {
        elementClick(reassuredProblemSettled);
    }

    public void clickOnNextOutcomeBtn() {
        elementClick(nextOutcomeBtn);
    }

    public void clickOnSaveAndExitBtn() {
        elementClick(saveAndExitBtn);
    }

    public void clickOnBackBtn() {
        elementClick(backBtn);
    }
}
