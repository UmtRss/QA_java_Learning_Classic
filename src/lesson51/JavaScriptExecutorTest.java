package lesson51;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutorTest {
    public static void main(String[] args) throws InterruptedException {
        // 1. Setup
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/large");

        // 2. Scroll down using JavaScript to make sure target is rendered
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        // 3. Wait for scroll to complete (sleep is enough here)
        Thread.sleep(1500);

        // 4. Access visible element near bottom by XPath
        WebElement targetElement = driver.findElement(By.xpath("(//div[@class='row'])[last()]"));

        // 5. Scroll into view and click
        js.executeScript("arguments[0].scrollIntoView(true);", targetElement);
        js.executeScript("arguments[0].click();", targetElement);

        // 6. Log result
        System.out.println("✅ TEST PASSED: Clicked the last element on page.");

        driver.quit();
    }
}
