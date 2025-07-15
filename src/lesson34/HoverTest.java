package lesson34;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class HoverTest {

    @Test
    public void handleHoverActions() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/hovers");

        // Find all avatar elements (hover targets)
        List<WebElement> avatars = driver.findElements(By.className("figure"));

        // Actions class is used for hover
        Actions actions = new Actions(driver);

        // Hover over each avatar and check if 'View profile' is visible
        for (int i = 0; i < avatars.size(); i++) {
            WebElement avatar = avatars.get(i);
            actions.moveToElement(avatar).perform();

            Thread.sleep(1000); // Wait for the hover effect

            WebElement profileLink = avatar.findElement(By.linkText("View profile"));
            boolean isDisplayed = profileLink.isDisplayed();
            System.out.println("Avatar " + (i + 1) + " - View Profile link displayed: " + isDisplayed);
        }

        driver.quit();
    }
}
