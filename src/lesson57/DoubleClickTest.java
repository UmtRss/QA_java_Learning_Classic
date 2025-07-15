package lesson57;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DoubleClickTest {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://api.jquery.com/dblclick/");

        // Switch to iframe
        driver.switchTo().frame(driver.findElement(By.tagName("iframe")));

        // Find the box and double click
        WebElement box = driver.findElement(By.cssSelector("div"));
        Actions actions = new Actions(driver);
        actions.doubleClick(box).perform();

        // Optional: Check style
        String style = box.getAttribute("style");
        System.out.println("Box style after double click: " + style);

        driver.quit();
    }
}
