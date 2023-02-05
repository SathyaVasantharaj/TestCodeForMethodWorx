

/*This class contains the Steps definitions for Home->Menu->Main menu */
/*---------------------------------------------------------------------------------------------*/


package StepDefinitions;

import LibraryFunctions.BrowserFunctions;
import PageResources.HomePage;
import PageResources.MainmenuPage;
import PageResources.MenuPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class Stepdefitions_MainMenuPage {


    WebDriver driver = null;
    BrowserFunctions BF = new BrowserFunctions();

    //Opens the browser and go to the menu and main menu
    @Given("User navigates Home Page-> Menu -> Main Menu")
    public void userNavigatesHomePageMenuMainMenu() {
        driver = BF.setupHomePage();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        HomePage hp = new HomePage(driver);  //POM attributes for HomePage
        hp.clickonMenu();
        System.out.println("Clicked Menu from the home page");
        MenuPage pg = new MenuPage(driver);
        pg.clickMainMenu();
    }

    //Once Location/ postcode is entered user should be able to see the results
    @Then("User should be able to see restaurants nearby")
    public void userShouldBeAbleToSeeRestaurantsNearby() {
        MainmenuPage mmp= new MainmenuPage(driver);
        mmp.verifyResults();
       driver.close();
    }


    //When the user enters the location
    @When("User enters the Location {string}")
    public void userEntersTheLocation(String location) throws InterruptedException {
        MainmenuPage mmp= new MainmenuPage(driver);
        mmp.setInputPostCode(location);
        Thread.sleep(4000);

    }
}
