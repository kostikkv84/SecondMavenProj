import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import java.awt.image.renderable.ParameterBlock;
import java.util.Random;

abstract public class BaseTest {

    public void setUp() {
        WebDriverManager.chromedriver().setup(); // Установили настройки драйвера
        Configuration.browser = "chrome";
        Configuration.driverManagerEnabled = true;
        Configuration.browserSize = "1920x1080";
        Configuration.headless = false;
  }

  @Before
    public void init() { setUp();  }

  @After
    public void tearDown (){
      Selenide.closeWebDriver();
  }

    /**
     * Метод генерирующий случайное число для тестов.
     */
  public String randNumber () {
      Random rand = new Random();
      String randNumber = Integer.toString(rand.nextInt(99999));
      return randNumber;
  }
}



