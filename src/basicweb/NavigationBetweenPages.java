package basicweb;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class NavigationBetweenPages {
    WebDriver driver;
    String baseUrl;

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        baseUrl = "http://letskodeit.teachable.com/";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void test() throws InterruptedException {
        driver.get(baseUrl);
        String title = driver.getTitle();
        System.out.println("Current title of the page: " + title);

        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL: " + currentUrl);

        String newUrl = "https://sso.teachable.com/secure/42299/identity/login";
        driver.navigate().to(newUrl);

        currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL: " + currentUrl);

        Thread.sleep(2000);

        driver.navigate().back(); //return back to baseUrl
        System.out.println("Navigate back");
        currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL: " + currentUrl);

        Thread.sleep(2000);

        driver.navigate().forward(); //return forward to login page
        System.out.println("Navigate forward");
        currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL: " + currentUrl);

        driver.navigate().back(); //return back to baseUrl
        System.out.println("Navigate back");
        currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL: " + currentUrl);

        driver.navigate().refresh(); //refresh the page
        System.out.println("Refresh the page");

        String pageSource = driver.getPageSource();
        System.out.println(pageSource);


    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}
