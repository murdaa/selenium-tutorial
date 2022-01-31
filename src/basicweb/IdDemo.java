package basicweb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class IdDemo {
    public static void main(String[] args) {
    //System.setProperty("webdrive.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    String baseURL = "https://learn.letskodeit.com/";
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //required for each programme
    driver.get(baseURL); //open the web page
    //driver.close();

    driver.findElement(By.xpath("//a[@href='/sign_in']")).click(); //navigates to the Login page
    driver.findElement(By.id("email")).sendKeys("mail@mail.com"); //finds the element for email and enters
        //mail@mail.com
}
}
