
/*Using Page Factory model in this class.
This contains any locators and methods that are required at Home-> Menu-> Main menu */
/*---------------------------------------------------------------------------------------------*/


package PageResources;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class MainmenuPage {

    WebDriver driver = null;

    //Constructor
    public MainmenuPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "/html/body/div/div/div[1]/div[2]/div/div/div/div/div[2]/div/div/div/div/div[1]/input")
    WebElement txtPostCode;

    @FindBy(xpath = "/html/body/div/div/div[1]/div[2]/div/div/div/div/div[2]/div/div/div/div/div[2]")
    WebElement containerLocationResults;

    //To enter the location/postcode in the search text button
    public void setInputPostCode(String location) {

        // wait(5000);
        System.out.println("Locations is " + location);
        if (txtPostCode.isDisplayed())
            System.out.println("Location search box is displayed");
        else
            System.out.println("Location search box not found");
        txtPostCode.sendKeys(location);
        txtPostCode.sendKeys(Keys.ENTER);
    }

    //To verify if the search has returned any results
    public void verifyResults() {


        String str = containerLocationResults.getAttribute("textContent");
        System.out.println(str);
        if (str.equalsIgnoreCase("Use my location"))
            System.out.println("No Results found or Invalid location entered");
        else
            System.out.println("Results found for Location search");

        Assert.assertFalse((str.equalsIgnoreCase("Use my location")), "No Results found or Invalid location entered");

    }

}
