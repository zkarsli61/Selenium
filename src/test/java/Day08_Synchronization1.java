import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.TestBase;

public class Day08_Synchronization1 extends TestBase {

    @Test
    public void synchronization1(){
//        Create a class:Synchronization1. Create a method: synchronization1
//        Go to https://the-internet.herokuapp.com/dynamic_controls
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
//        Click on remove button
        driver.findElement(By.xpath("//button[.='Remove']")).click();
//        And verify the message is equal to “It's gone!”
//        WebElement goneElement = driver.findElement(By.xpath("//p[@id='message']"));
//        Assert.assertTrue(goneElement.getText().equals("It's gone!"));


        /*USING EXPLICIT WAIT:
        * 1. Create WebDriverWait Object
        * WebDriverWait wait = new WebDriverWait(driver,10);
        *
        * 2. Use wait object to wait for elements
        * */
        WebDriverWait wait = new WebDriverWait(driver,20);

        /*
        * Explicit wait does the followings:
        * 1. Wait for By.xpath("//p[@id='message']") up to 10 seconds
        * 2. If the xpath found in 10 seconds, the it is returned as WEBELEMENT
        * 3. If the element cannot be found in 10 seconds, step will fail. */
        WebElement goneElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        Assert.assertTrue(goneElement.getText().equals("It's gone!"));



//        Then click on Add button
//        And verify the message is equal to “It's back!”

        //Clicking on Add button
        driver.findElement(By.xpath("//button[.='Add']")).click();
        //Finding the message elements using explicit wait
        WebElement backElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        //Asserting if the text are matching
        Assert.assertTrue(backElement.getText().equals("It's back!"));

    }
}
