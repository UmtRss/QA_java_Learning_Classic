package lesson30;

import org.testng.annotations.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class WindowTest {

    @Test
    public void handleMultipleWindows() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/windows");

        // Store the original window
        String originalWindow = driver.getWindowHandle();

        // Click on the link that opens a new window
        driver.findElement(By.linkText("Click Here")).click();

        // Wait for the new window to appear
        Thread.sleep(2000);

        // Get all window handles
        Set<String> allWindows = driver.getWindowHandles();

        // Loop through windows and switch to the new one
        for (String windowHandle : allWindows) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        // Now we are in the new window
        System.out.println("New window title: " + driver.getTitle());
        System.out.println("New window text: " + driver.findElement(By.tagName("h3")).getText());

        // Switch back to original window (optional)
        driver.switchTo().window(originalWindow);

        Thread.sleep(2000);
        driver.quit();
    }
}
