package Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage{

    private final SelenideElement searchInput = $x("//form[@role=\"search\"]/input");
    private final SelenideElement loginButton = $x("//button[@type=\"button\"]/i[@class=\"icon icon-lock\"]");
    private final SelenideElement discountsButton = $x("//header/nav//a[@title=\"discounts\"]");


    public MainPage(String url) { // конструктор
        Selenide.open(url);
    }

    /**
     * Выполняется поиск по переданной строке и нажимается Enter
     * @param searchString
     */
    public SearchPage search (String searchString) {
        searchInput.sendKeys(searchString, Keys.ENTER);
        return new SearchPage();
    }

    public LoginPage loginFrame (){
        loginButton.click();
        return new LoginPage();
    }

    public DiscountsPage discountsPage() {
        discountsButton.click();
        return new DiscountsPage();
    }




}
