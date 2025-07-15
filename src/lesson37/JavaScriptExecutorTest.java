package lesson37;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutorTest {

    @Test
    public void useJavaScriptExecutor() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/large");

        // Cast WebDriver to JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Scroll down 1000 pixels
        js.executeScript("window.scrollBy(0, 1000)");

        Thread.sleep(1000);

        // Locate a link at the bottom (e.g., 'Elemental Selenium' link)
        WebElement bottomLink = driver.findElement(By.linkText("Elemental Selenium"));

        // Scroll to the element
        js.executeScript("arguments[0].scrollIntoView(true);", bottomLink);

        Thread.sleep(1000);

        // Click the element using JS
        js.executeScript("arguments[0].click();", bottomLink);

        Thread.sleep(2000);
        driver.quit();
    }
}
