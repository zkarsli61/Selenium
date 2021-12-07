import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class WebTableRowColumns {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://computer-database.gatling.io/computers");
        driver.findElement(By.id("searchbox")).sendKeys("ACE");
        driver.findElement(By.id("searchsubmit")).click();
        List<WebElement> rows = driver.findElements(By.xpath("//table[@class='computers zebra-striped']/tbody/tr"));
        List<WebElement> cols = driver.findElements(By.xpath("//table[@class='computers zebra-striped']/thead/tr/th"));

        System.out.println("Number of rows is - " + rows.size() + " and columns is - " + cols.size());

        for (int i = 1; i <= rows.size(); i++) {
            WebElement row = driver.findElement(By.xpath("//table[@class='computers zebra-striped']/tbody/tr[" + i + "]"));
            String rowData = row.getText();
            System.out.println(rowData);
            if (rowData.contains("ACE")) {
                driver.findElement(By.xpath("//table[@class='computers zebra-striped']/tbody/tr[" + i + "]/td/a")).click();
                break;
            }
        }
    }
}

