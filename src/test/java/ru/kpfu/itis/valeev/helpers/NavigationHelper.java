package ru.kpfu.itis.valeev.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.kpfu.itis.valeev.ApplicationManager;

public class NavigationHelper extends HelperBase{

    private ApplicationManager applicationManager;
    private String baseUrl;

    public NavigationHelper(ApplicationManager applicationManager, String baseUrl) {
        super(applicationManager);
        this.baseUrl = baseUrl;
    }

    public void openLoginPage() {
        driver.get("http://te.a.uenv.ru/login/");
    }

    public void openMainPage() {
        driver.get("http://te.a.uenv.ru/");
    }

    public void openCreateResearchGroupPage() {
        driver.get("http://te.a.uenv.ru/research_group/create/");
    }

    public void openResearchGroupsPage() {
        driver.get("http://te.a.uenv.ru/research_groups/");
    }

    public void openEditReseargGroupPage(String id){
        driver.get("http://te.a.uenv.ru/research_group/"+id+"/edit");
    }

}
