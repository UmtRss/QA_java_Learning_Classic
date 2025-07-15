package lesson32;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadTest {

    @Test
    public void handleFileUpload() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/upload");

        // Locate the file input and send the file path
        driver.findElement(By.id("file-upload"))
                .sendKeys("C:\\Users\\Lenovo\\Desktop\\example.txt"); // ⚠️ Replace with your actual file path

        // Click on the upload button
        driver.findElement(By.id("file-submit")).click();

        // Wait for the upload to complete
        Thread.sleep(2000);

        // Get and print the result text (should be "File Uploaded!")
        String resultText = driver.findElement(By.tagName("h3")).getText();
        System.out.println("Result: " + resultText);

        driver.quit();
    }
}
