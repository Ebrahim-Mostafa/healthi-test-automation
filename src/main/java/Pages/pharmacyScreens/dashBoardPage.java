package Pages.pharmacyScreens;

import BasePackage.BasePage;
import org.openqa.selenium.WebElement;

import java.util.List;

public class dashBoardPage extends BasePage {

    List<WebElement> ActionsTable = BasePage.getObjectLocatorList("$.DashBoard.ActionPendingTable");

    public void ReturnActionTableTitle()
    {
        java.util.Iterator<WebElement> i = ActionsTable.iterator();
        while (i.hasNext())
        {
            WebElement row = i.next();
            System.out.println(row.getText());
        }
    }


}
