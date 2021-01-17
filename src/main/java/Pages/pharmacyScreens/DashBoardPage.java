package Pages.pharmacyScreens;

import BasePackage.BasePage;
import Utilities.ObjectRepositoryJsonParser;
import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.List;

public class DashBoardPage extends BasePage {

    List<WebElement> ActionsTableRaw = ObjectRepositoryJsonParser.getObjectLocatorList("$.DashBoard.ActionPendingTable");
    WebElement PatientRecords = ObjectRepositoryJsonParser.getObjectLocator("$.DashBoard.patientRecords");

    public void ReturnActionTableTitle(){
       Iterator<WebElement> i = ActionsTableRaw.iterator();
        while (i.hasNext())
        {
            WebElement row = i.next();
            System.out.println(row.getText());
        }
    }

    public void patientRecordsClick(){
        elementClick(PatientRecords);
    }
}
