package pages.pharmacyScreens;

import BasePackage.BasePage;
import Utilities.ObjectRepositoryJsonParser;
import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.List;

public class dashBoardPage extends BasePage {

    List<WebElement> ActionsTableRaw = ObjectRepositoryJsonParser.getObjectLocatorList("$.DashBoard.ActionPendingTable");

    public void ReturnActionTableTitle()
    {
       Iterator<WebElement> i = ActionsTableRaw.iterator();
        while (i.hasNext())
        {
            WebElement row = i.next();
            System.out.println(row.getText());
        }
    }
}
