package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainLoggedPage {
    private final SelenideElement logOutButton = $x("//header//li[@class=\"user\"]/a[@title=\"logout\"]");

    public String getLogoutMessage () { return logOutButton.getText(); }


}
