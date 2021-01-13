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
        switchToWindow();
        swtichToFrame(triageComponent);
    }

    public void insertDateOfInitialContact() {
        elementClear(dateOfInitialContact);
        elementClick(dateOfInitialContact);
        elementSendKeys(dateOfInitialContact,"01/01/2021");
    }

    public void inserTimeOfInitialContact() {
        elementClear(timeOfInitialContact);
        elementClick(timeOfInitialContact);
        elementSendKeys(timeOfInitialContact,"12:30 AM");
    }

    public void insertInternalTriageNotes() {
        elementClear(internalTriageNotes);
        elementClick(internalTriageNotes);
        elementSendKeys(internalTriageNotes,"Test");
    }

    public void selectReferralSource() {
        elementClick(referralSourcedDropdownList);
        elementClick(referralSourceItem);
    }

    public void selectReferralReason() {
        elementClick(referralReasonDrodownList);
        elementClick(referralReasonItem);
    }

    public void insertWasAppointmentGivenCheckbox() {
        elementClick(wasAppointmentGiven);
    }

    public void selectappointmenType() {
        elementClick(appointmenTypeDropdownList);
        elementClick(appointmenTypeDropdownItem);
    }

    public void insertDateOfAppointment() {
        elementClear(dateOfAppointment);
        elementClick(dateOfAppointment);
        elementSendKeys(dateOfAppointment,"01/01/2021");
    }

    public void insertTimeOfAppointment() {
        elementClear(timeOfAppointment);
        elementClick(timeOfAppointment);
        elementSendKeys(timeOfAppointment,"12:00 PM");
    }

    public void clickOnSaveAndContinueBtn() {
        elementClick(saveAndContinueBtn);
    }

    public void clickOnSaveAndExitBtn() {
        elementClick(saveAndExit);
    }

}
