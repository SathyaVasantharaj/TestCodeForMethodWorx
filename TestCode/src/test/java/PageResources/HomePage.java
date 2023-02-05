package PageResources;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/* Using Page Object model in this class.
* This class contains any locators and methods that are required at Home Page*/

/*---------------------------------------------------------------------------------------------*/
public class HomePage {


    WebDriver driver = null;

    By btn_Login = By.xpath("/html/body/div[1]/app-header/header/div/div[3]/div[2]/button/p");

    By lnk_Menu = By.xpath("/html/body/div[1]/app-header/header/div/div[2]/ul/li[1]/a");

    By lnk_Collection = By.xpath("/html/body/div[1]/app-header/header/div/div[2]/ul/li[3]/a");

    //Constructor
    public HomePage(WebDriver driver) {

        this.driver = driver;
    }

    //To click on the login button from home page
    public void clickonLoginButton() {

        driver.findElement(btn_Login).click();
    }

    //To Click on Menu from home page
    public void clickonMenu() {
       try{
           driver.findElement(lnk_Menu).click();
        }
       catch (Exception e){
           System.out.println(e.getMessage());
       }

    }

    public void clickonCollection()
    {
        try {
            driver.findElement(lnk_Collection).click();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
