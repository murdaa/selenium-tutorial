package basicweb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class FindByClassName {
    public static void main(String[] args) throws Exception {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String baseURL = "https://courses.letskodeit.com/practice";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //required for each programme
        driver.get(baseURL); //open the web page

        driver.findElement(By.id("bmwradio")).click();
        Thread.sleep(3000);
        //driver.findElement(By.id("opentab")).click();
        //Thread.sleep(3000);
        driver.findElement(By.className("inputs")).sendKeys("Test Value");
        Thread.sleep(3000);
        //driver.findElement(By.id("confirmbtn")).click();

        //driver.findElement(By.cssSelector("input[class='inputs'][placeholder='Enter Your Name']")).sendKeys("Test Value");
        //driver.findElement(By.id("confirmbtn")).click();
        driver.close();

    }
}
