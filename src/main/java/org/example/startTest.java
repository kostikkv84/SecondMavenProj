package org.example;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;
//import org.openqa.selenium.firefox.FirefoxDriver;


public class startTest {
    @Test
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://en.wikipedia.org");
        driver.findElement(By.xpath("//input[@id=\"searchButton\"]")).click();

        driver.get("https://github.com/login");
        driver.findElement(By.id("login_field")).sendKeys("koskv@list.ru");
        driver.findElement(By.id("password")).sendKeys("P@ssw0rd4323");

        WebElement signIn = driver.findElement(By.xpath("//div[@class='position-relative']//input[@name=\'commit\']"));
        signIn.submit();



      //  driver.quit();



    }
}
