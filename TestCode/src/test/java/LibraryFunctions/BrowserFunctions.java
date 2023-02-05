package LibraryFunctions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/* This class contains all generic reusable browser related functions*/
/*---------------------------------------------------------------------------------------------*/
public class BrowserFunctions {

    WebDriver driver = null;


    //initialising and returning the driver
    public WebDriver setupHomePage() {
        String browserPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", browserPath + "\\src\\main\\java\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.pizzaexpress.com/");
        return driver;
    }

     public void closeBrowser() {
        System.out.println("After the execution browser is closed");
        driver.quit();
      }

}
