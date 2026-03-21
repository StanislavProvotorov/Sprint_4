import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import static org.hamcrest.CoreMatchers.startsWith;

@RunWith(Parameterized.class)

public class OrderTests extends BaseUITest {



    private final String name;
    private final String surname;
    private final String location;
    private final String metroStation;
    private final String phone;
    private final String date;
    private final String time;
    private final String color;
    private final String comment;
    String expectedOrder = "Заказ оформлен";


    public OrderTests(String name, String surname, String location, String metroStation, String phone, String date, String time, String color, String comment) {
        this.name = name;
        this.surname = surname;
        this.location = location;
        this.metroStation = metroStation;
        this.phone = phone;
        this.date = date;
        this.time = time;
        this.color = color;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] getTest() {
        return new Object[][]{
                {"Иван", "Иванов", "Дзержинского 85", "Черкизовская", "+79995554466", "25.03.2026", "сутки", "black", "Прихватите зарядку"},
                {"Петр", "Петров", "Крестьянская 35", "Спортивная", "+79267775522", "31.03.2026", "четверо суток", "grey", ""},
        };
    }

    @Test
    public void orderHeader() {
        mainPage.clickOrderButtonHeader();
        formOrderPage.inputName(name);
        formOrderPage.inputSurname(surname);
        formOrderPage.inputLocation(location);
        formOrderPage.inputMetroStation(metroStation);
        formOrderPage.inputPhone(phone);
        formOrderPage.clickButtonForch();
        formOrderPage.inputDateOrder(date);
        formOrderPage.rentalTime(time);
        formOrderPage.clickColorScooter(color);
        formOrderPage.inputComentCourier(comment);
        formOrderPage.clickButtonFormOrder();
        formOrderPage.clickButtonYesOrder();

        String actualOrder = driver.findElement(By.xpath("//div[@class='Order_ModalHeader__3FDaJ'][contains(text(), 'Заказ оформлен')]")).getText();

        //Сравнение ОР с ФР
        MatcherAssert.assertThat("Заказ не оформлен", actualOrder, startsWith(expectedOrder));

    }

    @Test
    public void orderHome(){
        mainPage.clickOrderButtonHome();
        formOrderPage.inputName(name);
        formOrderPage.inputSurname(surname);
        formOrderPage.inputLocation(location);
        formOrderPage.inputMetroStation(metroStation);
        formOrderPage.inputPhone(phone);
        formOrderPage.clickButtonForch();
        formOrderPage.inputDateOrder(date);
        formOrderPage.rentalTime(time);
        formOrderPage.clickColorScooter(color);
        formOrderPage.inputComentCourier(comment);
        formOrderPage.clickButtonFormOrder();
        formOrderPage.clickButtonYesOrder();

        String actual = driver.findElement(By.xpath("//div[@class='Order_ModalHeader__3FDaJ'][contains(text(), 'Заказ оформлен')]")).getText();

        //Сравнение ОР с ФР
        MatcherAssert.assertThat("Заказ не оформлен",actual, startsWith(expectedOrder));

    }

}
