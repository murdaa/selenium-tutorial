package basicweb;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;
import java.util.List;

public class WorkingWithListOfElements {
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
        boolean isChecked = false;
        List<WebElement> radioButtons = driver.findElements(By.xpath("//input[contains(@type, 'radio') and contains(@name, 'cars')]"));
        int size = radioButtons.size();
        System.out.println("Size of the list: " + size);

        for (int i = 0; i < size; i ++) {
            isChecked = radioButtons.get(i).isSelected();

            if (!isChecked) {
                radioButtons.get(i).click();
                Thread.sleep(3000);
            }

        }

    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        driver.quit();
    }
}
