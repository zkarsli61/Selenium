import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utils.TestBase;

public class Day08_TestBaseDemo extends TestBase {
/*Since i have before after methods in TestBase, don't use thme in here
* This is a TEST CLASS and will have only @Test method*/
    @Test
    public void test1(){
        driver.get("https://www.google.com");
//        If you see cookies then add this line
//        driver.findElement(By.xpath("//*[@id='L2AGLb']")).click();
        driver.findElement(By.name("q")).sendKeys("porcelain teapot"+ Keys.ENTER);
        System.out.println(driver.getPageSource());
        Assert.assertTrue(driver.getPageSource().contains("porcelain teapot"));
    }

    @Test
    public void test2() throws InterruptedException {
        driver.get("https://www.amazon.com");
        Thread.sleep(3000);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("porcelain teapot"+ Keys.ENTER);
        Assert.assertTrue(driver.getPageSource().contains("porcelain teapot"));
    }

}
