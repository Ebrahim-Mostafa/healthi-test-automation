package pages.pharmacyScreens;

import BasePackage.BasePage;
import Utilities.JSUtils;
import Utilities.ObjectRepositoryJsonParser;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static BasePackage.BaseTest.driver;

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

    public void vaccinationAdministeredYes(){
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
        elementSendKeys(dateOfAdministration,"21/01/2021");
        WebElement timeOfAdministration = ObjectRepositoryJsonParser.getObjectLocator("$.NHSFluVaccinationService.TimeOfAdministration");
        elementSendKeys(timeOfAdministration,"01:30 PM");
        WebElement vaccineSearch = ObjectRepositoryJsonParser.getObjectLocator("$.NHSFluVaccinationService.VaccineUsed");
        elementSendKeys(vaccineSearch,"GSK - Fluarix TM Tetra (pack size 10)");
        vaccineSearch.sendKeys(Keys.ARROW_DOWN);
        vaccineSearch.sendKeys(Keys.RETURN);
        WebElement batchNo = ObjectRepositoryJsonParser.getObjectLocator("$.NHSFluVaccinationService.BatchNo");
        elementSendKeys(batchNo,"12345");
        WebElement expiryDate = ObjectRepositoryJsonParser.getObjectLocator("$.NHSFluVaccinationService.ExpiryDate");
        elementSendKeys(expiryDate,"01/2021");
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
