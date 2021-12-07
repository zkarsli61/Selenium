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

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Day05_DropDown {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/dropdown");
    }

//1.Create method selectByIndexTest and Select Option 1 using index
    @Test
    public void selectByIndexTest() throws InterruptedException {

        //1. locate the dropdown element
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        //2. use select object
        Select select = new Select(dropdown);
        //3. use any 3 method to select-index,value, visibletext
        Thread.sleep(5000);
        select.selectByIndex(1);
//        Thread.sleep(5000);
    }

    @Test
    public void selectByValueTest() throws InterruptedException {
        //2.Create method selectByValueTest Select Option 2 by value
        WebElement dropdown= driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdown);
        Thread.sleep(5000);
        select.selectByValue("2");

    }
//3.Create method selectByVisibleTextTest Select Option 1 value by visible text
    @Test
    public void selectByVisibleTextTest(){
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("Option 1");
    }
//4.Create method printAllTest Print all dropdown value
    @Test
    public void printAllTest(){
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdown);

        //getOptions(); returns all dropdown options as List<WebElement>
        List<WebElement> allOption = select.getOptions();

        //use a loop to get single elements
        for (WebElement eachOption : allOption){
            System.out.println(eachOption.getText());
        }
    }

//5.Create method printFirstSelectedOptionTest Print first selected option
    @Test
    public void printFirstSelectedOptionTest(){
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdown);
        WebElement firstSelectedOption = select.getFirstSelectedOption();
        System.out.println(firstSelectedOption.getText());
        //Asserting if selected option is Please select an option
        Assert.assertEquals("Please select an option",firstSelectedOption.getText());

    }

//6.Crate methods. sizeTest. Find the size of the dropdown,
// Print "Expected Is Not Equal Actual" if there are not 4 elements in the dropdown.
    @Test
    public void sizeTest(){
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdown);
        List<WebElement> allOptions = select.getOptions();
        int size = allOptions.size();
        Assert.assertEquals("Expected Is Not Equal Actual",4,size);
        //   Expected Is Not Equal Actual will be displayed ONLY IF THE ASSERTION FAILS
    }

    @After
    public void tearDown(){
        driver.close();
    }

    public static class Day05_CheckBox {

        WebDriver driver;
        @Before
        public void setUp(){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }

        @Test
        public void checkbox(){

    //        Go to https://the-internet.herokuapp.com/checkboxes 
    //        Locate the elements of checkboxes 


            driver.get("https://the-internet.herokuapp.com/checkboxes");
            WebElement checkbox1= driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
            WebElement checkbox2= driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));

            //        Then click on checkbox1 if box is NOT selected
            // isSelected() is used to check if checkbox or radio button is checked or unchecked
            // returns true if checkbox is already selected. Returns false if it is not selected
            if(!checkbox1.isSelected()){
                checkbox1.click();
            }


            //        Then click on checkbox2 if box is not selected
            if(!checkbox2.isSelected()){
                checkbox2.click();
            }

            //        Then verify that checkbox1 and checkbox 2 is checked.
            Assert.assertTrue(checkbox1.isSelected());
            Assert.assertTrue(checkbox2.isSelected());


        }
    }
}
