package pages.pharmacyScreens;

import BasePackage.BasePage;
import Utilities.JSUtils;
import Utilities.ObjectRepositoryJsonParser;
import org.openqa.selenium.WebElement;

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

    public void vaccineDelivery(){
        WebElement vaccinationAdministered = ObjectRepositoryJsonParser.getObjectLocator("$.NHSFluVaccinationService.VaccinationAdministered");
        elementClick(vaccinationAdministered);
        WebElement completeBtn = ObjectRepositoryJsonParser.getObjectLocator("$.NHSFluVaccinationService.CompleteBtn");
        elementClick(completeBtn);
    }

    public void completeTheService(){
        WebElement completeService = ObjectRepositoryJsonParser.getObjectLocator("$.NHSFluVaccinationService.CompleteService");
        for (int i=1;i<=10;i++) {
          JSUtils.clickElementByJS(completeService);
        }
    }
}
