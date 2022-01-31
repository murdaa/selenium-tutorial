package javascriptexecution;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class WindowSize {
    private WebDriver driver;
    String baseUrl;
    private JavascriptExecutor js;

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

        // Size of window
        long height = (Long) js.executeScript("return window.innerHeight;");
        long width = (Long) js.executeScript("return window.innerWidth;");

        System.out.println("Height is: " + height);
        System.out.println("Width is: " + width);

    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}
