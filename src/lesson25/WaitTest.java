package lesson25;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitTest {

    public static void main(String[] args) {

        // Create BaseTest instance and start WebDriver
        BaseTest base = new BaseTest();
        base.setup();

        WebDriver driver = base.driver;

        try {
            // Locate username field and enter value
            WebElement usernameInput = driver.findElement(By.id("username"));
            usernameInput.sendKeys("student");

            // Locate password field and enter value
            WebElement passwordInput = driver.findElement(By.id("password"));
            passwordInput.sendKeys("Password123");

            // Use explicit wait for the login button to be clickable
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("submit")));

            loginButton.click();

            // Use explicit wait to verify successful login
            WebElement successMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));
            String actualText = successMsg.getText();

            if (actualText.contains("Logged In Successfully")) {
                System.out.println("✅ Login successful!");
            } else {
                System.out.println("❌ Unexpected success message.");
            }

        } catch (Exception e) {
            System.out.println("⚠️ Test failed with exception: " + e.getMessage());
        } finally {
            // Always close the browser
            base.teardown();
        }
    }
}
