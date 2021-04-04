package org.example;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.interactions.Actions;

@Feature("Авторизация")
public class AuthorizationTest3 extends BaseTest {

    public static final String LOGIN_URL = "http://demowebshop.tricentis.com/login";
    public static final String LOGIN = "test110591110591@mail.ru";
    public static final String PASSWORD = "1105917";


    @Test
    @DisplayName("Проверка авторизации на сайте")
    void loginTest() {
        Actions builder = new Actions(driver);
        builder
                .sendKeys(LOGIN_URL)
                .sendKeys(LOGIN)
                .sendKeys(PASSWORD)
                .click()
                .build()
                .perform();
    }
}
