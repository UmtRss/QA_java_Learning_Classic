package lesson54;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NestedIframeTest {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/nested_frames");

        // Switch to top -> middle frame
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");

        WebElement middleText = driver.findElement(By.id("content"));
        System.out.println("Middle Frame Text: " + middleText.getText());

        // Return to main page
        driver.switchTo().defaultContent();

        // Switch to bottom frame
        driver.switchTo().frame("frame-bottom");
        WebElement bottomText = driver.findElement(By.tagName("body"));
        System.out.println("Bottom Frame Text: " + bottomText.getText());

        // Cleanup
        Thread.sleep(2000);
        driver.quit();
    }
}
