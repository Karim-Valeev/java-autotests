package ru.kpfu.itis.valeev;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

// Здравствуйте, у меня проблемы со звуком на убунте :(
// Но я вас слышу
// Я выбрал сайт ask ubuntu, похож на стак оверфлоу
// Буквально на днях заработало расширение Кталон рекордер
// Поставив плагин селениум, создав проект, скачав Хром Драйвер НУЖНОЙ ВЕРСИИ все заработало

public class UntitledTestCase {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    JavascriptExecutor js;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "/home/pain/Downloads/asdf/chromedriver");
        driver = new ChromeDriver();
        baseUrl = "https://www.google.com/";
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        js = (JavascriptExecutor) driver;
    }

    @Test
    public void testUntitledTestCase() throws Exception {
        driver.get("https://askubuntu.com/users/login?ssrc=head&returnurl=https%3a%2f%2faskubuntu.com%2f");
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("karim.valeev.i@yandex.com");
        Thread.sleep(1000);
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).clear();
        Thread.sleep(1000);
        driver.findElement(By.id("password")).sendKeys("ask.ubuntu.1");
        Thread.sleep(1000);
        driver.findElement(By.id("submit-button")).click();
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
