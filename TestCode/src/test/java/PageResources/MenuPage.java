
/*This class is using page factory model.
It contains any locators and methods that are at Home -> Menu */
/*---------------------------------------------------------------------------------------------*/

package PageResources;

import LibraryFunctions.GenericFunctions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class MenuPage {

    WebDriver driver = null;
    GenericFunctions gf=new GenericFunctions();

    @FindBy(xpath = "/html/body/div[1]/section[1]/div/div[1]/div/h2")
    WebElement txt_takeyourpick;

    @FindBy(xpath = "/html/body/div[1]/section[1]/div/div[2]/div/div/a[1]")
    WebElement lnk_Mainmenu;

    @FindBy(xpath = "/html/body/div[1]/section[1]/div/div[2]/div/div/a[2]")
    WebElement lnk_lunchmenu;

    @FindBy(xpath = "/html/body/div[1]/section[1]/div/div[2]/div/div/a[3]/div/div")
    WebElement lnk_piccolo;

    @FindBy(xpath = "/html/body/div[1]/section[1]/div/div[2]/div/div/a[4]/div/div/h3")
    WebElement lnk_vegan;

    @FindBy(name = "search-input")
    WebElement inputPostCode;

    //Constructor to initialise the driver and WebElements
    public MenuPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    //Verify if Main menu option is displayed
    public void verifyMainmenu() {
        //Reporter.log("Verfying Main menu link in the page");
        Assert.assertTrue(lnk_Mainmenu.isDisplayed(),"The link "+ lnk_Mainmenu.getText()+" is not found");
    }

    //Verfiy if Lunch Menu option is displayed
    public void verifyLunchmenu() {
       // Reporter.log("Verifying Lunchmenu link in the page");
        Assert.assertTrue(lnk_Mainmenu.isDisplayed(),"The link "+ lnk_lunchmenu.getText()+" is not found");
    }

    //Verify if Piccolo option is displayed
    public void verifyPiccolo() {
       // Reporter.log("Verifying Piccolo link in the page");
        Assert.assertTrue(lnk_Mainmenu.isDisplayed(),"The link "+ lnk_piccolo.getText()+" is not found");
    }

    //Verify if Vegan option is displayed
    public void verifyVegan() {
       // Reporter.log("Verifying Vegan link in the page");
        Assert.assertTrue(lnk_Mainmenu.isDisplayed(),"The link "+ lnk_vegan.getText()+" is not found");
    }

    // To verify the display Text
   public void verifyText()
   {
       Assert.assertTrue(txt_takeyourpick.isDisplayed(),"The link "+ txt_takeyourpick.getText()+" is not found");
       if(txt_takeyourpick.isDisplayed())
       {
           System.out.println("Take your pick text is displayed");
       }
       else
       {
           System.out.println("user not in menu page or assertion not found");
       }
   }

   //The Following methods are for clicking on the menu options
   public void clickMainMenu()
   {
       gf.ClickWebElement(lnk_Mainmenu);
   }

   public void clickPiccoloMenu()
   {
       gf.ClickWebElement(lnk_piccolo);
   }

   public void clickLunchMenu(){
        gf.ClickWebElement(lnk_lunchmenu);
    }

    public void clickVeganMenu()
    {
        gf.ClickWebElement(lnk_vegan);
    }


    //Verify if user is able to enter the postcode
    public void verifyPostCodeEnter()
    {
        Assert.assertTrue(inputPostCode.isDisplayed(),"Search with PostCode element not enabled");
        if(inputPostCode.isEnabled())
            System.out.println("Postcode is enabled for user to Enter");
        else
            System.out.println("Postcode cannot be entered");

    }
}