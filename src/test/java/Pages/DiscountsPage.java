package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class DiscountsPage {
    private final SelenideElement discountHeader = $x("//header[@class=\"discounts\"]/h1[@class=\"discounts\"]");

    /**
     * Получение заголовка страницы DiscountPage
     * @return
     */
    public String getDiscountHeader() {
        return discountHeader.getText();
    }
}
