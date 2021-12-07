import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class Day08_Actions3 {

    /*
Create a class: Actions3
Create test method : keysUpDown()
Go to google/amazon
Send iPhone X prices => convert small letter capital vice versa.
Highlight the search box by double clicking
* */
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void keysUpDown(){
        driver.get("https://www.google.com");
//        If you see cookies then add this line
//        driver.findElement(By.xpath("//*[@id='L2AGLb']")).click();
        WebElement searchBox = driver.findElement(By.xpath("//input[@name='q']"));
//        searchBox.sendKeys("iPhone X prices");
        Actions actions = new Actions(driver);
        actions
                .keyDown(searchBox, Keys.SHIFT)//press on shift button
                .sendKeys("iPhone X prices")//type on in the element
                .keyUp(searchBox,Keys.SHIFT)//unpress on shift button
                .sendKeys(" too expensive"+Keys.ENTER)//
                .build()//build is optionally used to make perform stronger.Without build(), this will work
                .perform();
    }
}
