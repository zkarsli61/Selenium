import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class AccountCreationTest {
// Send your email and click on create an account button.We will use that email.
// Make sure to save that email. If the email is already used for account creation\
// you can not use it again

    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       wait = new WebDriverWait(driver,10);
        driver.manage().window().maximize();
    }

//    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void signIn(){
        Faker faker = new Faker();
        // Go to http://automationpractice.com/index.php
        driver.get("http://automationpractice.com/index.php");

        // Click on sign in link
        WebElement linkSignIn = driver.findElement(By.linkText("Sign in"));
        linkSignIn.click();

        // Send your email
        WebElement txtEMail = driver.findElement(By.id("email_create"));
        txtEMail.sendKeys(faker.internet().emailAddress());

        // click on create an account button.We
        WebElement btnCreateAccount = driver.findElement(By.id("SubmitCreate"));
        btnCreateAccount.click();

        //Verify the Text : CREATE AN ACCOUNT
//        wait.until(ExpectedConditions.urlToBe("http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation"));

        WebElement header1 = driver.findElement(By.tagName("h1"));
        // WebElement header1 = driver.findElement(By.cssSelector("#noSlide > h1"));
        Assert.assertEquals(header1.getText(),"CREATE AN ACCOUNT");

        // Verify the Text : YOUR PERSONAL INFORMATION
        WebElement header3 = driver.findElement(By.cssSelector("#account-creation_form > div:nth-child(1) > h3"));
        Assert.assertEquals(header3.getText(),"YOUR PERSONAL INFORMATION");

        // Verify the Text : Title
//        WebElement labelTitle = driver.findElement(By.cssSelector("#account-creation_form > div:nth-child(1) > div.clearfix > label"));
        WebElement labelTitle = driver.findElement(By.cssSelector("div.clearfix > label"));
        Assert.assertEquals(labelTitle.getText(),"Title");

        // Select your title
        driver.findElement(By.id("id_gender1")).click();

        // Enter your first name
        driver.findElement(By.id("customer_firstname")).sendKeys(faker.name().firstName());
        // Enter your last name
        driver.findElement(By.id("customer_lastname")).sendKeys(faker.name().lastName());
        // Enter your email
        // driver.findElement(By.id("")).click();
        // Enter your password
        driver.findElement(By.id("passwd")).sendKeys(faker.internet().password());
        // ENTER DATE OF BIRTH
        Date birthDate = faker.date().birthday();
        Calendar cal = Calendar.getInstance();
        cal.setTime(birthDate);
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        Select dayOfBirth = new Select(driver.findElement(By.id("days")));
        dayOfBirth.selectByValue(day+"");

        Select mounthOfBirth = new Select(driver.findElement(By.id("months")));
        mounthOfBirth.selectByValue(month+"");

        Select yearOfBirth = new Select(driver.findElement(By.id("years")));
        yearOfBirth.selectByValue(year+"");

        // Click on Sign up for our newsletter!
        WebElement cboxnewsletter = driver.findElement(By.id("newsletter"));

        cboxnewsletter.click();

        // Enter your first name
        // Enter your last lane
        // Enter your company
        driver.findElement(By.id("company")).sendKeys(faker.company().name());
        // Enter your Address
        driver.findElement(By.id("address1")).sendKeys(faker.address().streetAddress());
        driver.findElement(By.id("address2")).sendKeys(faker.address().streetAddress());
        // Enter your City
        WebElement city = driver.findElement(By.id("city"));
        city.sendKeys(faker.address().city());

        // SELECT STATE
        Select state = new Select(driver.findElement(By.id("id_state")));
        state.selectByVisibleText("Illinois");

        // Enter Postal Code
        driver.findElement(By.id("postcode")).sendKeys(faker.address().zipCode());
        // SELECT COUNTRY
        Select country = new Select(driver.findElement(By.id("id_country")));
        country.selectByIndex(1);
        // Enter additional information
        driver.findElement(By.id("other")).sendKeys("no add info");
        // Enter home phone
        driver.findElement(By.id("phone")).sendKeys(faker.phoneNumber().phoneNumber());
        // Enter mobile phone
        driver.findElement(By.id("phone_mobile")).sendKeys(faker.phoneNumber().cellPhone());
        // Assign an address alias for future reference
        driver.findElement(By.id("alias")).sendKeys("Ref TechPro");

        // driver.findElement(By.id("submitAccount")).click();

    }
}
