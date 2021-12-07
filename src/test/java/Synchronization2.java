import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.TestBase;

public class Synchronization2 extends TestBase {
    //HOMEWORK #3
    @Test
    public void isEnabled() {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement button = driver.findElement(By.cssSelector("#input-example > button"));

        button.click();

        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        Assert.assertTrue(message.getText().equals("It's enabled!"));

        WebElement textBox = driver.findElement(By.cssSelector("input[type='text']"));
        Assert.assertTrue(textBox.isEnabled());

        button.click();

        message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        Assert.assertTrue(message.getText().equals("It's disabled!"));
        Assert.assertTrue(!textBox.isEnabled());
    }
}
