package Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class ErrorLoginPage {
    private final SelenideElement error = $x("//div[@id='login_error']");

    /**
     * Получение текста ошибки на странице ErrorLoadingPage
     * @return
     */
    public String getErrorLoginMessage (){
        return error.getText();
    }


}
