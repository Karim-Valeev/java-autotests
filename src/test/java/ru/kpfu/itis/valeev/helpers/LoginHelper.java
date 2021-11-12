package ru.kpfu.itis.valeev.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.kpfu.itis.valeev.ApplicationManager;
import ru.kpfu.itis.valeev.data.AccountData;

public class LoginHelper extends HelperBase {

    private ApplicationManager applicationManager;

    public LoginHelper(ApplicationManager applicationManager) {
        super(applicationManager);
    }

    public void login(AccountData user) {
        driver.findElement(By.name("username")).click();
        driver.findElement(By.name("username")).clear();
        driver.findElement(By.name("username")).sendKeys(user.getEmail());
        driver.findElement(By.xpath("//div")).click();
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys(user.getPassword());
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    // TODO: 05.11.2021 проверить, что на главной странице появилась иконка ЛК
    public boolean isAddButtonExist(){
        WebElement addButton = driver.findElement(By.id("add"));
        return addButton!=null;
    }

}
