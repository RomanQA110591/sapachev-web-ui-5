package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

@ExtendWith(TimingExtension.class)
public class CreateContaktOrganize {
    private static final String LOGIN_PAGE_URL = "https://crm.geekbrains.space/user/login";
    private static final String STUDENT_LOGIN = "Applanatest";
    private static final String STUDENT_PASSWORD = "Student2020!";
    private static final WebDriver driver;


    private static Logger logger = LoggerFactory.getLogger(CreateContaktOrganize.class);
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
        driver.findElement(By.xpath(".//span[contains(.,'Контрагенты')]")).click();
        driver.findElement(By.xpath(".//span[contains(.,'Контактные лица')]")).click();
        Thread.sleep(5000L);
        driver.findElement(By.cssSelector("div[class='pull-left btn-group icons-holder']")).click();
        Thread.sleep(2000L);
        driver.findElement(By.xpath(".//div/div/div[2]/input")).sendKeys(new CharSequence[]{"Иванов"});
        assert CharSequence != null;
        Thread.sleep(2000L);
        driver.findElement(By.xpath(".//div[2]/div[2]/input")).sendKeys(new CharSequence[]{"Иван"});
        assert CharSequence != null;
        Thread.sleep(2000L);
        driver.findElement(By.xpath(".//div[2]/div[2]/div[2]/input")).sendKeys(new CharSequence[]{"Директор"});
        assert CharSequence != null;
        driver.findElement(By.xpath(".//*[@class='select2-chosen' and text()='Укажите организацию']")).click();
        Thread.sleep(2000L);
        driver.findElement(By.xpath(".//div[@class='select2-search']" + "/input[@class='select2-input select2-focused']")).sendKeys("123test");
        Thread.sleep(2000L);
        driver.findElement(By.xpath(".//div[@id='select2-drop']/div/input")).sendKeys(Keys.ENTER);
        Thread.sleep(2000L);

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

