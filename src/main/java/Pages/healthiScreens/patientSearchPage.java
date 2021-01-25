package Pages.healthiScreens;

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
        swtichToFrame(searchForAPatientFrame);
    }

    public void fillSurname() {
        elementClear(surName);
        elementClick(surName);
        elementSendKeys(surName,"Optoeighteen");
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
        if (elementIsDisplayed(popup) == true) {
            elementClick(popupYesBtn);
            elementClick(opticianEHRIcon);
        } else {
            clickOnopticianEHRIcon();
        }
    }

    public void clickOnopticianEHRIcon() {
        try {
            elementClick(opticianEHRIcon);
            JSUtils.clickElementByJS(opticianEHRIcon);
        } catch (StaleElementReferenceException | ElementClickInterceptedException ex) {
            ex.getStackTrace();
        }
    }
}
