package healthiTests;

import BasePackage.BaseTest;
import Pages.healthiScreens.opticianEHRPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class opticianEHRTest extends BaseTest {
    public static opticianEHRPage opticianEHRPage;

    @BeforeClass
    public void initialization() {
        opticianEHRPage = new opticianEHRPage();
    }

    @Test
    public void clickOnMECService() {
        opticianEHRPage.clickOnClinicalService();
    }
}
