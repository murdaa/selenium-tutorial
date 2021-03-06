package generic;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import generic.GenericMethods;

public class GenericMethodsDemo {

    private WebDriver driver;
    private String baseUrl;
    private GenericMethods gm;

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        baseUrl = "https://courses.letskodeit.com/practice";
        gm = new GenericMethods(driver);

        // Maximize the browser's window
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testMethod() throws Exception {
        driver.get(baseUrl);

        WebElement element = gm.getElement("name", "id");
        element.sendKeys("test");

        WebElement element1 = gm.getElement("//input[@id='bmwcheck']", "xpath");
        element1.click();

        WebElement element2 = gm.getElement("select#carselect", "css");
        element2.click();
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        //driver.quit();
    }
}

