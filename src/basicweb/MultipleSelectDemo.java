package basicweb;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;
import java.util.*;

public class MultipleSelectDemo {
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
    public void test() throws Exception {
        WebElement element = driver.findElement(By.id("multiple-select-example"));
        Select sel = new Select(element);

        Thread.sleep(2000);
        System.out.println("Select orange by value");
        sel.selectByValue("orange");

        Thread.sleep(2000);
        System.out.println("De-select orange by value");
        sel.deselectByValue("orange");

        Thread.sleep(2000);
        System.out.println("Select peach by index");
        sel.selectByIndex(2);

        Thread.sleep(2000);
        System.out.println("Select Apple by visible text");
        sel.selectByVisibleText("Apple");

        Thread.sleep(2000);
        System.out.println("Print the list of all options");
        List<WebElement> selectedOptions = sel.getAllSelectedOptions();
        for (WebElement option : selectedOptions) {
            System.out.println(option.getText());
        }

        Thread.sleep(2000);
        System.out.println("De-select all chosen options");
        sel.deselectAll();

    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        driver.quit();
    }
}
