package PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
   WebDriver driver;


    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    // Кнопка в header "Заказать"
    private By orderButtonHeader = By.cssSelector("button[class='Button_Button__ra12g']");

    //Кнопка в Home_RoadMap "Заказать"
    private By orderButtonHome = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM");




    //Нажимаем кнопку заказать в Header
    public void clickOrderButtonHeader() {
        driver.findElement(orderButtonHeader).click();
    }

    //Нажимаем кнопку заказать на странице
    public void clickOrderButtonHome() {

        driver.findElement(orderButtonHome).click();
    }





}
