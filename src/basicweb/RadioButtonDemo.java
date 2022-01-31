package basicweb;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class RadioButtonDemo {
    WebDriver driver;
    String baseUrl;


    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        baseUrl = "https://courses.letskodeit.com/practice";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @Test
    public void test() throws InterruptedException {
        WebElement bmwRadioBtn = driver.findElement(By.id("bmwradio"));
        bmwRadioBtn.click();
        System.out.println("BMW radio button is selected? " + bmwRadioBtn.isSelected());

        WebElement benzCheckbox = driver.findElement(By.id("benzcheck"));
        benzCheckbox.click();
        System.out.println("Benz checkbox is checked? " + benzCheckbox.isSelected());

    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        driver.quit();
    }
}
