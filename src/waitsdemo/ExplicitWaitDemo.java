package waitsdemo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class ExplicitWaitDemo {
    private String baseUrl;
    private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        baseUrl = "https://courses.letskodeit.com/";

        driver.manage().window().maximize();
    }

    @Test
    public void test() throws Exception {
        driver.get(baseUrl);
        WebElement loginLink = driver.findElement(By.cssSelector("div > .dynamic-link"));
        loginLink.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        emailField.sendKeys("Test");
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        driver.quit();
    }
}
