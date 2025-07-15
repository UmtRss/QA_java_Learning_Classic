package lesson52;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationTest {
    public static void main(String[] args) throws InterruptedException {

        // 1. Launch browser
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // 2. Open Google
        driver.get("https://www.google.com");
        System.out.println("Navigated to Google");
        Thread.sleep(1500);

        // 3. Navigate to GitHub
        driver.navigate().to("https://www.github.com");
        System.out.println("Navigated to GitHub");
        Thread.sleep(1500);

        // 4. Navigate back to Google
        driver.navigate().back();
        System.out.println("Navigated back to Google");
        Thread.sleep(1500);

        // 5. Navigate forward to GitHub
        driver.navigate().forward();
        System.out.println("Navigated forward to GitHub");
        Thread.sleep(1500);

        // 6. Refresh the page
        driver.navigate().refresh();
        System.out.println("Refreshed GitHub");
        Thread.sleep(1500);

        // 7. Close the browser
        driver.quit();
    }
}
