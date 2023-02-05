
/*This class contains the Steps definitions for Home->Login and Home-> Login-> Login overlay */
/*---------------------------------------------------------------------------------------------*/


package StepDefinitions;

import LibraryFunctions.BrowserFunctions;
import PageResources.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;


public class StepDefinitions_LoginPage {

    WebDriver driver = null;

    BrowserFunctions LF = new BrowserFunctions();  // Library Functions for browser related actions

    // Setup the browser and go to home page
    @Given("The homepage is open")
    public void the_homepage_is_open() {
        driver = LF.setupHomePage();  //initialising and returning the driver

    }

    //Click on Login button from home page
    @Given("user clicks on Login")
    public void user_clicks_on_login() {
        HomePage hp = new HomePage(driver);      //POM attributes for HomePage
        hp.clickonLoginButton();
    }


    //user clicks on login with email button on the overlay
    @When("And user clicks on Login with Email address")
    public void user_click_on_login_with_emailid() {
        //to click on Login with Email. Need to handle CAPTCHA
    }

    //Verify if  login is successful
    @Then("User should be able to login successfully and see the firstname")
    public void user_should_be_able_to_login() {

    }

    //User enters the user name and password
    @When("User enters {string}, {string}")
    public void userEnters(String arg0, String arg1) {
    }
}
