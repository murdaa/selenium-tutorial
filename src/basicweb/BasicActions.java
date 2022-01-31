package basicweb;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BasicActions {
    WebDriver driver;
    String baseUrl;

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        baseUrl = "http://letskodeit.teachable.com/";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void test() {
        driver.get(baseUrl);
        driver.findElement(By.xpath("//a[@href = '/sign_in']")).click();
        System.out.println("Clicked on Login link");
        driver.findElement(By.xpath("//input[@name = 'email']")).sendKeys("mail@mail.com");
        driver.findElement(By.xpath("//input[@type = 'password']")).sendKeys("Test");
        System.out.println("Email and password are entered");
        driver.findElement(By.xpath("//input[@name = 'email']")).clear();
        driver.findElement(By.xpath("//input[@type = 'password']")).clear();
        System.out.println("Clearing the data");

    }

    @After
    public void tearDown() throws Exception {
        //driver.quit();
        System.out.println("Test is completed");
    }
}
