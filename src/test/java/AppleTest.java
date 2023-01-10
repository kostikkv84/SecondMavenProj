import Pages.*;
import io.qameta.allure.Description;
import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

public class AppleTest extends BaseTest{
    private final static String BASE_URL = "https://appleinsider.ru/";
    private final static String SEARCH_STRING = "Чем отличаются дисплеи iPad";
    private final static String EXPECTED_WORD = "дисплеи iPad";
    private final static String EXPECTED_ERROR_LOGIN = "ОШИБКА";
    private final static String EXPECTED_ERROR_LOGIN_REGISTER = "Это имя пользователя уже зарегистрировано";
    private final static String EXPECTED_ERROR_EMAIL_REGISTER = "Этот адрес email уже зарегистрирован";
    private final static String EXPECTED_SUCCESS_LOGIN = "Выход";
    private final static String EXPECTED_SUCCESS_REGISTER = "Регистрация завершена";
    private final static String EXPECTED_DISCOUNT_PAGE = "Скидочки";
    private final static String WRONG_LOGIN = "Login";
    private final static String WRONG_PASSWORD = "Password:";
    private final static String NEW_LOGIN = "koskv";
    private final static String CORRECT_PASSWORD = "P@ssw0rd260805";
    private final static String NEW_EMAIL = "koskv@list.ru";



    @Test
    public void checkHref(){
        // длинная запись, полная.
        MainPage mainPage = new MainPage(BASE_URL);
        mainPage.search(SEARCH_STRING);
        SearchPage searchPage = new SearchPage();
        String href = searchPage.getHrefFirstArticle();
        Boolean contains = href.contains(EXPECTED_WORD);
        Assert.assertTrue(contains);
   /* короткая запись, цепочка методов.
        Assert.assertTrue(new MainPage(BASE_URL).
               search(SEARCH_STRING).
               getHrefFirstArticle().
               contains(SEARCH_STRING)); */

    }

   /** @Test
    public void checkFailLogin () {
        MainPage mainPage = new MainPage(BASE_URL);
        mainPage.loginFrame();
        LoginPage loginPage = new LoginPage();
        loginPage.errorLogins(WRONG_LOGIN, WRONG_PASSWORD);
        ErrorLoginPage errorLoginPage = new ErrorLoginPage();
        String error = errorLoginPage.getErrorLoginMessage();
        Boolean contains = error.contains(EXPECTED_ERROR_LOGIN);
        Assert.assertTrue(contains);
      /*  Boolean contains = new MainPage(BASE_URL).
                loginFrame().
                errorLogins(WRONG_LOGIN,WRONG_PASSWORD).
                getErrorLoginMessage().
                contains(EXPECTED_ERROR_LOGIN);
        Assert.assertTrue(contains);
    }*/

  /**  @Test
    public void checkSuccessLogin(){
        Assert.assertTrue(new MainPage(BASE_URL).
                loginFrame().
                successLogins(NEW_LOGIN,CORRECT_PASSWORD).
                getLogoutMessage().
                contains(EXPECTED_SUCCESS_LOGIN));
    }
*/
    @Test
    @Description("Проверка регистрации нового пользователя")
    public void checkRegisterSuccess () {
       /* MainPage mainPage = new MainPage(BASE_URL);
        mainPage.loginFrame();
        RegisterPage registerPage = new RegisterPage();
        registerPage.register(NEW_LOGIN+randNumber(),NEW_LOGIN + randNumber() + "@mail.ru");
        SuccessRegisterPage successRegisterPage = new SuccessRegisterPage();
        String error = successRegisterPage.successMsg();
        Boolean contains = error.contains(EXPECTED_SUCCESS_REGISTER);
        Assert.assertTrue(contains);*/
        Assert.assertTrue(new MainPage(BASE_URL).
                loginFrame().
                register(NEW_LOGIN+randNumber(),NEW_LOGIN + randNumber() + "@mail.ru")
                .successMsg().
                contains(EXPECTED_SUCCESS_REGISTER));
    }

  /**  @Test
    public void checkRegExistLogin (){
        MainPage mainPage = new MainPage(BASE_URL);
        mainPage.loginFrame();
        LoginPage loginPage = new LoginPage();
        loginPage.unRegister(NEW_LOGIN,NEW_LOGIN + randNumber() + "@mail.ru");
        ErrorLoginPage errorLoginPage = new ErrorLoginPage();
        String error = errorLoginPage.getErrorLoginMessage();
        Boolean contains = error.contains(EXPECTED_ERROR_LOGIN_REGISTER);
        Assert.assertTrue(contains);

     //   Assert.assertTrue(new MainPage(BASE_URL).loginFrame().unRegister(NEW_LOGIN,NEW_LOGIN + randNumber() + "@mail.ru").getErrorLoginMessage().contains(EXPECTED_ERROR_LOGIN_REGISTER));
    }

    @Test
    public void checkRegExistEmail (){
        Assert.assertTrue(new MainPage(BASE_URL).loginFrame().unRegister(NEW_LOGIN + randNumber(),NEW_EMAIL).getErrorLoginMessage().contains(EXPECTED_ERROR_EMAIL_REGISTER));
    }

    @Test
    public void checkDiscountButton(){
        Assert.assertTrue(new MainPage(BASE_URL).discountsPage().getDiscountHeader().contains(EXPECTED_DISCOUNT_PAGE));
    }

    @Test
    public void checkPaginations(){
       /* MainPage mainPage = new MainPage(BASE_URL);
        mainPage.search(SEARCH_STRING);
        SearchPage searchPage = new SearchPage();
        searchPage.paginations();
        String beforeText = searchPage.getPaginationsBefore();
        Boolean contains = beforeText.contains("Предыдущая");
        Assert.assertTrue(contains);

        Assert.assertTrue(new MainPage(BASE_URL).search(SEARCH_STRING).paginations().getPaginationsBefore().contains("Предыдущая"));
    }*/


}
