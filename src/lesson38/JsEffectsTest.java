package lesson38;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JsEffectsTest {

    @Test
    public void runJsEffects() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/large");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Scroll down to bottom
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        Thread.sleep(1000);

        // Scroll up to top
        js.executeScript("window.scrollTo(0, 0);");
        Thread.sleep(1000);

        // Locate the 'Elemental Selenium' link at the bottom
        WebElement link = driver.findElement(By.linkText("Elemental Selenium"));

        // Scroll into view
        js.executeScript("arguments[0].scrollIntoView(true);", link);
        Thread.sleep(1000);

        // Highlight the element (add a red border)
        js.executeScript("arguments[0].style.border='3px solid red'", link);
        Thread.sleep(1000);

        // Flash effect (change background color rapidly)
        for (int i = 0; i < 5; i++) {
            js.executeScript("arguments[0].style.backgroundColor='yellow'", link);
            Thread.sleep(200);
            js.executeScript("arguments[0].style.backgroundColor='white'", link);
            Thread.sleep(200);
        }

        Thread.sleep(1000);
        driver.quit();
    }
}
