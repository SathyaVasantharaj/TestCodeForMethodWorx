package LibraryFunctions;

import org.openqa.selenium.WebElement;
/* This class contains all generic reusable functions at object or element level*/
/*---------------------------------------------------------------------------------------------*/

public class GenericFunctions {


    public void ClickWebElement(WebElement webElement)
    {
        try {
            webElement.click();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
