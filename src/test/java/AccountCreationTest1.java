import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class AccountCreationTest1 {
    WebDriver driver;
    Faker faker = new Faker();
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @Test
    public void accountCreationTest(){
        driver.get("http://automationpractice.com/index.php");
        driver.findElement(By.linkText("Sign in")).click();
        driver.findElement(By.xpath("//input[@id='email_create']")).sendKeys(faker.internet().emailAddress());
        driver.findElement(By.xpath("//button[@id='SubmitCreate']")).click();
        WebElement accountElement = driver.findElement(By.xpath("//h1[@class='page-heading']"));
        Assert.assertTrue(accountElement.isDisplayed());
        WebElement personalInfoElement = driver.findElement(By.xpath("(//h3[@class='page-subheading'])[1]"));
        Assert.assertTrue(personalInfoElement.isDisplayed());
        WebElement titleElement = driver.findElement(By.xpath("//label[.='Title']"));
        Assert.assertTrue(titleElement.isDisplayed());
        WebElement mrsElement = driver.findElement(By.xpath("//label[@for='id_gender2']"));
        if(!mrsElement.isSelected()){
            mrsElement.click();
        }
        driver.findElement(By.xpath("//input[@id='customer_firstname']")).sendKeys(faker.name().firstName());
        driver.findElement(By.xpath("//input[@id='customer_lastname']")).sendKeys(faker.name().lastName());
        //driver.findElement(By.xpath("//input[@id='email']")).sendKeys("taren.wisozk@hotmail.com");
        driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys(faker.internet().password());
        WebElement day = driver.findElement(By.xpath("//select[@id='days']"));
        Select selectDay = new Select(day);
        selectDay.selectByValue("10");
        WebElement months = driver.findElement(By.xpath("//select[@id='months']"));
        Select selectMonths = new Select(months);
        selectMonths.selectByIndex(10);
        WebElement years = driver.findElement(By.xpath("//select[@id='years']"));
        Select selectYears = new Select(years);
        selectYears.selectByValue("2010");
        driver.findElement(By.xpath("//div[@id='uniform-newsletter']")).click();
        driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys(faker.name().firstName());
        driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys(faker.name().lastName());
        driver.findElement(By.xpath("//input[@id='company']")).sendKeys(faker.company().name());
        driver.findElement(By.xpath("//input[@id='address1']")).sendKeys(faker.address().streetAddress());
        driver.findElement(By.xpath("//input[@id='city']")).sendKeys(faker.address().city());
        WebElement state = driver.findElement(By.xpath("//select[@id='id_state']"));
        Select selectState = new Select(state);
        selectState.selectByIndex(10);
        driver.findElement(By.xpath("//input[@id='postcode']")).sendKeys(faker.address().zipCode());
        WebElement country = driver.findElement(By.xpath("//select[@id='id_country']"));
        Select selectCountry = new Select(country);
        selectCountry.selectByValue("21");
        driver.findElement(By.xpath("//textarea[@id='other']")).sendKeys(faker.artist().name());
        driver.findElement(By.xpath("//input[@id='phone']")).sendKeys(faker.phoneNumber().cellPhone());
        driver.findElement(By.xpath("//input[@id='phone_mobile']")).sendKeys(faker.phoneNumber().cellPhone());
        driver.findElement(By.xpath("//input[@id='alias']")).sendKeys(faker.name().name());
        // driver.findElement(By.xpath("//button[@id='submitAccount']")).click();



    }

}
