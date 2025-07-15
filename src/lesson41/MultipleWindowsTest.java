package lesson41;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class MultipleWindowsTest {

    @Test
    public void handleMultipleWindows() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/windows");

        // Click on the link to open a new window
        driver.findElement(By.linkText("Click Here")).click();

        // Get the main window handle
        String mainWindowHandle = driver.getWindowHandle();

        // Get all window handles
        Set<String> allWindowHandles = driver.getWindowHandles();

        // Switch to the new window
        for (String handle : allWindowHandles) {
            if (!handle.equals(mainWindowHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }

        // Read and print the heading in the new window
        String heading = driver.findElement(By.tagName("h3")).getText();
        System.out.println("New window heading: " + heading);

        // Close the new window and switch back to the main one
        driver.close();
        driver.switchTo().window(mainWindowHandle);
        driver.quit();
    }
}
