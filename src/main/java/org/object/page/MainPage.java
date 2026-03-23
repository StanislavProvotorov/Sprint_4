package org.object.page;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class MainPage {
   WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    //Веб адрес ресурса "Яндекс самокат"
    private String Url = "https://qa-scooter.praktikum-services.ru";

    //Кнопка принятия Cookie
    private By buttonCoocie = By.id("rcc-confirm-button");

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

    //Открыть страницу
    public void openPage() {
        driver.get(Url);
    }

    //Принять куки
    public void closeCookie () {
        driver.findElement(buttonCoocie).click();
    }





    //Скролл до нужного вопроса
    public void scrollQuestion(String question) {
        WebElement element = driver.findElement(By.xpath(".//div[text() = '" + question + "']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    //Клик по вопросу
    public void clickQuestion(String question){
        driver.findElement(By.xpath(".//div[text() = '" + question + "']")).click();
    }

        //Проверяем что текст ответа отображается на странице
    public boolean isAnswelText(String answel) {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//p[text() = '" + answel + "']"))));
        return driver.findElement(By.xpath(".//p[text() = '" + answel + "']")).isDisplayed();
    }

}
