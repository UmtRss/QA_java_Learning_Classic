package lesson60;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SliderTest {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://jqueryui.com/slider/");

        // Switch to iframe that contains the slider
        driver.switchTo().frame(0);

        // Locate the slider handle
        WebElement sliderHandle = driver.findElement(By.xpath("//div[@id='slider']/span"));

        // Move the slider to the right
        Actions actions = new Actions(driver);
        actions.clickAndHold(sliderHandle)
                .moveByOffset(100, 0)
                .release()
                .perform();

        driver.quit();
    }
}
