package Pages.pharmacyScreens;

import BasePackage.BasePage;
import Utilities.JSUtils;
import Utilities.ObjectRepositoryJsonParser;
import com.codoid.products.exception.FilloException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static BasePackage.BaseTest.driver;
import static Utilities.ExcelUtils.SelectCell;

public class NHSFluVaccinationServicePage extends BasePage {

    public void eligiblePatientGroup() {
        WebElement eligiblePatientGroupDropdown = ObjectRepositoryJsonParser.getObjectLocator("$.NHSFluVaccinationService.EligiblePatientGroup");
        elementClick(eligiblePatientGroupDropdown);
        WebElement pregnantWoman = ObjectRepositoryJsonParser.getObjectLocator("$.NHSFluVaccinationService.PregnantWoman");
        elementClick(pregnantWoman);
        WebElement feelUnwell = ObjectRepositoryJsonParser.getObjectLocator("$.NHSFluVaccinationService.FeelUnwell");
        elementClick(feelUnwell);
        WebElement allergicReaction = ObjectRepositoryJsonParser.getObjectLocator("$.NHSFluVaccinationService.AllergicReaction");
        elementClick(allergicReaction);
        WebElement allergicToAnything = ObjectRepositoryJsonParser.getObjectLocator("$.NHSFluVaccinationService.AllergicToAnything");
        elementClick(allergicToAnything);
        WebElement seasonalFlu = ObjectRepositoryJsonParser.getObjectLocator("$.NHSFluVaccinationService.SeasonalFlu");
        elementClick(seasonalFlu);
        WebElement otherVaccinations = ObjectRepositoryJsonParser.getObjectLocator("$.NHSFluVaccinationService.OtherVac");
        elementClick(otherVaccinations);
        WebElement currentMedicine = ObjectRepositoryJsonParser.getObjectLocator("$.NHSFluVaccinationService.CurrentMed");
        elementClick(currentMedicine);
        WebElement nextBtn = ObjectRepositoryJsonParser.getObjectLocator("$.NHSFluVaccinationService.NextBtn");
        elementClick(nextBtn);
    }

    public void consentNHSFluVacc(){
        WebElement givenConsent = ObjectRepositoryJsonParser.getObjectLocator("$.NHSFluVaccinationService.ConsentRecord");
        elementClick(givenConsent);
        WebElement nextBtn = ObjectRepositoryJsonParser.getObjectLocator("$.NHSFluVaccinationService.NextBtn");
        elementClick(nextBtn);
    }

    public void vaccinationAdministeredYes() throws FilloException {
        WebElement vaccinationAdministeredYes = ObjectRepositoryJsonParser.getObjectLocator("$.NHSFluVaccinationService.VaccinationAdministeredYes");
        elementClick(vaccinationAdministeredYes);
        WebElement routeOfAdministrationDropdown = ObjectRepositoryJsonParser.getObjectLocator("$.NHSFluVaccinationService.RouteOfAdministration");
        elementClick(routeOfAdministrationDropdown);
        WebElement Intramuscular = ObjectRepositoryJsonParser.getObjectLocator("$.NHSFluVaccinationService.Intramuscular");
        elementClick(Intramuscular);
        WebElement InjectionSiteDropdown = ObjectRepositoryJsonParser.getObjectLocator("$.NHSFluVaccinationService.InjectionSite");
        elementClick(InjectionSiteDropdown);
        WebElement LeftArm = ObjectRepositoryJsonParser.getObjectLocator("$.NHSFluVaccinationService.LeftArm");
        elementClick(LeftArm);
        WebElement dateOfAdministration = ObjectRepositoryJsonParser.getObjectLocator("$.NHSFluVaccinationService.DateOfAdministration");
        elementSendKeys(dateOfAdministration,SelectCell("Select * from NHSFLuVaccService where TestCaseName='NHSFluVac1'","DateOfAdmin"));
        WebElement timeOfAdministration = ObjectRepositoryJsonParser.getObjectLocator("$.NHSFluVaccinationService.TimeOfAdministration");
        elementSendKeys(timeOfAdministration,SelectCell("Select * from NHSFLuVaccService where TestCaseName='NHSFluVac1'","TimeOfAdmin"));
        WebElement vaccineSearch = ObjectRepositoryJsonParser.getObjectLocator("$.NHSFluVaccinationService.VaccineUsed");
        elementSendKeys(vaccineSearch,SelectCell("Select * from NHSFLuVaccService where TestCaseName='NHSFluVac1'","VaccineSearch"));
        vaccineSearch.sendKeys(Keys.ARROW_DOWN);
        vaccineSearch.sendKeys(Keys.RETURN);
        WebElement batchNo = ObjectRepositoryJsonParser.getObjectLocator("$.NHSFluVaccinationService.BatchNo");
        elementSendKeys(batchNo,SelectCell("Select * from NHSFLuVaccService where TestCaseName='NHSFluVac1'","BatchNum"));
        WebElement expiryDate = ObjectRepositoryJsonParser.getObjectLocator("$.NHSFluVaccinationService.ExpiryDate");
        elementSendKeys(expiryDate,SelectCell("Select * from NHSFLuVaccService where TestCaseName='NHSFluVac1'","ExpiryDate"));
        WebElement completeBtn = ObjectRepositoryJsonParser.getObjectLocator("$.NHSFluVaccinationService.CompleteBtn");
        elementClick(completeBtn);
    }

    public void vaccinationAdministeredNo(){
        WebElement vaccinationAdministeredNo = ObjectRepositoryJsonParser.getObjectLocator("$.NHSFluVaccinationService.VaccinationAdministeredNo");
        elementClick(vaccinationAdministeredNo);
        WebElement completeBtn = ObjectRepositoryJsonParser.getObjectLocator("$.NHSFluVaccinationService.CompleteBtn");
        elementClick(completeBtn);
    }

    public void completeTheService(){
        WebElement completeService = ObjectRepositoryJsonParser.getObjectLocator("$.NHSFluVaccinationService.CompleteService");
        Actions action = new Actions(driver);
        for (int i=1;i<=10;i++) {
            JSUtils.clickElementByJS(completeService);
//          action.doubleClick(completeService).perform();
        }
    }
}
