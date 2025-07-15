package lesson36;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExplicitWaitTest {

    @Test
    public void handleExplicitWait() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        // Click on the Start button
        driver.findElement(By.cssSelector("#start button")).click();

        // Wait until the "Hello World!" text is visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement resultText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish")));

        // Print the text
        System.out.println("Text displayed: " + resultText.getText());

        driver.quit();
    }
}
