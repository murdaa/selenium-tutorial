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
import waitsdemo.WaitGenericMethod;


public class ExplicitWaitWithMethod {
    private String baseUrl;
    private WebDriver driver;
    WaitGenericMethod wgm;

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        baseUrl = "https://courses.letskodeit.com/";

        driver.manage().window().maximize();
        wgm = new WaitGenericMethod(driver);
    }

    @Test
    public void test() throws Exception {
        driver.get(baseUrl);
        WebElement loginLink = driver.findElement(By.cssSelector("div > .dynamic-link"));
        loginLink.click();

        WebElement emailField = wgm.waitForElement(By.id("email"), 3);
        emailField.sendKeys("Test");

        wgm.clickWhenReady(By.xpath("//div[@id='page']/div[2]/div/div[@class='row']//div[@class='text-center zen-login']/form[@role='form']//input[@value='Login']"), 3);
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        driver.quit();
    }
}
