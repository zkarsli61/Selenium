import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Day07_AmazonDropDown {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @Test
    public void dropdownTest(){
        driver.get("https://www.amazon.com/");
        Select kategori= new Select(driver.findElement(By.id("searchDropdownBox")));
        Assert.assertEquals("All Departments",kategori.getFirstSelectedOption().getText());

        kategori.selectByIndex(3);
        Assert.assertEquals("Baby",kategori.getFirstSelectedOption().getText());

        List<WebElement> options = kategori.getOptions();

        List<String> optionValues = new ArrayList();

        for (WebElement option:options) {
            optionValues.add(option.getText());
        }
        System.out.println(optionValues);
        System.out.println("Total number of options : " + options.size());
        Assert.assertFalse(options.contains("Appliance"));

        List<String> tempList = new ArrayList(optionValues);

        Collections.sort(tempList);
        System.out.println(tempList);

        Assert.assertTrue(optionValues.equals(tempList));

    }
    @After
    public void tearDown(){
        driver.close();
    }

}
