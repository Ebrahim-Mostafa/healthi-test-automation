package pages.pharmacyScreens;

import BasePackage.BasePage;
import Utilities.JSUtils;
import Utilities.ObjectRepositoryJsonParser;
import Utilities.TimeUtils;
import org.openqa.selenium.WebElement;

public class NewMedicineServicePage extends BasePage {


    public void NMSSwitchToFrame(){
        WebElement attentionPopupIframe = ObjectRepositoryJsonParser.getObjectLocator("$.NewMedicineService.AttentionPopupIframe");
        swtichToFrame(attentionPopupIframe);
    }
    public void NMSSwitchToSubFrame(){
        WebElement NMSProductSearchIframe = ObjectRepositoryJsonParser.getObjectLocator("$.NewMedicineService.NMS_Product_Search_Iframe");
        swtichToFrame(NMSProductSearchIframe);
    }
    public void ProceedNMSPopup(){
        NMSSwitchToFrame();
        WebElement attentionPopup_Proceed = ObjectRepositoryJsonParser.getObjectLocator("$.NewMedicineService.AttentionPopup_Proceed");
        if (elementIsDisplayed(attentionPopup_Proceed)) {
            elementClick(attentionPopup_Proceed);
        }
        else{
            System.out.println("No popup Found");
        }
    }

    public void CancelNMSPopup(){
        WebElement attentionPopup_Cancel = ObjectRepositoryJsonParser.getObjectLocator("$.NewMedicineService.AttentionPopup_Cancel");
        if (elementIsDisplayed(attentionPopup_Cancel)) {
            elementClick(attentionPopup_Cancel);
        }
        else{
            System.out.println("No popup Found");
        }
    }

    public void SelectEngagementTab(){
        WebElement engagementTab = ObjectRepositoryJsonParser.getObjectLocator("$.NewMedicineService.Engagement_Tab");
        JSUtils.clickElementByJS(engagementTab);
    }

    public void clickOnSelectEditBtn(){
        WebElement selectEditBtn = ObjectRepositoryJsonParser.getObjectLocator("$.NewMedicineService.Select_Edit_Btn");
        JSUtils.clickElementByJS(selectEditBtn);
    }

    public void productSearch(String medicine){
        NMSSwitchToSubFrame();
        WebElement searchBox = ObjectRepositoryJsonParser.getObjectLocator("$.NewMedicineService.Product_Search");
        elementClear(searchBox);
        elementSendKeys(searchBox,medicine);
        WebElement searchBtn = ObjectRepositoryJsonParser.getObjectLocator("$.NewMedicineService.SearchBtn");
        elementClick(searchBtn);
        WebElement warfarinOneMgCapsules = ObjectRepositoryJsonParser.getObjectLocator("$.NewMedicineService.Warfarin1mgcapsules");
        elementClick(warfarinOneMgCapsules);
        WebElement addProduct = ObjectRepositoryJsonParser.getObjectLocator("$.NewMedicineService.AddBtn");
        JSUtils.clickElementByJS(addProduct);
        WebElement oKBtn = ObjectRepositoryJsonParser.getObjectLocator("$.NewMedicineService.OKBtn");
        TimeUtils.mediumWait();
        JSUtils.clickElementByJS(oKBtn);
    }

    public void clickOnConsentCheckBox(){
        NMSSwitchToFrame();
        WebElement consentCheckBox = ObjectRepositoryJsonParser.getObjectLocator("$.NewMedicineService.ConsentCheckBox");
        JSUtils.clickElementByJS(consentCheckBox);
    }

    public void clickOnHealthyLivingAdviceCheckBox(){
        WebElement dietandnutritionCheckBox = ObjectRepositoryJsonParser.getObjectLocator("$.NewMedicineService.Dietandnutrition");
        JSUtils.clickElementByJS(dietandnutritionCheckBox);
    }

    public void ClickOnEngagementSessionCompletedCheckBox(){
        WebElement engagementSessionOutcomCheckBox = ObjectRepositoryJsonParser.getObjectLocator("$.NewMedicineService.EngagementSessionOutcom");
        JSUtils.clickElementByJS(engagementSessionOutcomCheckBox);
    }

    public void clickOnSaveBtn(){
        WebElement saveBtn = ObjectRepositoryJsonParser.getObjectLocator("$.NewMedicineService.SaveBtn");
        JSUtils.clickElementByJS(saveBtn);
    }

    public void clickOnNMSFromInProgressClinicalServices(){
        WebElement InProgressNMS = ObjectRepositoryJsonParser.getObjectLocator("$.NewMedicineService.InProgressNMS");
        TimeUtils.explicitWait(5);
        elementClick(InProgressNMS);
    }

    public void sendInterventionDate(String date){
        NMSSwitchToFrame();
        WebElement todaysDate = ObjectRepositoryJsonParser.getObjectLocator("$.NewMedicineService.InterventionDateField");
        TimeUtils.waitElement(todaysDate,5);
        elementClear(todaysDate);
        elementSendKeys(todaysDate,date);
    }

    public void clickOnInterventionReviewBtn(){
        WebElement reveiwBtn = ObjectRepositoryJsonParser.getObjectLocator("$.NewMedicineService.InterventionReviewBtn");
        JSUtils.clickElementByJS(reveiwBtn);
    }

    public void productReview(){
        NMSSwitchToSubFrame();
        WebElement usingMedicineAsPrescribed = ObjectRepositoryJsonParser.getObjectLocator("$.NewMedicineService.AsPrescribed");
        JSUtils.clickElementByJS(usingMedicineAsPrescribed);
        WebElement clickOnOkBtn = ObjectRepositoryJsonParser.getObjectLocator("$.NewMedicineService.OkBtn");
        JSUtils.clickElementByJS(clickOnOkBtn);
    }

    public void clickOnInterventionCompleteRadioBtn(){
        NMSSwitchToFrame();
        WebElement interventionCompleteRadioBtn = ObjectRepositoryJsonParser.getObjectLocator("$.NewMedicineService.InterventionComplete");
        JSUtils.clickElementByJS(interventionCompleteRadioBtn);
    }

    public void sendFollowUpDate(String date){
        NMSSwitchToFrame();
        WebElement todaysDate = ObjectRepositoryJsonParser.getObjectLocator("$.NewMedicineService.FollowUpDate");
        TimeUtils.waitElement(todaysDate,5);
        elementClear(todaysDate);
        elementSendKeys(todaysDate,date);
    }

    public void clickOnFollowUpReviewBtn(){
        WebElement reviewBtn = ObjectRepositoryJsonParser.getObjectLocator("$.NewMedicineService.FollowUpReviewBtn");
        JSUtils.clickElementByJS(reviewBtn);
    }

    public void clickOnFollowupCompleteRadioBtn(){
        NMSSwitchToFrame();
        WebElement followUpCompleteRadioBtn = ObjectRepositoryJsonParser.getObjectLocator("$.NewMedicineService.FollowUpComplete");
        JSUtils.clickElementByJS(followUpCompleteRadioBtn);
    }

    public void clickOnServiceCompleteBtn(){
        WebElement serviceCompleteBtn = ObjectRepositoryJsonParser.getObjectLocator("$.NewMedicineService.ServiceCompleteBtn");
        JSUtils.clickElementByJS(serviceCompleteBtn);
    }
}