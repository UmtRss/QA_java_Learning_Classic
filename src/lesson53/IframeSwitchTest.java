package lesson53;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IframeSwitchTest {
    public static void main(String[] args) throws InterruptedException {

        // 1. Setup
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/iframe");

        // 2. Switch to iframe using its ID
        driver.switchTo().frame("mce_0_ifr");

        // 3. Locate the text box inside iframe and type
        WebElement textBox = driver.findElement(By.id("tinymce"));
        textBox.sendKeys(Keys.CONTROL + "a");
        textBox.sendKeys(Keys.DELETE);
        textBox.sendKeys("Hello from inside the iframe!");


        // 4. Switch back to the main content
        driver.switchTo().defaultContent();

        // 5. Finish test
        System.out.println("✅ Test completed successfully.");
        driver.quit();
    }
}
