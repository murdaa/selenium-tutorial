package generic;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;
import java.util.List;

public class ListElementsDemo {
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

        boolean elementPresence = gm.isElementPresent("name", "id");
        System.out.println("Are elements present? " + elementPresence);

        List<WebElement> listElement = gm.getElementList("//input[@id='name']", "xpath");
        int size = listElement.size();
        System.out.println("Found number of elements: " + size);

    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}
