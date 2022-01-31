package switchwindow;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Set;

import java.util.concurrent.TimeUnit;

public class SwitchWindow {
    private WebDriver driver;
    private String baseUrl;

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        baseUrl = "https://courses.letskodeit.com/practice";

        // Maximize the browser's window
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    @Test
    public void test() throws InterruptedException {

        //get the parent page (handle)
        String parentHandle = driver.getWindowHandle();
        System.out.println("Parent handle is: " + parentHandle);
        WebElement openWindow = driver.findElement(By.xpath("//button[@id='openwindow']"));
        openWindow.click();

        //get all handles
        Set<String> allHandles = driver.getWindowHandles();

        //swtiching between handles
        for (String handle: allHandles) {
            System.out.println(handle);
            if (!handle.equals(parentHandle)) {
                driver.switchTo().window(handle);
                Thread.sleep(2000);
                WebElement searchField = driver.findElement(By.xpath("//form[@id='search']//input[@id='search']"));
                searchField.sendKeys("Python");
                driver.close();
                break;
            }
        }
        //get back to the parent handle
        driver.switchTo().window(parentHandle);
        driver.findElement(By.id("name")).sendKeys("Test Successful");
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        driver.quit();
    }
}
