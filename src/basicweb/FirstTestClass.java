package basicweb;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTestClass {
    public static void main(String[] args) {
        //System.setProperty("webdrive.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String baseURL = "https://facebook.com";
        driver.get(baseURL);
        //driver.close();
    }
}
