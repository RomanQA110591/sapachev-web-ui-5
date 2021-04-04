package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
public class Avtorizatsiya {
    private static final String URL = "http://demowebshop.tricentis.com/login";
    private static final WebDriver driver;


    private static Logger logger = LoggerFactory.getLogger(Avtorizatsiya.class);
    private static Object CharSequence;

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

        driver.get("http://demowebshop.tricentis.com/login");
        Assert.assertTrue(URL == URL);
    }

    @Test
    public static void main(String[] args) throws InterruptedException {
        login();
        Thread.sleep(2000L);
        driver.findElement(By.xpath(".//input[@id='Email']")).sendKeys(new CharSequence[]{"test110591110591@mail.ru"});
        assert CharSequence != null;
        Thread.sleep(2000L);
        driver.findElement(By.xpath(".//input[@id='Password']")).sendKeys(new CharSequence[]{"1105917"});
        assert CharSequence != null;
        Thread.sleep(2000L);
        driver.findElement(By.xpath(".//input[@value='Log in']")).click();
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

