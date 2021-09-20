package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.files.DownloadActions.click;

public class AutomationPracticeFormTests {
    // Определяем с помощью BeforAll конфигурацию для всего текста
    @BeforeAll
    static void beforeall(){
        // Развертываем наш хром на весь экран
        Configuration.startMaximized = true;
        Configuration.baseUrl = "https://demoqa.com";

    }
    // Начало теста
    @Test
    void fillFormTests() {
    // Определяем строковые переменные для теста
    String firstName = "Dmitry";
    String lastName = "Msximov";
    String userEmail = "maxdim@mail.com";
    String userNumber = "9152691452";

        open("/automation-practice-form");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("#userNumber").setValue(userNumber);
        // Не понятно как отрабатывает нижняя строка
        $(byText("Male")).click();
        $("#dateOfBirthInput").click();
        // Выбираем селектор и через selectOptions выбираем текст
        $(".react-datepicker__month-select").selectOption("May");
        $(".react-datepicker__year-select").selectOption("1983");
        // Выбираем селектор. У нас могут быть несколько повторяющиеся числа
        // с помощью not мы отсекаем не нужные.
        $(".react-datepicker__day--025:not(react-datepicker__day--outside-month)").click();
        $("#userNumber").setValue(userNumber);

    }
}