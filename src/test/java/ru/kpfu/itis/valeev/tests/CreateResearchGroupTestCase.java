package ru.kpfu.itis.valeev.tests;

import org.junit.Assert;
import org.junit.Test;
import ru.kpfu.itis.valeev.data.AccountData;
import ru.kpfu.itis.valeev.data.ResearchGroupData;

public class CreateResearchGroupTestCase extends TestBaseForTeUenv {

    @Test
    public void testUntitledTestCase() throws Exception {
        // TODO: 26.10.2021 rewrite "throws" to try catch

        applicationManager.getNavigation().openLoginPage();

        AccountData user = new AccountData("karim.valeev.i@gmail.com","w2w2w2w2");

        applicationManager.getLogin().login(user);

        applicationManager.getNavigation().openCreateResearchGroupPage();

        ResearchGroupData researchGroup = new ResearchGroupData("Тестовая тема 12345","Тестовое описание","Без проекта","name");

        applicationManager.getResearchGroup().createResearchGroup(researchGroup);

//        Не успевают классы верстки прогрузиться
        Thread.sleep(1000);

        ResearchGroupData newResearchGroup = applicationManager.getResearchGroup().getFirstGroupData();

        Assert.assertEquals(researchGroup, newResearchGroup);

    }

}
