import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day06_Alert {
    static WebDriver driver;
    WebElement result;
    @BeforeClass
    public static void  setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
    }
    @Test
    public void acceptAlert(){
        driver.findElement(By.cssSelector("button[onclick='jsAlert()']")).click();
        String alertText = driver.switchTo().alert().getText();
        Assert.assertEquals("I am a JS Alert",alertText);
        driver.switchTo().alert().accept();
        String result = driver.findElement(By.id("result")).getText();
        Assert.assertEquals("You successfully clicked an alert",result);
    }
    @Test
    public void dismissAlert(){
//        click on the second alert,
        driver.findElement(By.cssSelector("button[onclick='jsConfirm()']")).click();
//        verify text "I am a JS Confirm”,

        Assert.assertEquals("Text Doesn't match", "I am a JS Confirm", driver.switchTo().alert().getText());
//        click cancel,
        driver.switchTo().alert().dismiss();
//        and Verify “You clicked: Cancel”
        String result = driver.findElement(By.id("result")).getText();
    Assert.assertEquals("Result Doesn't match","You clicked: Cancel",result);
    }
    @Test
    public void sendKeys(){
//        sendKeysAlert()=>
//        click on the third alert,
        driver.findElement(By.cssSelector("button[onclick='jsPrompt()']")).click();
//        verify text “I am a JS prompt”,
        String actual=driver.switchTo().alert().getText();
        String expected="I am a JS prompt";
        Assert.assertEquals(expected,actual);
//        type “Hello World”,
        driver.switchTo().alert().sendKeys("Hello World");
//        click OK,
        driver.switchTo().alert().accept();
//        and Verify “You entered: Hello World”
        String result = driver.findElement(By.id("result")).getText();
        Assert.assertEquals("You entered: Hello World",result);
        //done....any question
    }
}
