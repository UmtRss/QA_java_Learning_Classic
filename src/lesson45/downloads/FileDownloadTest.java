package lesson45.downloads;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

public class FileDownloadTest {
    public static void main(String[] args) throws InterruptedException {
        // 1. Define the download folder path
        String downloadPath = System.getProperty("user.dir") + "\\src\\lesson45\\downloads";

        // 2. Set up ChromeOptions with custom download directory
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--remote-allow-origins=*");

        // 3. Configure preferences for automatic download
        options.setExperimentalOption("prefs", new java.util.HashMap<String, Object>() {{
            put("download.default_directory", downloadPath);
            put("download.prompt_for_download", false);
            put("safebrowsing.enabled", true);
        }});

        WebDriver driver = new ChromeDriver(options);

        // 4. Navigate to the test download page
        driver.get("https://the-internet.herokuapp.com/download");

        // 5. Click on the first available file link
        WebElement fileLink = driver.findElement(By.xpath("//div[@class='example']//a[1]"));
        String fileName = fileLink.getText(); // Get the filename
        fileLink.click(); // Start download

        // 6. Wait for the file to be downloaded (max 10 seconds)
        File downloadedFile = new File(downloadPath + "\\" + fileName);
        int waitSeconds = 0;

        while (!downloadedFile.exists() && waitSeconds < 10) {
            Thread.sleep(1000); // Wait 1 second
            waitSeconds++;
        }

        // 7. Check if the file was successfully downloaded
        if (downloadedFile.exists()) {
            System.out.println("TEST PASSED ✅ File downloaded: " + fileName);
        } else {
            System.out.println("TEST FAILED ❌ File not found.");
        }

        driver.quit();
    }
}
