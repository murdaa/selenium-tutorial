package waitsdemo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;
import java.time.Duration;

public class ImplicitWaitDemo {
    private String baseUrl;
    private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        baseUrl = "https://courses.letskodeit.com/";

        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    @Test
    public void test() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.cssSelector("div > .dynamic-link")).click();

        driver.findElement(By.id("email")).sendKeys("Test");
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        driver.quit();
    }
}
