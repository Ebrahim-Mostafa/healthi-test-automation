package pages.healthiScreens;

import BasePackage.BasePage;
import Utilities.JSUtils;
import Utilities.TimeUtils;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class patientSearchPage extends BasePage {

    @FindBy(xpath = "//*[@id='idIfr1167']")
    WebElement searchForAPatientFrame;
    @FindBy(xpath = "//*[@id='wgSPatient:frmSearchPatient:j_id_12:j_id_13:recentSearches']")
    WebElement surName;
    @FindBy(xpath = "//*[@id='wgSPatient:frmSearchPatient:j_id_12:j_id_13:calendarDoB_input']")
    WebElement dateOfBirth;
    @FindBy(xpath = "//span[contains(text(),'Search')]")
    WebElement searchBtn;
    @FindBy(xpath = "//span[@class='ui-button-icon-left ui-icon ui-c ui-icon-folder-open']")
    WebElement opticianEHRIcon;
    @FindBy(xpath = "//span[@class='ui-confirm-dialog-message']")
    WebElement popup;
    @FindBy(xpath = "//span[contains(text(),'Yes')]")
    WebElement popupYesBtn;

    public patientSearchPage(){
        BasePage.swtichToFrame(searchForAPatientFrame);
    }
    public void fillSurname() {
        surName.clear();
        surName.click();
        surName.sendKeys("Optoeighteen");
    }

    public void fillDateOfBirth() {
        dateOfBirth.clear();
        dateOfBirth.click();
        dateOfBirth.sendKeys("08/06/1977");
    }

    public void clickOnSearchButton() {
        TimeUtils.waitElement(searchBtn, 20);
        JSUtils.clickElementByJS(searchBtn);
    }

    public void clickOnPopupYesBtn() {
        if (popup.isDisplayed() == true) {
            popupYesBtn.click();
            opticianEHRIcon.click();
        } else {
            clickOnopticianEHRIcon();
        }
    }

    public void clickOnopticianEHRIcon() {
        try {
            opticianEHRIcon.click();
            JSUtils.clickElementByJS(opticianEHRIcon);
        } catch (StaleElementReferenceException | ElementClickInterceptedException ex) {
            ex.getStackTrace();
        }
    }
}
