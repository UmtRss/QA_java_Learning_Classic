package lesson27;

import org.openqa.selenium.*;
import org.openqa.selenium.Alert;

public class AlertTest {

    public static void main(String[] args) {

        BaseTest base = new BaseTest();
        base.setup();
        WebDriver driver = base.driver;

        try {
            // 1. JS Alert (OK)
            System.out.println("🔹 JS Alert Test");
            WebElement jsAlertBtn = driver.findElement(By.xpath("//button[text()='Click for JS Alert']"));
            jsAlertBtn.click();

            Alert alert1 = driver.switchTo().alert();
            System.out.println("Alert text: " + alert1.getText());
            alert1.accept();

            WebElement result1 = driver.findElement(By.id("result"));
            System.out.println("Result: " + result1.getText());

            // 2. JS Confirm (OK & Cancel)
            System.out.println("\n🔹 JS Confirm Test");
            WebElement jsConfirmBtn = driver.findElement(By.xpath("//button[text()='Click for JS Confirm']"));
            jsConfirmBtn.click();

            Alert alert2 = driver.switchTo().alert();
            System.out.println("Alert text: " + alert2.getText());
            alert2.dismiss(); // simulate Cancel

            WebElement result2 = driver.findElement(By.id("result"));
            System.out.println("Result after cancel: " + result2.getText());

            // 3. JS Prompt (Input + OK)
            System.out.println("\n🔹 JS Prompt Test");
            WebElement jsPromptBtn = driver.findElement(By.xpath("//button[text()='Click for JS Prompt']"));
            jsPromptBtn.click();

            Alert alert3 = driver.switchTo().alert();
            System.out.println("Alert text: " + alert3.getText());
            alert3.sendKeys("Form Test 1"); //
            alert3.accept();

            WebElement result3 = driver.findElement(By.id("result"));
            System.out.println("Prompt result: " + result3.getText());

        } catch (Exception e) {
            System.out.println("❌ Test failed: " + e.getMessage());
        } finally {
            base.teardown();
        }
    }
}
