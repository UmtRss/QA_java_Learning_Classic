package lesson46;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptAlertTest {
    public static void main(String[] args) throws InterruptedException {
        // 1. Setup WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // 2. Navigate to the JavaScript Alerts test page
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        // 3. Handle JS Alert - Accept
        WebElement alertButton = driver.findElement(By.xpath("//button[text()='Click for JS Alert']"));
        alertButton.click();

        Alert alert = driver.switchTo().alert();
        System.out.println("Alert text: " + alert.getText());
        alert.accept();

        WebElement result = driver.findElement(By.id("result"));
        String resultText = result.getText();

        if (resultText.equals("You successfully clicked an alert")) {
            System.out.println("TEST PASSED ✅");
        } else {
            System.out.println("TEST FAILED ❌");
        }

        // 4. Handle JS Confirm - Dismiss
        WebElement confirmButton = driver.findElement(By.xpath("//button[text()='Click for JS Confirm']"));
        confirmButton.click();

        alert = driver.switchTo().alert();
        System.out.println("Confirm alert text: " + alert.getText());
        alert.dismiss(); // Click "Cancel"

        resultText = driver.findElement(By.id("result")).getText();

        if (resultText.equals("You clicked: Cancel")) {
            System.out.println("TEST PASSED ✅ - Cancel was clicked");
        } else {
            System.out.println("TEST FAILED ❌ - Cancel not detected");
        }

        // 5. Handle JS Prompt - Send Keys + Accept
        WebElement promptButton = driver.findElement(By.xpath("//button[text()='Click for JS Prompt']"));
        promptButton.click();

        alert = driver.switchTo().alert();
        System.out.println("Prompt alert text: " + alert.getText());
        String inputText = "Umut Buğra";
        alert.sendKeys(inputText);
        alert.accept();

        resultText = driver.findElement(By.id("result")).getText();

        if (resultText.equals("You entered: " + inputText)) {
            System.out.println("TEST PASSED ✅ - Prompt input matched");
        } else {
            System.out.println("TEST FAILED ❌ - Prompt input mismatch");
        }

        // 6. Close the browser
        driver.quit();
    }
}
