package lesson28;

import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertTest {

    @Test
    public void handleAlerts() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        // === 1. Alert Box (Only OK button) ===
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
        Thread.sleep(1000);

        Alert alert1 = driver.switchTo().alert(); // Switch to the alert
        System.out.println("Alert Text: " + alert1.getText()); // Print alert message
        alert1.accept(); // Click OK button

        // === 2. Confirm Box (OK and Cancel buttons) ===
        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        Thread.sleep(1000);

        Alert alert2 = driver.switchTo().alert(); // Switch to confirm box
        System.out.println("Confirm Text: " + alert2.getText()); // Print confirm message
        alert2.dismiss(); // Click Cancel button (you can change to .accept())

        // === 3. Prompt Box (Input + OK button) ===
        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        Thread.sleep(1000);

        Alert alert3 = driver.switchTo().alert(); // Switch to prompt box
        System.out.println("Prompt Text: " + alert3.getText()); // Print prompt message
        alert3.sendKeys("Hello QA Team!"); // Enter text in prompt input
        alert3.accept(); // Click OK button

        Thread.sleep(2000);
        driver.quit(); // Close the browser
    }
}
