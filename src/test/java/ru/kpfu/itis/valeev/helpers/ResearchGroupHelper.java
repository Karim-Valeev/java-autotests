package ru.kpfu.itis.valeev.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import ru.kpfu.itis.valeev.ApplicationManager;
import ru.kpfu.itis.valeev.data.ResearchGroupData;

public class ResearchGroupHelper extends HelperBase {

    private ApplicationManager applicationManager;

    public ResearchGroupHelper(ApplicationManager applicationManager) {
        super(applicationManager);
    }

    public void createResearchGroup(ResearchGroupData researhGroup) throws InterruptedException {
        driver.findElement(By.id("topic")).click();
        driver.findElement(By.id("topic")).clear();
        driver.findElement(By.id("topic")).sendKeys(researhGroup.getTopic());
        driver.findElement(By.id("description")).click();
        driver.findElement(By.id("description")).clear();
        driver.findElement(By.id("description")).sendKeys(researhGroup.getDescription());
        driver.findElement(By.id("project")).click();
        new Select(driver.findElement(By.id("project"))).selectByVisibleText(researhGroup.getProject());
        new Select(driver.findElement(By.id("words"))).selectByVisibleText(researhGroup.getWords());
        driver.findElement(By.id("btn_submit")).click();
    }

    public ResearchGroupData getFirstGroupData(){
        driver.findElement(By.className("project__item")).click();
        String topic = driver.findElement(By.className("publication__header--title")).getText();
        String description = driver.findElements(By.className("project__slide--item-name")).get(2).getText();
        String project = driver.findElements(By.className("project__slide--item-name")).get(3).getText();
        String words = driver.findElements(By.className("project__slide--item-name")).get(1).getText();
        return new ResearchGroupData(topic, description, project, words);
    }

    public String getFirstGroupUrl(){
        return driver.findElement(By.className("project__item")).getAttribute("href");
    }

    public String getIdFromUrl(String url){
        StringBuilder reverseId = new StringBuilder();
        for(int i = url.length()-2; i>-1; i--){
            if(url.charAt(i) != '/'){
                reverseId.append(url.charAt(i));
            } else {
                break;
            }
        }
        return reverseId.reverse().toString();
    }

    public void editResearchGroup(ResearchGroupData researhGroup){
        driver.findElement(By.id("id_title")).click();
        driver.findElement(By.id("id_title")).clear();
        driver.findElement(By.id("id_title")).sendKeys(researhGroup.getTopic());
        driver.findElement(By.id("id_description")).click();
        driver.findElement(By.id("id_description")).clear();
        driver.findElement(By.id("id_description")).sendKeys(researhGroup.getDescription());
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Научный проект:'])[1]/following::button[1]")).click();
    }

}
