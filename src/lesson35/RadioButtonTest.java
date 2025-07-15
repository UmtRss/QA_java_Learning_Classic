package lesson35;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class RadioButtonTest {

    @Test
    public void handleRadioButtons() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.guru99.com/test/radio.html");

        // Find all radio buttons
        List<WebElement> radioButtons = driver.findElements(By.name("webform"));

        // Loop through each radio button
        for (int i = 0; i < radioButtons.size(); i++) {
            WebElement radio = radioButtons.get(i);
            boolean isSelected = radio.isSelected();

            // If not selected, click it
            if (!isSelected) {
                radio.click();
                System.out.println("Radio Button " + (i + 1) + " clicked.");
            } else {
                System.out.println("Radio Button " + (i + 1) + " is already selected.");
            }

            Thread.sleep(1000);
        }

        driver.quit();
    }
}
