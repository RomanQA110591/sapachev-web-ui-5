package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.logging.*;
import java.util.Scanner;
import java.util.function.Supplier;
import java.util.logging.Level;

@ExtendWith(TimingExtension.class)
public class CreateProgect {
    private static final String LOGIN_PAGE_URL = "https://crm.geekbrains.space/user/login";
    private static final String STUDENT_LOGIN = "Applanatest";
    private static final String STUDENT_PASSWORD = "Student2020!";
    private static final WebDriver driver;


    private static Logger logger = LoggerFactory.getLogger(CreateProgect.class);

    @BeforeAll
    static void beforeAllTests() {

        logger.info("Before all tests");
    }

    @BeforeEach
    public void setUp() {

        logger.info("Test begins!");
    }




    static {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments(new String[]{"--disable-notifications"});
        options.addArguments(new String[]{"--disable-popup-blocking"});
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15L, TimeUnit.SECONDS);
    }

    @Test
    private static void login() {
        driver.get("https://crm.geekbrains.space/user/login");
        WebElement loginTextInput = driver.findElement(By.cssSelector("input[id='prependedInput']"));
        loginTextInput.sendKeys(new CharSequence[]{"Applanatest"});
        Assert.assertNotNull(loginTextInput);
        WebElement passwordTextInput = driver.findElement(By.cssSelector(".span2[name='_password']"));
        passwordTextInput.sendKeys(new CharSequence[]{"Student2020!"});
        Assert.assertNotNull(passwordTextInput);
        WebElement loginButton = driver.findElement(By.xpath(".//button[@name='_submit']"));
        loginButton.click();
    }

    @Test
    public static void main(String[] args) throws InterruptedException {
        login();
        driver.findElement(By.xpath(".//ul[@class='nav nav-multilevel main-menu']/li[@class='dropdown']/a[@class='unclickable']/span[text()='Проекты']")).click();
        driver.findElement(By.xpath(".//span[@class='title' and text()='Мои проекты']")).click();
        Thread.sleep(5000L);
        driver.findElement(By.cssSelector("div[class='pull-left btn-group icons-holder']")).click();
        Thread.sleep(2000L);
        driver.findElement(By.xpath(".//div/div/div[2]/input")).sendKeys(new CharSequence[]{"Test Geek 123"});
        Select expenditureDropDown = new Select(driver.findElement(By.xpath(".//div[5]/div[2]/div/select")));
        expenditureDropDown.selectByVisibleText("Research & Development");
        Assert.assertNotNull(expenditureDropDown);
        Select expenditureDropDown1 = new Select(driver.findElement(By.xpath(".//div[6]/div[2]/div/select")));
        expenditureDropDown1.selectByVisibleText("Гикбрейнс Студент");
        Assert.assertNotNull(expenditureDropDown1);
        Select expenditureDropDown2 = new Select(driver.findElement(By.xpath(".//div[7]/div[2]/div/select")));
        expenditureDropDown2.selectByVisibleText("Applanatest Applanatest Applanatest");
        Assert.assertNotNull(expenditureDropDown2);
        Select expenditureDropDown3 = new Select(driver.findElement(By.xpath(".//div[9]/div[2]/div/select")));
        expenditureDropDown3.selectByVisibleText("Applanatest Applanatest Applanatest");
        Assert.assertNotNull(expenditureDropDown3);
        driver.findElement(By.cssSelector("button[class='btn btn-success action-button']")).click();
        driver.quit();
    }


    @AfterEach
    public void tearDown() {

        logger.info("Test completed!");
    }


    @AfterAll
    static void afterAllTests() {

        logger.info("After all tests");
    }

}
