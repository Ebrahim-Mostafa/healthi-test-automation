package pages.mecScreens;

import BasePackage.BasePage;
import Utilities.JSUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class outcomePage extends BasePage {

    @FindBy(id = "outcome")
//    @FindBy(xpath = "//em[contains(text(),'Outcome')]")
    WebElement outcomeDropdownList;
    @FindBy(xpath = "//li[contains(text(),'Referral to GP (not for onward ophthalmologic refe')]")
    //li[contains(text(),'Referral to GP (not for onward ophthalmologic refe')]
    //li[contains(text(),'Follow Up')]
    //li[contains(text(),'Discharge')]
    WebElement dischargeItem;
    @FindBy(xpath = "//span[contains(text(),'Review')]")
    WebElement reviewBtn;
    @FindBy(xpath = "//span[contains(text(),'Save & Exit')]")
    WebElement saveAndExitBtn;
    @FindBy(xpath = "//span[contains(text(),'Back')]")
    WebElement backBtn;
    @FindBy(xpath = "//span[contains(text(),'Sign Off')]")
    WebElement signOffBtn;


    public void selectOutcome() {
        outcomeDropdownList.click();
        dischargeItem.click();
        JSUtils.scrollPageDown();
    }

    public void clickOnReviewBtn() {
        reviewBtn.click();
    }

    public void reviewConsultation() {
        signOffBtn.click();
    }

    public void clickOnSaveAndExitBtn() {
        saveAndExitBtn.click();
    }

    public void clickOnBackBtn() {
        backBtn.click();
    }
}
