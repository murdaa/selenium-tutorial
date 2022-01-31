package switchwindow;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Alert;
import java.util.concurrent.TimeUnit;

public class Switchalert {
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
    public void test1() throws InterruptedException {
        driver.findElement(By.id("name")).sendKeys("Test");
        driver.findElement(By.id("alertbtn")).click();
        Thread.sleep(2000);
        //switch to alert pop up
        Alert alert = driver.switchTo().alert();
        //confirm the action in alert pop up
        alert.accept();
    }

    @Test
    public void test2() throws InterruptedException {
        driver.findElement(By.id("name")).sendKeys("Test");
        driver.findElement(By.id("confirmbtn")).click();
        Thread.sleep(2000);
        //switch to alert pop up
        Alert alert = driver.switchTo().alert();
        //cancel the action in alert pop up
        alert.dismiss();
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        driver.quit();
    }
}
