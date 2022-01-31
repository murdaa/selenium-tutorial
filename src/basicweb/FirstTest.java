package basicweb;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirstTest {

    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        WebDriver driver1 = new ChromeDriver();
    }
}
