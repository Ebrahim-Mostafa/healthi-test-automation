package pages.pharmacyScreens;

import BasePackage.BasePage;
import Utilities.JSUtils;
import Utilities.ObjectRepositoryJsonParser;
import Utilities.TimeUtils;
import org.openqa.selenium.WebElement;

public class PatientEHRPage extends BasePage {

    public Integer deliveredClinicalServicesCount(){
        TimeUtils.shortWait();
        WebElement deliveredCount = ObjectRepositoryJsonParser.getObjectLocator("$.PatientEHR.DeliveredClinicalServices");
        String count = deliveredCount.getText().split("[\\(\\)]")[1];
        int qty = Integer.parseInt(count);
//      Integer qty = Integer.valueOf(count);
        return qty;
    }

    public void clickOnAvailableClinicalServicesNMS(){
        WebElement NMS = ObjectRepositoryJsonParser.getObjectLocator("$.PatientEHR.NewMedicineService");
        JSUtils.scrollPageDown();
        JSUtils.clickElementByJS(NMS);
    }

    public void clickOnAvailableClinicalServicesNHSFluVac(){
        WebElement NHS = ObjectRepositoryJsonParser.getObjectLocator("$.PatientEHR.NHSFluVaccinationService");
        elementClick(NHS);
    }

    public void handleClinicalSafetyWarning(){
        WebElement warning = ObjectRepositoryJsonParser.getObjectLocator("$.PatientEHR.ClinicalSafetyWarning");
        elementClick(warning);
    }
}
