import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day04_GoogleSearch {

    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //ADDING IMPLICIT WAIT: Implicit wait is DYNAMIC WAIT.
        //WAIT UP TO 30 second WHEN NEEDED
        //This means, if driver needs 1 seconds wait, then wait will be ONLY 1 seconds
        //Why wait is needed?
        //page is slow due to lots of image, videos, iframe,...
        //internet is slow
        //database is slow
        //local computer is slow
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();


    }

    @Test
    public void teaPotSearch(){
        driver.get("https://www.google.com");
        driver
                .findElement(By.xpath("//input[@name='q']"))
                .sendKeys("porcelain teapot"+ Keys.ENTER);

        //Printing the number of results
        String resultText = driver
                .findElement(By.xpath("//div[@id='result-stats']"))
                .getText()
                .substring(6,17);
        System.out.println(resultText);//18,800,000

    }
    @After
    public void tearDown(){
        driver.close();
    }
}
