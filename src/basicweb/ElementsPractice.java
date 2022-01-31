package basicweb;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;

import java.util.concurrent.TimeUnit;

public class ElementsPractice {
    WebDriver driver;
    String baseUrl;
    JavascriptExecutor jse;

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        baseUrl = "https://courses.letskodeit.com/practice";
        jse = (JavascriptExecutor)driver;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void enabledFieldtest() throws Exception {
        driver.get(baseUrl);
        jse.executeScript("window.scrollBy(0, 600)");
        Thread.sleep(2000);

        WebElement textField = driver.findElement(By.id("enabled-example-input"));
        System.out.println("Is Text field enabled? " + textField.isEnabled());

        Thread.sleep(3000);

        WebElement disButton = driver.findElement(By.id("disabled-button"));
        disButton.click();
        System.out.println("Disabled button is clicked");
        System.out.println("Is Text field enabled? " + textField.isEnabled());

        Thread.sleep(3000);

        WebElement enButton = driver.findElement(By.id("enabled-button"));
        enButton.click();
        System.out.println("Enabled button is clicked");
        System.out.println("Is Text field enabled? " + textField.isEnabled());

    }

    @Test
    public void HoverTest() throws Exception {
        driver.get(baseUrl);
        jse.executeScript("window.scrollBy(0, 600)");
        Thread.sleep(2000);

        WebElement mouseHover = driver.findElement(By.id("mousehover"));
        Actions action = new Actions(driver);
        action.moveToElement(mouseHover).build().perform();
        System.out.println("Курсор наведен на кнопку");

        Thread.sleep(2000);

        WebElement subElement = driver.findElement(By.xpath("//div[@class='mouse-hover-content']//a[text()='Top']"));
        action.moveToElement(subElement).click().perform();

        Thread.sleep(2000);

    }


    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        driver.quit();
    }
}
