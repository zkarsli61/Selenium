import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Day04_GoogleSearch extends Base {


    @Test
    public void teaPotSearch(){
        driver.get("https://www.google.com");
        WebElement searchText = driver.findElement(By.name("q"));
        searchText.sendKeys("porcelain teapot"+Keys.ENTER);

        String info = driver.findElement(By.cssSelector("div[id='result-stats']")).getText();
        System.out.println(info);

    }
}
