import org.object.page.FormOrderPage;
import org.object.page.MainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseUITest {
    FormOrderPage formOrderPage;
    WebDriver driver;
    MainPage mainPage;

    @Before
    public void startBrowser() {
        String browser = System.getProperty("browser", "chrome");
        if (browser.equals("chrome")) {
            startBrowserChrome();
        } else if (browser.equals("firefox")) {
            startBrowserFirefox();
        }

        mainPage.openPage();
        mainPage.closeCookie();
    }

    public void startBrowserChrome() {
        driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        formOrderPage = new FormOrderPage(driver);
        mainPage = new MainPage(driver);
    }

    public void startBrowserFirefox() {

        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        formOrderPage = new FormOrderPage(driver);
        mainPage = new MainPage(driver);
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }
}