package practice;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class CalendarSelection {
    WebDriver driver;
    String baseUrl;

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        baseUrl = "https://www.booking.com/index.ru.html?label=gen173nr-1DCAEoggI46AdIM1gEaMIBiAEBmAEhuAEXyAEM2AED6AEBiAIBqAIDuAL-jL-PBsACAdICJGRkYzJhNGYyLTgyMzMtNDc1Zi1iY2JjLTk3NGY2YTY5YTA2ZtgCBOACAQ;sid=c140e9cde0997b0fde4207b3c3644653;keep_landing=1&sb_price_type=total&";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @Test
    public void test() throws Exception {
        WebElement Destination = driver.findElement(By.xpath("//input[@id='ss']"));
        Destination.sendKeys("Москва");

        WebElement DateField1 = driver.findElement(By.xpath("//form[@id='frm']/div[1]/div[@class='xp__dates xp__group']//div[@class='xp__dates-inner xp__dates__checkout']/div/div/div/span"));
        DateField1.click();

        WebElement DateSelection1 = driver.findElement(By.xpath("//form[@id='frm']//div[@class='xp__dates xp__group']/div[2]/div[@class='bui-calendar']//div[@class='bui-calendar__content']/div[2]/table[@class='bui-calendar__dates']/tbody/tr[1]/td[2]/span[@role='checkbox']/span[.='1']"));
        DateSelection1.click();

        WebElement DateSelection2 = driver.findElement(By.xpath("//form[@id='frm']/div[1]/div[@class='xp__dates xp__group']/div[2]/div[@class='bui-calendar']//div[@class='bui-calendar__content']/div[2]/table[@class='bui-calendar__dates']/tbody/tr[1]/td[4]"));
        DateSelection2.click();

        WebElement SubmitButton = driver.findElement(By.xpath("//form[@id='frm']//button[@type='submit']/span[1]"));
        SubmitButton.click();

    }

    @After
    public void tearDown() throws Exception {
    }
}
