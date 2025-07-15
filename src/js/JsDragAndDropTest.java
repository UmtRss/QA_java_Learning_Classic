package js;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.nio.file.Files;
import java.nio.file.Paths;

public class JsDragAndDropTest {

    @Test
    public void performJsDragAndDrop() throws Exception {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");

        // ✅ Load the JS helper file from hardcoded local path
        String js = new String(Files.readAllBytes(
                Paths.get("src/lesson40/test/resources/js/drag_and_drop_helper.js")
        ));

        // ✅ Cast driver to JavascriptExecutor
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        // ✅ Inject the JS and perform drag and drop from column A to B
        jsExecutor.executeScript(js + "$('#column-a').simulateDragDrop({ dropTarget: '#column-b'});");

        // ✅ Wait a bit to observe the result
        Thread.sleep(2000);
        driver.quit();
    }
}
