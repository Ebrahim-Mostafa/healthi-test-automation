package pages.pharmacyScreens;

import BasePackage.BasePage;
import Utilities.JSUtils;
import Utilities.ObjectRepositoryJsonParser;
import org.openqa.selenium.WebElement;

public class PatientEHRPage extends BasePage {

    public Integer deliveredClinicalServicesCount(){
        WebElement deliveredCount = ObjectRepositoryJsonParser.getObjectLocator("$.PatientEHR.DeliveredClinicalServices");
        String count = deliveredCount.getText();
        Integer qty = Integer.valueOf(count);
        return qty;
    }
    public void clickOnAvailableClinicalServicesNMS(){
        WebElement NMS = ObjectRepositoryJsonParser.getObjectLocator("$.PatientEHR.NewMedicineService");
        JSUtils.scrollPageDown();
        JSUtils.clickElementByJS(NMS);
    }
}
