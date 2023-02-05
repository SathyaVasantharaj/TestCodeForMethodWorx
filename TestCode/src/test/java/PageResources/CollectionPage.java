
/*This class contains the locators and methods for Home -> Collection */
/*---------------------------------------------------------------------------------------------*/

package PageResources;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.List;

public class CollectionPage {

    public String addedStarter;
    WebDriver driver = null;
    By btn_searchLocation = By.xpath("/html/body/div[1]/div/div[1]/div[2]/div/div/div/div/div/div[1]/div/div[1]/div[2]/div/input");

    By btn_OrderforCollection = By.id("setRestaurantButton");

    By lnk_Starters = By.xpath("/html/body/div[1]/div/div[1]/div[2]/div/div[1]/section/div/div/h2[2]");


    By starterResults = By.xpath("/html/body/div[1]/div/div[1]/div[2]/div/div[3]/section/div[1]");


    By firstStarterAdd= By.xpath("/html/body/div[1]/div/div[1]/div[2]/div/div[3]/section/div[1]/div[2]/div/div[2]/div");
    By firstStarterItem =By.xpath("/html/body/div[1]/div/div[1]/div[2]/div/div[3]/section/div[1]/div[2]/div/div[1]/div[2]/div[1]");

    By btn_Basket = By.xpath("/html/body/div[1]/div/div[1]/div[1]/nav/div/div/div[2]");
    public CollectionPage(WebDriver driver) {
        this.driver = driver;
    }

    //This method is to get the location and enter in the search area
    public void enterlocation(String location) throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(btn_searchLocation).sendKeys(location);
        driver.findElement(btn_searchLocation).sendKeys(Keys.ENTER);
        Thread.sleep(4000);
    }

    //This method is to click on Order for Collection button on the selected Resturant
    public void clickOrderforCollection() throws InterruptedException {

       /* try {
            driver.findElement(btn_OrderforCollection).click();
        } catch (Exception e) {
            System.out.println("Order for collection not found");
        }
        */

        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Scroll down by pixels
        js.executeScript("window.scrollBy(0, 800)");

        WebElement element =  driver.findElement(btn_OrderforCollection);    //By default adding a starter
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
        Thread.sleep(1000);
    }

    //This method is to click on Starters
    public void clickonStarters() {
        driver.findElement(lnk_Starters).click();
    }

    //This method is to select the first starter displayed
    public String selectStarter() throws InterruptedException {

        Thread.sleep(3000);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Scroll down by 500 pixels
        js.executeScript("window.scrollBy(0, 800)");

        WebElement element =  driver.findElement(firstStarterAdd);    //By default adding a starter
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();

      /* StringBuilder xpath = new StringBuilder("/html/body/div[1]/div/div[1]/div[2]/div/div[3]/section/div[1]/div[");
        int i;
        for (i = 2; i <= 100; i++) {
            xpath.append(i).append(" or ");
        }
        xpath.delete(xpath.length() - 4, xpath.length());
        xpath.append("]/div/div[1]/div[2]/div[1]");
        System.out.println("value of i "+i);
        List<WebElement> elements = driver.findElements(By.xpath(xpath.toString()));
        System.out.println("size of elements are "+elements.size());
        int placeholderValue = 2 ;
        for (WebElement element1 : elements) {
            // process the element
            if(element1.getAttribute("innerText").equalsIgnoreCase(<String value>))
            {
                System.out.println("xpath is "+ element1.getAttribute("outerHTML"));
                break;
             }
             placeholderValue = placeholderValue++;
        }
        String xPathforSelectedStarter = "/html/body/div[1]/div/div[1]/div[2]/div/div[3]/section/div[1]/div["+placeholderValue+"]/div/div[2]/div";
        WebElement AddSelectedStarter = driver.findElement(By.xpath(xPathforSelectedStarter));
        AddSelectedStarter.click();
        */

        addedStarter =driver.findElement(firstStarterItem).getAttribute("innerText").toLowerCase().trim();
        System.out.println("Starter added is "+addedStarter);

        Thread.sleep(2000);
        WebElement element1=driver.findElement(btn_Basket);
        element1.click();

        Thread.sleep(3000);




        return addedStarter;




    }

    //This method is to verify the starter in basket is the same as added starter
    public void verifyStarter(String addedStarter)
    {

        String itemInBasket=driver.findElement(By.xpath(
                        "/html/body/div[1]/div/div[1]/div[2]/div/div[1]/section[1]/div/div[1]/div/div/div/div[1]/div[2]/div[1]"))
                .getAttribute("innerText")
                .toLowerCase()
                .trim();
        System.out.println("Item in the Basket is "+itemInBasket);

         Assert.assertEquals(addedStarter,itemInBasket);
        if(addedStarter.equalsIgnoreCase(itemInBasket))
            System.out.println("Verification success");
        else
            System.out.println("Verfication failed");
    }

    public void allResults()
    {


       List<WebElement> resultElements = driver.findElements(By.xpath("/html/body/div\\[1]/div/div\\[1]/div\\[2]/div/div\\[3]/section/div\\[1]/div\\[\\d]/div/div\\[1]/div\\[2]/div\\[1]\"\\)"));
        System.out.println(resultElements.size());
    }
}