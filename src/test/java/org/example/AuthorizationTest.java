package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

@Feature("Авторизация сайта")
public class AuthorizationTest {


    @Test
    @DisplayName("Проверка авторизации на сайте")
    void loginTest() {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments(new String[]{"--disable-notifications"});
        options.addArguments(new String[]{"--disable-popup-blocking"});
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15L, TimeUnit.SECONDS);


        JavascriptExecutor js = (JavascriptExecutor)driver;


        driver.get("http://demowebshop.tricentis.com/login");


        //Login
        driver.findElement(By.xpath(".//input[@id='Email']")).sendKeys(new CharSequence[]{"test110591110591@mail.ru"});
        driver.findElement(By.xpath(".//input[@id='Password']")).sendKeys(new CharSequence[]{"1105917"});

        WebElement button = driver.findElement(By.xpath(".//input[@value='Log in']"));

        //Perform Click on LOGIN button using JavascriptExecutor
        js.executeScript("arguments[0].click();", button);
    }
}


