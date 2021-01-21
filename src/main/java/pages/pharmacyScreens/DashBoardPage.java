package pages.pharmacyScreens;

import BasePackage.BasePage;
import Utilities.ObjectRepositoryJsonParser;
import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.List;

public class DashBoardPage extends BasePage {

    List<WebElement> ActionsTableRaw = ObjectRepositoryJsonParser.getObjectLocatorList("$.DashBoard.ActionPendingTable");
    WebElement PatientRecords = ObjectRepositoryJsonParser.getObjectLocator("$.DashBoard.patientRecords");
    WebElement icon = ObjectRepositoryJsonParser.getObjectLocator("$.DashBoard.XIcon");

    public void ReturnActionTableTitle(){
       Iterator<WebElement> i = ActionsTableRaw.iterator();
        while (i.hasNext())
        {
            WebElement row = i.next();
            System.out.println(row.getText());
        }
    }

    public void patientRecordsClick(){
        elementClick(icon);
        elementClick(PatientRecords);
    }
}
