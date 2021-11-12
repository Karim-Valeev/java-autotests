package ru.kpfu.itis.valeev.helpers;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.json.simple.parser.JSONParser;
import ru.kpfu.itis.valeev.ApplicationManager;
import ru.kpfu.itis.valeev.data.AccountData;
import ru.kpfu.itis.valeev.data.ResearchGroupData;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LoginHelper extends HelperBase {

    private ApplicationManager applicationManager;

    public LoginHelper(ApplicationManager applicationManager) {
        super(applicationManager);
    }

//    Если передавать тесту на логин случайные данные, то тогда там надо использовать Assert.assertFalse
    public AccountData getDataOfAccount(){
    JSONParser parser = new JSONParser();
    try {
        JSONObject jsonObject = (JSONObject) parser.parse(new FileReader("src/resources/accounts.json"));

        JSONArray jsonArray = (JSONArray) jsonObject.get("accounts");

        JSONObject researhGroupJson = (JSONObject) jsonArray.get(0);

        AccountData accountData = new AccountData(
                researhGroupJson.get("email").toString(),
                researhGroupJson.get("password").toString()
        );

        return accountData;
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    } catch (ParseException e) {
        e.printStackTrace();
    }
    return null;
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

    public boolean isAddButtonExist(){
        WebElement addButton = driver.findElement(By.id("add"));
        return addButton!=null;
    }

}
