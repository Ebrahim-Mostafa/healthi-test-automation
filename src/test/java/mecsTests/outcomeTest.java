package mecsTests;

import BasePackage.BaseTest;
import Pages.mecScreens.outcomePage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class outcomeTest extends BaseTest {
    public static outcomePage outcomePage;
    @BeforeClass
    public void initialization(){
        outcomePage=new outcomePage();
    }

    @Test
    public void ReviewBtn() {
        outcomePage.selectOutcome();
        outcomePage.clickOnReviewBtn();
        outcomePage.reviewConsultation();
        outcomePage.clickOnSaveAndExitBtn();
    }
}
