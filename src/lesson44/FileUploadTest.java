package lesson44;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadTest {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/upload");

        WebElement uploadInput = driver.findElement(By.id("file-upload"));
        uploadInput.sendKeys("C:\\Users\\Lenovo\\Desktop\\Java-Projects\\QA_Java_Learning_Classic\\src\\lesson44\\sample_upload.txt");

        WebElement uploadButton = driver.findElement(By.id("file-submit"));
        uploadButton.click();

        WebElement uploadedMessage = driver.findElement(By.tagName("h3"));
        String actualMessage = uploadedMessage.getText();

        if (actualMessage.equals("File Uploaded!")) {
            System.out.println("TEST PASSED ✅");
        } else {
            System.out.println("TEST FAILED ❌");
        }

        driver.quit();
    }
}
