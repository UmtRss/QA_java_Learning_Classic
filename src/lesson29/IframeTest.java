package lesson29;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IframeTest {

    @Test
    public void handleIframe() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/iframe");

        // Switch to iframe
        driver.switchTo().frame("mce_0_ifr");

        // Find the editor body (not input!) and overwrite content
        WebElement textBox = driver.findElement(By.id("tinymce"));
        textBox.sendKeys("\u0001"); // CTRL + A (select all)
        textBox.sendKeys("Iframe test passed successfully!");

        // Return to main page
        driver.switchTo().defaultContent();

        Thread.sleep(2000);
        driver.quit();
    }
}
