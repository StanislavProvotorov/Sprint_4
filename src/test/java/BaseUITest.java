import PageObject.FormOrderPage;
import PageObject.MainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseUITest {
    FormOrderPage formOrderPage ;
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
    }
        public void startBrowserChrome(){
        driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
            formOrderPage = new FormOrderPage(driver);
            mainPage = new MainPage(driver);
            openPage();
            closeCookie();

        }

        public void startBrowserFirefox(){

            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            formOrderPage = new FormOrderPage(driver);
            mainPage = new MainPage(driver);
            openPage();
            closeCookie();
        }






    @After
    public void closeBrowser(){
        driver.quit();
    }

    //Открыть страницу
    public void openPage() {
        driver.get("https://qa-scooter.praktikum-services.ru");
    }

    //Принять куки
    public void closeCookie () {
        driver.findElement(By.id("rcc-confirm-button")).click();
    }
}
