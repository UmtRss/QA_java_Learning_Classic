package lesson50;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownTest {
    public static void main(String[] args) throws InterruptedException {
        // 1. Setup WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // 2. Navigate to dropdown test page
        driver.get("https://the-internet.herokuapp.com/dropdown");

        // 3. Locate the dropdown element
        WebElement dropdownElement = driver.findElement(By.id("dropdown"));

        // 4. Create Select object
        Select dropdown = new Select(dropdownElement);

        // 5. Select Option 2 by visible text
        dropdown.selectByVisibleText("Option 2");

        // 6. Get the selected option
        String selectedOption = dropdown.getFirstSelectedOption().getText();

        // 7. Verify the selection
        if (selectedOption.equals("Option 2")) {
            System.out.println("TEST PASSED ✅ - Option 2 was selected");
        } else {
            System.out.println("TEST FAILED ❌ - Wrong option selected");
        }

        driver.quit();
    }
}
