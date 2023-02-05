/*This class contains the Steps definitions for Home->Collection */
/*---------------------------------------------------------------------------------------------*/


package StepDefinitions;

import LibraryFunctions.BrowserFunctions;
import PageResources.CollectionPage;
import PageResources.HomePage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class StepDefinitions_CollectionPage {

    WebDriver driver = null;
    BrowserFunctions BF = new BrowserFunctions();


    @Given("The user at Collection page")
    public void the_user_at_collection_page() {

        driver = BF.setupHomePage();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        HomePage hp = new HomePage(driver);
        hp.clickonCollection();
    }


    @Given("Add restaurant for collection {string}")
    public void addRestaurantForCollection(String location) throws InterruptedException {
        System.out.println("Location is " + location);
        CollectionPage CP = new CollectionPage(driver);
        CP.enterlocation(location);
        CP.clickOrderforCollection();
    }

    public String addedStarter;

    @When("User adds a starter to basket")
    public void userAddsAStarterToBasket() throws InterruptedException {
        CollectionPage CP = new CollectionPage(driver);
        CP.clickonStarters();
        addedStarter = CP.selectStarter();

    }

    @Then("user should be able to see the added item in the basket")
    public void user_should_be_able_to_see_the_added_item_in_the_basket() {
        CollectionPage CP = new CollectionPage(driver);
        CP.verifyStarter(addedStarter);

        driver.close();
    }


    //This method can be used if DataTable is used from feature file, add the items into a Map
    @And("Add restaurant for collection <location> , <RestaurantName>")
    public void addRestaurantForCollectionLocationRestaurantName(DataTable dataTable) {
        Map<String, String> details = dataTable.asMap(String.class, String.class);

        for (Map.Entry<String, String> entry : details.entrySet()) {
            String location = entry.getKey();
            String Restarauntname = entry.getValue();

        }
        //Search for the location
        //From the results search for Restarauntname and click on Order for Collection
    }
}
