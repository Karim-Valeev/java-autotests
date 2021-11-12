package ru.kpfu.itis.valeev.helpers;

import org.openqa.selenium.*;
import ru.kpfu.itis.valeev.ApplicationManager;

public class HelperBase {

    public WebDriver driver;
    private boolean acceptNextAlert = true;
    private ApplicationManager applicationManager;

    public HelperBase(ApplicationManager applicationManager) {
        this.applicationManager = applicationManager;
        this.driver = applicationManager.getDriver();
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
