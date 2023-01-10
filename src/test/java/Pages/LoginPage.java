package Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.files.DownloadActions.click;

public class LoginPage {
    private final SelenideElement loginInput = $x("//form[@id='login']/input[@type='text']");
    private final SelenideElement passwordInput = $x("//form[@id='login']/input[@type='password']");
    private final SelenideElement enterTab = $x("//div[@id='auth']//a[@href='#login']");
    private final SelenideElement registerTab = $x("//div[@id='auth']//a[@href='#register']");
    private final SelenideElement checkBoxForgetMe = $x("//div[@id='auth']//label[@for='forget_me']");
    private final SelenideElement enterButton = $x("//div[@id='auth']//a[@class='helper']/preceding-sibling::button");
    private final SelenideElement userLogin = $x("//div[@id='auth']//input[@name='user_login']");
    private final SelenideElement userEmail = $x("//div[@id='auth']//input[@name='user_email']");
    private final SelenideElement registerButton = $x("//div[@id='auth']//button[contains(text(),'Зарегистрироваться')]");

    /**
     * Проверка на некорректные данные авторизации
     * @param login
     * @param password
     * @return
     */
    public ErrorLoginPage errorLogins(String login, String password) {
        enterTab.click();
        loginInput.sendKeys(login);
        passwordInput.sendKeys(password);
        checkBoxForgetMe.click();
        enterButton.click();
        return new ErrorLoginPage();
    }

    /**
     * Проверка на корректные данные авторизации
     * @param login
     * @param password
     * @return
     */
    public MainLoggedPage successLogins(String login, String password) {
        enterTab.click();
        loginInput.sendKeys(login);
        passwordInput.sendKeys(password);
        checkBoxForgetMe.click();
        enterButton.click();
        return new MainLoggedPage();
    }

    /**
     * Проверка регистрации нового пользователя
     * @param login
     * @param email
     * @return
     */
    public SuccessRegisterPage register (String login, String email){
        registerTab.click();
        userLogin.sendKeys(login);
        userEmail.sendKeys(email);
        registerButton.click();
        return new SuccessRegisterPage();
    }

    public ErrorLoginPage unRegister (String login, String email){
        registerTab.click();
        userLogin.sendKeys(login);
        userEmail.sendKeys(email);
        registerButton.click();
        return new ErrorLoginPage();
    }

}
