package lesson59;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class ClickAndHoldTest {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/test/simple_context_menu.html");

        Actions actions = new Actions(driver);
        WebElement button = driver.findElement(By.xpath("//button[text()='Double-Click Me To See Alert']"));

        // Click and hold on the button
        actions.clickAndHold(button)
                .pause(Duration.ofSeconds(2))
                .release()
                .perform();

        // Check for alert
        try {
            Alert alert = driver.switchTo().alert();
            System.out.println("Alert Text: " + alert.getText());
            alert.accept();
        } catch (NoAlertPresentException e) {
            System.out.println("No alert displayed after click and hold.");
        }

        driver.quit();
    }
}
