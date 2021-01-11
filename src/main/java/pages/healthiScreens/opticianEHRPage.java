package pages.healthiScreens;

import BasePackage.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class opticianEHRPage extends BasePage {

    @FindBy(xpath = "//*[@id='idIfr1162']")
    WebElement availableClinicalServicesFrame;
    @FindBy(xpath = "//button[@id='widget:rtable:dynaTable:1:fcolumns:1:j_id_56:0:redirectionCommandButton']//span[@class='ui-button-icon-left ui-icon ui-c ui-icon-circle-plus']")
    WebElement mecsIcon;

    public opticianEHRPage() {
        switchToWindow();
        swtichToFrame(availableClinicalServicesFrame);
    }

    public void clickOnClinicalService() {
        elementClick(mecsIcon);
    }
}
