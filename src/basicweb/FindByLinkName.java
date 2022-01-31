package basicweb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class FindByLinkName {

        public static void main(String[] args) throws Exception {
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            String baseURL = "https://www.spletnik.ru/";
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //required for each programme
            driver.get(baseURL); //open the web page

            driver.findElement(By.linkText("Вход")).click();
            Thread.sleep(3000); //pause an execution of programm

            driver.findElement(By.partialLinkText("зарегистрир")).click();
        }
}
