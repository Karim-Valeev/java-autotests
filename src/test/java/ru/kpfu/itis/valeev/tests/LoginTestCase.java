package ru.kpfu.itis.valeev.tests;

import org.junit.Assert;
import org.junit.Test;
import ru.kpfu.itis.valeev.data.AccountData;

public class LoginTestCase extends TestBaseForTeUenv {
    @Test
    public void testUntitledTestCase() throws Exception {
        // TODO: 26.10.2021 rewrite "throws" to try catch
        applicationManager.getNavigation().openLoginPage();

        AccountData user = new AccountData("karim.valeev.i@gmail.com","w2w2w2w2");

        applicationManager.getLogin().login(user);

        applicationManager.getNavigation().openMainPage();
        boolean isAddButtonExist = applicationManager.getLogin().isAddButtonExist();
        Assert.assertTrue(isAddButtonExist);
    }

}

