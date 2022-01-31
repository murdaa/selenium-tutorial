package javascriptexecution;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ScrollDown {
    private WebDriver driver;
    private JavascriptExecutor js;
    private String baseUrl;

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        baseUrl = "https://courses.letskodeit.com/practice";
        js = (JavascriptExecutor) driver;

        // Maximize the browser's window
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void test() throws Exception {
        js.executeScript("window.location = 'https://courses.letskodeit.com/practice';");

        // Scroll Down
        js.executeScript("window.scrollBy(0, 1900);");
        Thread.sleep(2000);

        // Scroll Up
        js.executeScript("window.scrollBy(0, -1900);");
        Thread.sleep(2000);

        // Scroll Element Into View
        WebElement element = driver.findElement(By.id("mousehover"));
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(2000);
        js.executeScript("window.scrollBy(0, -190);");
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        driver.quit();
    }
}
