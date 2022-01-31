package practice;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropdownPractice {
    WebDriver driver;
    String baseUrl;


    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        baseUrl = "https://demo.guru99.com/test/newtours/register.php";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @Test
    public void test() throws Exception {
        Select dropdownCountry = new Select(driver.findElement(By.name("country")));
        dropdownCountry.selectByVisibleText("BERMUDA");
        System.out.println("Country is selected in the dropdown");

        Thread.sleep(2000);

        System.out.println("Now all countries are selected");
        List<WebElement> options = dropdownCountry.getOptions();
        int size = options.size();

        for (int i = 0; i < size; i ++) {
            String optionName = options.get(i).getText();
            System.out.println(optionName);
        }

    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        driver.quit();
    }
}
