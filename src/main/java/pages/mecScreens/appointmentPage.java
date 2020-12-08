package pages.mecScreens;

import BasePackage.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class appointmentPage extends BasePage {

    @FindBy(xpath = "//*[@id='idIfr1325']")
    WebElement triageComponent;
    @FindBy(xpath = "//*[@placeholder='dd/mm/yyyy']")
    WebElement dateOfInitialContact;
    @FindBy(xpath = "//*[@placeholder='hh:mm pm']")
    WebElement timeOfInitialContact;
    @FindBy(id = "referralSource")
    WebElement referralSourcedDropdownList;
    @FindBy(xpath = "//li[contains(text(),'GP(not seen GP)')]")
    //"referralSource"
            // "//em[contains(text(),'Referral Source')]"
            WebElement referralSourceItem;
    //@FindBy(xpath = "//li[contains(text(),'GP(not seen GP)')]")
    //    WebElement GP;
    @FindBy(id = "referralReason")
    WebElement referralReasonDrodownList;
    @FindBy(xpath = "//li[contains(text(),'Painful eye')]")
    //"referralReason"
            //em[contains(text(),'Referral Reason')]
            //'Painful eye'
            WebElement referralReasonItem;
    //    @FindBy(xpath = "//li[contains(text(),'Painful eye')]")
//    WebElement painfulEye;
    @FindBy(name = "appointmentGiven")
    WebElement wasAppointmentGiven;
    @FindBy(xpath = "//textarea[@id='triageNotes']")
    WebElement internalTriageNotes;
    //className=jss471
    @FindBy(id = "appointmentType")
    WebElement appointmenTypeDropdownList;
    @FindBy(xpath = "//li[contains(text(),'Urgent (24 Hours)')]")
    WebElement appointmenTypeDropdownItem;
    @FindBy(name = "dateOfAppointment")
    WebElement dateOfAppointment;
    @FindBy(name = "timeOfAppointment")
    WebElement timeOfAppointment;
    @FindBy(xpath = "//span[contains(text(),'Save & Continue')]")
    WebElement saveAndContinueBtn;
    @FindBy(xpath = "//span[contains(text(),'Save & Exit')]")
    WebElement saveAndExit;

    public appointmentPage() {
        BasePage.switchToWindow();
        BasePage.swtichToFrame(triageComponent);
    }

    public void insertDateOfInitialContact() {
        dateOfInitialContact.clear();
        dateOfInitialContact.click();
        dateOfInitialContact.sendKeys("01/12/2020");
    }

    public void inserTimeOfInitialContact() {
        timeOfInitialContact.clear();
        timeOfInitialContact.click();
        timeOfInitialContact.sendKeys("12:30 AM");
    }

    public void insertInternalTriageNotes() {
        internalTriageNotes.clear();
        internalTriageNotes.click();
        internalTriageNotes.sendKeys("Test");
    }

    public void selectReferralSource() {
        referralSourcedDropdownList.click();
        referralSourceItem.click();
    }

    public void selectReferralReason() {
        referralReasonDrodownList.click();
        referralReasonItem.click();
    }

    public void insertWasAppointmentGivenCheckbox() {
        wasAppointmentGiven.click();
    }

    public void selectappointmenType() {
        appointmenTypeDropdownList.click();
        appointmenTypeDropdownItem.click();
    }

    public void insertDateOfAppointment() {
        dateOfAppointment.clear();
        dateOfAppointment.click();
        dateOfAppointment.sendKeys("01/12/2020");
    }

    public void insertTimeOfAppointment() {
        timeOfAppointment.clear();
        timeOfAppointment.click();
        timeOfAppointment.sendKeys("12:00 PM");
    }

    public void clickOnSaveAndContinueBtn() {
        saveAndContinueBtn.click();
    }

    public void clickOnSaveAndExitBtn() {
        saveAndExit.click();
    }

}
