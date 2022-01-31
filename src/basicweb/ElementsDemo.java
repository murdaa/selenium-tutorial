package basicweb;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ElementsDemo {
    WebDriver driver;
    String baseUrl;

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        baseUrl = "https://google.com";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @Test
    public void test() throws Exception {
        WebElement el1 = driver.findElement(By.name("q"));
        System.out.println("Is el1 Enabled? " + el1.isEnabled());

        //WebElement el2 = driver.findElement(By.xpath("form[@role='search']/div[1]/div[1]//div[@class='a4bIc']/input[@role='combobox']"));
        //System.out.println("Is el2 Enabled? " + el2.isEnabled());

        //WebElement el3 = driver.findElement(By.xpath("form[@role='search']/div[1]/div[1]//div[@class='a4bIc']/input[@role='combobox']"));
        //System.out.println("Is el3 Enabled? " + el3.isEnabled());

        el1.sendKeys("letkodeit");

    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        driver.quit();
    }
}
