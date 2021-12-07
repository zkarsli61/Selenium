import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class Day08_Actions4 {

    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void scrollUpDown() throws InterruptedException {
        driver.get("https://www.amazon.com");

        Actions actions = new Actions(driver);

        /*
        * PAGE_DOWN  => scroll down the page
        * ARROW_DOWN => scroll down the page
        *
        * PAGE_UP  => scroll up
        * ARROW_UP => scroll up
        * */
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(1000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(1000);
        /*ARROW_DOWN scrolls the page down less than PAGE_DOWN*/
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(1000);
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(1000);
        /*PAGE_UP*/
        actions.sendKeys(Keys.PAGE_UP).perform();
        Thread.sleep(1000);
        /*ARROW_UP moves the page up a little bit*/
        actions.sendKeys(Keys.ARROW_UP).perform();

    }
}
