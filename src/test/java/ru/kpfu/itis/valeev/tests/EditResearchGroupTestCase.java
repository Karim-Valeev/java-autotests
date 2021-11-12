package ru.kpfu.itis.valeev.tests;

import org.junit.Assert;
import org.junit.Test;
import ru.kpfu.itis.valeev.data.AccountData;
import ru.kpfu.itis.valeev.data.ResearchGroupData;

public class EditResearchGroupTestCase extends TestBaseForTeUenv {

    @Test
    public void testUntitledTestCase() throws Exception {
        // TODO: 26.10.2021 rewrite "throws" to try catch

        applicationManager.getNavigation().openLoginPage();

        AccountData user = new AccountData("karim.valeev.i@gmail.com","w2w2w2w2");

        applicationManager.getLogin().login(user);

        applicationManager.getNavigation().openResearchGroupsPage();

        String url = applicationManager.getResearchGroup().getFirstGroupUrl();

        String id = applicationManager.getResearchGroup().getIdFromUrl(url);

        ResearchGroupData toBeEditedResearchGroup = new ResearchGroupData(
                "Тестовая т",
                "Тестовое описание Тестовое описание",
                "Без проекта",
                "name"
        );

        applicationManager.getNavigation().openEditReseargGroupPage(id);

        applicationManager.getResearchGroup().editResearchGroup(toBeEditedResearchGroup);

        Thread.sleep(1000);

        applicationManager.getNavigation().openResearchGroupsPage();

        ResearchGroupData editedResearchGroup = applicationManager.getResearchGroup().getFirstGroupData();

        System.out.println(toBeEditedResearchGroup);
        System.out.println(editedResearchGroup);

        Assert.assertEquals(toBeEditedResearchGroup, editedResearchGroup);

    }

}
