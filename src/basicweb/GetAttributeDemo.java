package basicweb;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class GetAttributeDemo {
    WebDriver driver;
    String baseUrl;

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        baseUrl = "https://courses.letskodeit.com/practice";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }


    @Test
    public void test() throws Exception {
        driver.get(baseUrl);

        WebElement element = driver.findElement(By.id("name"));
        String attributeValue = element.getAttribute("class");


        System.out.println("Value of the attribute is: " + attributeValue);
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}
