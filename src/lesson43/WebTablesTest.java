package lesson43;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebTablesTest {

    @Test
    public void testWebTableCell() {
        WebDriver driver = Driver.getDriver();
        driver.get("https://the-internet.herokuapp.com/tables");

        // table1, 2. satır, 3. sütun -> "Jason"
        WebElement cell = driver.findElement(By.xpath("//table[@id='table1']//tr[3]/td[2]"));
        String actual = cell.getText();
        String expected = "Jason";

        Assert.assertEquals(actual, expected);

        Driver.closeDriver();
    }
}
