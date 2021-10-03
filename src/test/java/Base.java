import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class Base {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeSuite
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }

    @BeforeGroups
    public void impWait(){
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }

    @BeforeGroups
    public void expWait(){
        wait= new WebDriverWait(driver,10);
    }

    @AfterSuite
    public void teardown(){
        driver.quit();
    }
}
