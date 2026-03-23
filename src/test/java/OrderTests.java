import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertTrue;

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


    public OrderTests (String name, String surname, String location, String metroStation, String phone, String date, String time, String color, String comment) {
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
        return new Object[][] {
                {"Иван", "Иванов", "Дзержинского 85", "Черкизовская", "+79995554466", "25.03.2026", "сутки", "black", "Прихватите зарядку"},
                {"Петр", "Петров", "Крестьянская 35", "Спортивная", "+79267775522", "31.03.2026", "четверо суток", "grey", ""},
        };
    }

    @Test
    public void orderHeader() {
        mainPage.clickOrderButtonHeader();
        formOrderPage.whoseScooter(name, surname, location, metroStation, phone);
        formOrderPage.aboutRent(date, time, color, comment);
        formOrderPage.clickButtonYesOrder();
        assertTrue("Заказ не создан",formOrderPage.isOrderPlaced(expectedOrder));
    }

    @Test
    public void orderHome() {
        mainPage.clickOrderButtonHome();
        formOrderPage.whoseScooter(name, surname, location, metroStation, phone);
        formOrderPage.aboutRent(date, time, color, comment);
        formOrderPage.clickButtonYesOrder();
        assertTrue("Заказ не создан",formOrderPage.isOrderPlaced(expectedOrder));
    }

}
