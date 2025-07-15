package lesson58;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class HoverTest {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/hovers");

        // Create Actions instance
        Actions actions = new Actions(driver);

        // Hover over the first image (2nd img tag due to logo)
        WebElement image = driver.findElement(By.xpath("(//img)[2]"));
        actions.moveToElement(image).perform();

        // Check if the username text appears
        WebElement userName = driver.findElement(By.xpath("//h5[text()='name: user1']"));
        System.out.println("User text displayed: " + userName.isDisplayed());

        driver.quit();
    }
}
