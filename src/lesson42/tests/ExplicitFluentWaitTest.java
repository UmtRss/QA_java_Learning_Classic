package lesson42.tests;

import lesson42.utilities.Driver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.function.Function;

public class ExplicitFluentWaitTest {

    @Test
    public void waitExample() {
        WebDriver driver = Driver.getDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        driver.findElement(By.tagName("button")).click();

        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);

        WebElement finishElement = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                WebElement element = driver.findElement(By.id("finish"));
                if (element.isDisplayed()) {
                    return element;
                }
                return null;
            }
        });

        System.out.println("Text: " + finishElement.getText());
        driver.quit();
    }
}
