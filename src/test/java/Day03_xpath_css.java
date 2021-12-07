import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day03_xpath_css {
    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void xpathTest(){
        driver.get("http://a.testaddressbook.com/sign_in");

        //locating email by xpath
        driver
                .findElement(By.xpath("//input[@type='email']"))
                .sendKeys("testtechproed@gmail.com");

        //locating password by xpath
        driver
                .findElement(By.xpath("(//input[@class='form-control'])[2]"))
                .sendKeys("Test1234!");

        //locating sign in button by xpath
        driver
                .findElement(By.xpath("//input[@type='submit']"))
                .click();

    }
}
