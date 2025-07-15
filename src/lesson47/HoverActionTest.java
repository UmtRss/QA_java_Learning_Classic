package lesson47;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class HoverActionTest {
    public static void main(String[] args) throws InterruptedException {
        // 1. Setup WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // 2. Navigate to the hover test page
        driver.get("https://the-internet.herokuapp.com/hovers");

        // 3. Find the first user avatar
        WebElement firstAvatar = driver.findElement(By.xpath("(//div[@class='figure'])[1]"));

        // 4. Create Actions object and perform hover
        Actions actions = new Actions(driver);
        actions.moveToElement(firstAvatar).perform();

        // 5. After hover, locate the "View profile" link
        WebElement viewProfileLink = driver.findElement(By.xpath("(//div[@class='figcaption']//a)[1]"));

        // 6. Check if the link is displayed
        if (viewProfileLink.isDisplayed()) {
            System.out.println("TEST PASSED ✅ - View Profile link is visible after hover");

            // 7. Click on the profile link
            viewProfileLink.click();

            // 8. Optional: Check redirected page URL or content
            String currentUrl = driver.getCurrentUrl();
            if (currentUrl.contains("/users/1")) {
                System.out.println("TEST PASSED ✅ - Redirected to correct profile page");
            } else {
                System.out.println("TEST FAILED ❌ - Wrong redirection");
            }
        } else {
            System.out.println("TEST FAILED ❌ - View Profile link is NOT visible after hover");
        }

        // 9. Close the browser
        driver.quit();
    }
}
