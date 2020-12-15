package tests.mecsTests;

import BasePackage.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.mecScreens.managementPlanPage;

public class managementPlanTest extends BaseTest {
    public static managementPlanPage managementPlanPage;

    @BeforeClass
    public void initialization() {
        managementPlanPage = new managementPlanPage();
    }

    @Test
    public void nextOutcome() {
        managementPlanPage.clickOnAdviceGivenToPatientCheckBox();
        managementPlanPage.clickOnReassuredProblemSettled();
        managementPlanPage.clickOnNextOutcomeBtn();
    }

}
