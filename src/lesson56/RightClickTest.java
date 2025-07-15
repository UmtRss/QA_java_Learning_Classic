package lesson56;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RightClickTest {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/context_menu");

        // Create Actions instance
        Actions actions = new Actions(driver);

        // Locate the box and right click
        WebElement box = driver.findElement(By.id("hot-spot"));
        actions.contextClick(box).perform();

        // Handle the alert
        String alertText = driver.switchTo().alert().getText();
        System.out.println("Alert text: " + alertText);
        driver.switchTo().alert().accept();

        driver.quit();
    }
}
