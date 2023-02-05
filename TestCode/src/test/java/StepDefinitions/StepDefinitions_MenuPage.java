
/* This class contains the Steps definitions for Home->Menu */
/*---------------------------------------------------------------------------------------------*/


package StepDefinitions;

import LibraryFunctions.BrowserFunctions;
import PageResources.HomePage;
import PageResources.MenuPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;


public class StepDefinitions_MenuPage {

    WebDriver driver = null;
    BrowserFunctions LF = new BrowserFunctions();  // Library Functions for browser related actions

    //Setting up browser and go to the Homoe page
    @Given("The user at home page")
    public void the_user_at_home_page() {
           driver = LF.setupHomePage();  //initialising and returning the driver
    }

    //When user is at home page , click on the Menu
    @When("user clicks on Menu")
    public void user_clicks_on_menu()  {
        driver.manage().window().maximize();
        HomePage hp = new HomePage(driver);  //POM attributes for HomePage
        hp.clickonMenu();
        System.out.println("Clicked Menu from the home page");
    }

    //When user clicks on Menu, then user should be able to see the menu options
    @Then("user should be able to see the main menu options")
    public void user_should_be_able_to_see_the_main_options() {
        System.out.println("Verifying the links Main menu, Lunch menu, Piccolo, Vegan");
        MenuPage pg= new MenuPage(driver);
        pg.verifyMainmenu();
        pg.verifyLunchmenu();
        pg.verifyPiccolo();
        pg.verifyVegan();
        driver.close();

    }


    // Browser us set up and user is at home page and verify for Take your pick text displayed
    @Given("The user is at menu page")
    public void the_user_is_at_menu_page() {
        the_user_at_home_page();           // Reusing method to intiate the browser and open the webpage
        user_clicks_on_menu();             // Reusing method to click on Menu from home page
        MenuPage pg= new MenuPage(driver);
        pg.verifyText();
    }

    //User clicks on any of Main menu, Lunch menu, Piccolo, Vegan
    @When("user clicks on any Menu Option {string}")
    public void user_clicks_on_any_menu_option(String string) {
        MenuPage pg = new MenuPage(driver);

        if (string.equalsIgnoreCase("Main menu")) {
            pg.clickMainMenu();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        }
        else if (string.equalsIgnoreCase("Piccolo")) {
            pg.clickPiccoloMenu();

        }
        else if (string.equalsIgnoreCase("vegan")) {
            pg.clickVeganMenu();

        }
        else if (string.equalsIgnoreCase("Lunch menu")) {
            pg.clickLunchMenu();

        }
    }


    //User entering the postcode/location in the search option
    //Closing the browser
    @Then("should be able to enter the location\\/postcode")
    public void shouldBeAbleToEnterTheLocationPostcode() {
       MenuPage mp= new MenuPage(driver);
       mp.verifyPostCodeEnter();
        closeBrowser();

    }

    public void closeBrowser()
    {
        driver.close();
    }
}



