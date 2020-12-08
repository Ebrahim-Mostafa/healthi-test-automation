package cucumber.steps;

import BasePackage.BasePage;
import BasePackage.BaseTest;
import pages.healthiScreens.loginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;


public class LoginTestBDD extends BaseTest {
    public static loginPage loginPage;

    public LoginTestBDD(){
        loginPage = new loginPage();
    }

    //    Given user is on the login page
    @Given("^user is on the login page$")
    public void user_is_on_the_login_page() {
        System.out.println("user on login page");
    }

    //    When user enters correct <username>
    @When("^user enters correct \"([^\"]*)\"$")
    public void user_enters_correct_username(String username) {
        loginPage.fillUserTextBox(username);
    }

    //    When user enters correct <password>
    @And("^user enters correct  \"([^\"]*)\"$")
    public void user_enters_correct_password(String password) {
        loginPage.fillPasswordTextBox(password);
    }

    //    When user click on signin button
    @And("^user click on signin button$")
    public void user_click_on_signin_button() {
        loginPage.clickOnSignInButton();
    }

    //    Then patient search page appears
    @Then("^patient search page appears$")
    public void patient_search_page_appears() {
        Assert.assertTrue(BasePage.getPageCurrentURL().contains("healthi-test"));
//        Assert.fail();
    }
}
