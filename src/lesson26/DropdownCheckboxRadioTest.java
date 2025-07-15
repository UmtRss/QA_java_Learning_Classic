package lesson26;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

public class DropdownCheckboxRadioTest {

    public static void main(String[] args) {

        BaseTest base = new BaseTest();
        base.setup();

        WebDriver driver = base.driver;

        try {
            System.out.println("✅ Starting dropdown test...");

            // 1. Dropdown seçimi (Select objesi ile)
            WebElement dropdown = driver.findElement(By.name("dropdown"));
            Select select = new Select(dropdown);
            select.selectByVisibleText("Drop Down Item 5");

            WebElement selectedOption = select.getFirstSelectedOption();
            System.out.println("🟢 Selected dropdown option: " + selectedOption.getText());

            // 2. Checkbox seçimi
            System.out.println("\n✅ Starting checkbox test...");
            WebElement checkbox1 = driver.findElement(By.xpath("//input[@type='checkbox' and @value='cb1']"));

            if (!checkbox1.isSelected()) {
                checkbox1.click();
                System.out.println("🟢 Checkbox 1 selected.");
            } else {
                System.out.println("🟡 Checkbox 1 was already selected.");
            }

            // 3. Radio button seçimi
            System.out.println("\n✅ Starting radio button test...");
            WebElement radio2 = driver.findElement(By.xpath("//input[@type='radio' and @value='rd2']"));

            if (!radio2.isSelected()) {
                radio2.click();
                System.out.println("🟢 Radio button 2 selected.");
            } else {
                System.out.println("🟡 Radio button 2 was already selected.");
            }

        } catch (Exception e) {
            System.out.println("❌ Test failed: " + e.getMessage());
        } finally {
            base.teardown();
        }
    }
}
