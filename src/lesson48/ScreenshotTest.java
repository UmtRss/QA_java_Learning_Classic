package lesson48;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotTest {
    public static void main(String[] args) {
        // 1. Setup WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // 2. Go to the test page
        driver.get("https://the-internet.herokuapp.com");

        // 3. Cast driver to TakesScreenshot
        TakesScreenshot ts = (TakesScreenshot) driver;

        // 4. Take full page screenshot
        File screenshot = ts.getScreenshotAs(OutputType.FILE);

        // 5. Define target file path with timestamp
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        File targetFile = new File(System.getProperty("user.dir") + "\\src\\lesson48\\screenshots\\fullpage_" + timestamp + ".png");

        try {
            // 6. Save the screenshot file
            FileUtils.copyFile(screenshot, targetFile);
            System.out.println("TEST PASSED ✅ - Screenshot saved: " + targetFile.getName());
        } catch (IOException e) {
            System.out.println("TEST FAILED ❌ - Could not save screenshot");
            e.printStackTrace();
        }

        driver.quit();
    }
}
