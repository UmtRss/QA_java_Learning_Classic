package lesson33;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CheckboxTest {

    @Test
    public void handleCheckboxes() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        // Locate all checkboxes on the page
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));

        // Loop through each checkbox
        for (int i = 0; i < checkboxes.size(); i++) {
            WebElement checkbox = checkboxes.get(i);
            boolean isChecked = checkbox.isSelected();

            // If not selected, click to select it
            if (!isChecked) {
                checkbox.click();
                System.out.println("Checkbox " + (i + 1) + " was not selected. Now it is selected.");
            } else {
                System.out.println("Checkbox " + (i + 1) + " is already selected.");
            }
        }

        Thread.sleep(2000);
        driver.quit();
    }
}
