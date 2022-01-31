package basicweb;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class HiddenElementDemo {
    WebDriver driver;
    String baseUrl1;
    String baseUrl2;

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        baseUrl1 = "https://courses.letskodeit.com/practice";
        baseUrl2 = "http://www.expedia.com";
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void testLetsKodeIt() throws InterruptedException {
        driver.get(baseUrl1);

        WebElement TextBox = driver.findElement(By.id("displayed-text"));
        System.out.println("Is text box displayed? " + TextBox.isDisplayed());

        Thread.sleep(2000);

        WebElement HideButton = driver.findElement(By.id("hide-textbox"));
        HideButton.click();
        System.out.println("Hide Button is clicked");
        System.out.println("Is text box displayed? " + TextBox.isDisplayed());

        Thread.sleep(3000);

        WebElement ShowButton = driver.findElement(By.id("show-textbox"));
        ShowButton.click();
        System.out.println("Show Button is clicked");
        System.out.println("Is text box displayed? " + TextBox.isDisplayed());

    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        driver.quit();
    }
}
