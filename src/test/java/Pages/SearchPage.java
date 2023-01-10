package Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class SearchPage {
    private final ElementsCollection articlesTitle = $$x("//div[@id='primary']//article//a");
    private final SelenideElement paginationButtonNext = $x("//div[@class=\"pagination-number \"]/a");
    private final SelenideElement paginationButtonBefore = $x("//div[@class=\"pagination-number \"]//span[contains(text(),\"Предыдущая\")]");

    /**
     * Возвращает аттрибут href первой найденной записи.
     * @return
     */
    public String getHrefFirstArticle(){
        return articlesTitle.first().getText();
    }

    public SearchPage paginations(){
        paginationButtonNext.click();
        return this;
    }
    public String getPaginationsBefore() {
        return paginationButtonBefore.getText();
    }
}
