package lesson49;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class WindowSwitchTest {
    public static void main(String[] args) throws InterruptedException {
        // 1. Setup WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // 2. Navigate to the window switching test page
        driver.get("https://the-internet.herokuapp.com/windows");

        // 3. Get the current window handle (parent)
        String originalWindow = driver.getWindowHandle();

        // 4. Click the "Click Here" link to open a new window
        WebElement clickHereLink = driver.findElement(By.linkText("Click Here"));
        clickHereLink.click();

        // 5. Get all window handles
        Set<String> windowHandles = driver.getWindowHandles();

        // 6. Switch to the new window
        for (String window : windowHandles) {
            if (!window.equals(originalWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }

        // 7. Wait a moment (optional)
        Thread.sleep(1000);

        // 8. Check if the new window has the expected title/text
        String expectedText = "New Window";
        String actualText = driver.findElement(By.tagName("h3")).getText();

        if (actualText.equals(expectedText)) {
            System.out.println("TEST PASSED ✅ - Switched to new window and verified content");
        } else {
            System.out.println("TEST FAILED ❌ - Text did not match");
        }

        // 9. Close the new window
        driver.close();

        // 10. Switch back to the original window
        driver.switchTo().window(originalWindow);

        // 11. Print original window title
        System.out.println("Back to original window: " + driver.getTitle());

        // 12. Quit the driver
        driver.quit();
    }
}
