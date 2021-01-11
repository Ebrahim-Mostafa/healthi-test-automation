package pages.pharmacyScreens;

import BasePackage.BasePage;
import Utilities.ObjectRepositoryJsonParser;
import org.openqa.selenium.WebElement;

public class patientRecordsPage extends BasePage {

    WebElement Surname = ObjectRepositoryJsonParser.getObjectLocator("$.PatientRecords.Surname");
    WebElement FirstName = ObjectRepositoryJsonParser.getObjectLocator("$.PatientRecords.FirstName");
    WebElement DateOfBirth = ObjectRepositoryJsonParser.getObjectLocator("$.PatientRecords.DateOfBirth");
    WebElement Search_Btn = ObjectRepositoryJsonParser.getObjectLocator("$.PatientRecords.Search_Btn");

    public void fillSurname(String surname) {
        elementClear(Surname);
        elementClick(Surname);
        elementSendKeys(Surname, surname);
    }

    public void fillFirstName(String firstname) {
        elementClear(FirstName);
        elementClick(FirstName);
        elementSendKeys(FirstName, firstname);
    }

    public void fillDateOfBirth(String dateofbirth) {
        elementClear(DateOfBirth);
        elementClick(DateOfBirth);
        elementSendKeys(DateOfBirth, dateofbirth);
    }

    public void clickOnSearchBtn() {
        elementClick(Search_Btn);
    }

    public void clickOnSearchResult() {
        WebElement SearchedPatient = ObjectRepositoryJsonParser.getObjectLocator("$.PatientRecords.SearchedPatient");
        elementClick(SearchedPatient);
    }
}
