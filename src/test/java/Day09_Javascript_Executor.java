import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.theories.Theories;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utils.TestBase;

public class Day09_Javascript_Executor extends TestBase {
/*
* Javascript Executor can be used to handle some browser events
* -scroll up/down/right/left
* -scroll into an element
* -click
* -generate alert
* -change the color
* -...
*
* NOTE: scrollIntoView method scrolls to the desired element
* It automatically scroll to the element
* If the element is at the bottom, this scrolls to the bottom
* If element is at the right, this scrolls to the right ...
* */

    @Test
    public void scrollIntoView() throws InterruptedException {
        driver.get("http://www.carettahotel.com/");
          /*
//        * Given user is on the application url
//        * Then verify the text "Recent Blog" is on the page
//        * */


        //Creating javascript executor object
        JavascriptExecutor je = (JavascriptExecutor) driver;
        //Scrolling down to the element using scrollIntoView(true) method

        //We will scroll down to this element
        WebElement resentBlog = driver.findElement(By.xpath("//*[.='Recent Blog']"));
        je.executeScript("arguments[0].scrollIntoView(true);",resentBlog);

        //Waiting for 3 second for the element text
        Thread.sleep(3000);

        Assert.assertEquals(resentBlog.getText(),"Recent Blog");

    }


}
