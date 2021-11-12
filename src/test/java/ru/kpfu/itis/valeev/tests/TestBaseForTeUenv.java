package ru.kpfu.itis.valeev.tests;

import org.junit.After;
import org.junit.Before;
import ru.kpfu.itis.valeev.ApplicationManager;

public class TestBaseForTeUenv {
    public ApplicationManager applicationManager;

    @Before
    public void setUp() throws Exception {
        applicationManager = ApplicationManager.getInstance();
    }

//    @After
//    public void tearDown() throws Exception {
//        applicationManager.stop();
//    }

}
