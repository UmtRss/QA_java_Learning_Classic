package lesson39;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropTest {

    @Test
    public void performDragAndDrop() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");

        // Locate the columns to drag and drop
        WebElement columnA = driver.findElement(By.id("column-a"));
        WebElement columnB = driver.findElement(By.id("column-b"));

        // Create Actions object
        Actions actions = new Actions(driver);

        // Perform drag and drop from A to B
        actions.dragAndDrop(columnA, columnB).perform();

        Thread.sleep(2000);
        driver.quit();
    }
}
