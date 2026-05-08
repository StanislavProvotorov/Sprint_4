package org.object.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FormOrderPage {
    WebDriver driver;

    public FormOrderPage(WebDriver driver) {
        this.driver = driver;
    }

    //Поле ввода "Имя"
    private By nameLocator = By.cssSelector("input[placeholder='* Имя']");

    //Поле ввода "Фамилия"
    private By surnameLocator = By.cssSelector("input[placeholder='* Фамилия']");

    //Поле ввода "Адрес"
    private By locationLocator = By.cssSelector("input[placeholder='* Адрес: куда привезти заказ']");

    //Поле ввода "Станция метро"
    private By metroStationLocator = By.cssSelector("input[placeholder='* Станция метро']");

    //Поле ввода "Телефон"
    private By phoneLocator = By.cssSelector("input[placeholder='* Телефон: на него позвонит курьер']");

    //Кнопка "Далее"
    private By buttonForchLocator = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM");

    //Поле ввода даты "Когда привезти самокат"
    private By dateOrderLocator = By.cssSelector("input[placeholder='* Когда привезти самокат']");

    //Открыть выпадающий список "Срок аренды"
    private By openRentalListLocator = By.cssSelector(".Dropdown-arrow");

    //Выбор элемента списка "Сутки"
    private By orderOneDeyLocator = By.xpath("//div[@role='option'][contains(text(),'сутки')]");

    //Выбор элемента списка "Двое суток"
    private By orderTwoDeyLocator = By.xpath("//div[@role='option'][contains(text(),'двое суток')]");

    //Выбор элемента списка "Трое суток"
    private By orderThreeDeyLocator = By.xpath("//div[@role='option'][contains(text(),'трое суток')]");

    //Выбор элемента списка "Четверо суток"
    private By orderFourDeyLocator = By.xpath("//div[@role='option'][contains(text(),'четверо суток')]");

    //Выбор элемента списка "Пятеро суток"
    private By orderFiveDeyLocator = By.xpath("//div[@role='option'][contains(text(),'пятеро суток')]");

    //Выбор элемента списка "Шестеро суток"
    private By orderSixDeyLocator = By.xpath("//div[@role='option'][contains(text(),'шестеро суток')]");

    //Выбор элемента списка "Семеро суток"
    private By orderSevenDeyLocator = By.xpath("//div[@role='option'][contains(text(),'семеро суток')]");

    //Выбор цвета самоката
    //"Черный жемчуг"
    private By blackColorScooterLocator = By.xpath("//input[@id='black']");

    //"Серая безысходность
    private By greyColorScooterLocator = By.xpath("//input[@id='grey']");

    //Поле ввода "Коментарий для курьера"
    private By commentCourierLocator = By.cssSelector("input[placeholder='Комментарий для курьера']");

    //Кнопка в форме "Заказать"
    private By buttonFormOrderLocator = By.cssSelector("button[class='Button_Button__ra12g Button_Middle__1CSJM']");

    //Кнопка подтверждения заказа "Да"
    private By buttonYesOrderLocator = By.cssSelector("div[class='Order_Modal__YZ-d3'] button[class='Button_Button__ra12g Button_Middle__1CSJM']");

    //Вводим имя
    public void inputName(String name) {
        driver.findElement(nameLocator).sendKeys(name);
    }

    //Вводим фамилию
    public void inputSurname(String surname) {
        driver.findElement(surnameLocator).sendKeys(surname);
    }

    //Вводим адрес
    public void inputLocation(String location) {
        driver.findElement(locationLocator).sendKeys(location);
    }

    //Вводим станцию метро
    public void inputMetroStation(String metroStation) {
        driver.findElement(metroStationLocator).sendKeys(metroStation);
        driver.findElement(By.xpath(".//div[text()='" + metroStation + "']")).click();
    }

    //Вводим телефон
    public void inputPhone(String phone) {
        driver.findElement(phoneLocator).sendKeys(phone);
    }

    //Нажимаем кнопку "Далее"
    public void clickButtonForch() {
        driver.findElement(buttonForchLocator).click();
    }

    //Вводим дату получения самоката
    public void inputDateOrder(String date) {
        driver.findElement(dateOrderLocator).sendKeys(date);
    }

    //Время аренды в днях
    public void rentalTime(String time) {
        driver.findElement(openRentalListLocator).click();
        if (time == "сутки") {
            driver.findElement(orderOneDeyLocator).click();
        } else if (time == "двое суток") {
            driver.findElement(orderTwoDeyLocator).click();
        } else if (time == "трое суток") {
            driver.findElement(orderThreeDeyLocator).click();
        } else if (time == "четверо суток") {
            driver.findElement(orderFourDeyLocator).click();
        } else if (time == "пятеро суток") {
            driver.findElement(orderFiveDeyLocator).click();
        } else if (time == "шестеро суток") {
            driver.findElement(orderSixDeyLocator).click();
        } else if (time == "семеро суток") {
            driver.findElement(orderSevenDeyLocator).click();
        }
    }

    //Выбор цвета самоката
    public void clickColorScooter(String color) {
        if (color == "Черный жемчуг") {
            driver.findElement(blackColorScooterLocator).click();
        } else if (color == "Серая безысходность") {
            driver.findElement(greyColorScooterLocator).click();
        }
    }

    //Ввод коvментария для курьера
    public void inputComentCourier(String coment) {
        driver.findElement(commentCourierLocator).sendKeys(coment);
    }

    //Нажимаем кнопку заказать в форме заказа
    public void clickButtonFormOrder() {
        driver.findElement(buttonFormOrderLocator).click();
    }

    //Нажимаем кнопку "Да" подтвердить заказ
    public void clickButtonYesOrder() {
        driver.findElement(buttonYesOrderLocator).click();
    }

    //Проверяем что отображается страница с подтверждением заказа
    public boolean isOrderPlaced(String expectedOrder) {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='Order_ModalHeader__3FDaJ'][contains(text(), '" + expectedOrder + "')]"))));
        return driver.findElement(By.xpath("//div[@class='Order_ModalHeader__3FDaJ'][contains(text(), '" + expectedOrder + "')]")).isDisplayed();
    }

    //Заполняем "для кого самокат"
    public void whoseScooter(String name, String surname, String location, String metroStation, String phone) {
        inputName(name);
        inputSurname(surname);
        inputLocation(location);
        inputMetroStation(metroStation);
        inputPhone(phone);
        clickButtonForch();
    }

    //Заполняем "про аренду"
    public void aboutRent(String date, String time, String color, String comment) {
        inputDateOrder(date);
        rentalTime(time);
        clickColorScooter(color);
        inputComentCourier(comment);
        clickButtonFormOrder();
    }
}