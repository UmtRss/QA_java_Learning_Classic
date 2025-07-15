package lesson25;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {

    public WebDriver driver;

    public void setup() {
        // Set the path to your ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        // Launch Chrome browser
        driver = new ChromeDriver();

        // Maximize window
        driver.manage().window().maximize();

        // Set implicit wait time for element searches
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Navigate to the test login page
        driver.get("https://practicetestautomation.com/practice-test-login/");
    }

    public void teardown() {
        // Close the browser if driver is not null
        if (driver != null) {
            driver.quit();
        }
    }
}
