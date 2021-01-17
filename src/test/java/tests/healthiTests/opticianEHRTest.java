package tests.healthiTests;

import BasePackage.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Pages.healthiScreens.opticianEHRPage;

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
