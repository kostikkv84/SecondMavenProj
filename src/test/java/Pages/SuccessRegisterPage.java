package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class SuccessRegisterPage {
    private final SelenideElement successMessage = $x("//div[@id='login']//p[@class='message']");

    public String successMsg () {
        return successMessage.getText();
    }


}
