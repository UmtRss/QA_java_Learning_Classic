package lesson27;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {

    public WebDriver driver;

    public void setup() {
        // Set ChromeDriver path
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        // Launch Chrome
        driver = new ChromeDriver();

        // Maximize window
        driver.manage().window().maximize();

        // Implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Navigate to alerts test page
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }

    public void teardown() {
        // Close browser
        if (driver != null) {
            driver.quit();
        }
    }
}
