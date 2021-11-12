package ru.kpfu.itis.valeev;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.kpfu.itis.valeev.helpers.LoginHelper;
import ru.kpfu.itis.valeev.helpers.NavigationHelper;
import ru.kpfu.itis.valeev.helpers.ResearchGroupHelper;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    private WebDriver driver;
    private String baseUrl;
    private StringBuffer verificationErrors;
    private NavigationHelper navigation;
    private LoginHelper login;
    private ResearchGroupHelper researchGroup;
    public static ThreadLocal<ApplicationManager> applicationManager = new ThreadLocal<ApplicationManager>();

    private ApplicationManager() {
        System.setProperty("webdriver.chrome.driver", "/home/pain/Desktop/libs/chromedriver_linux64/chromedriver");
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        baseUrl = "https://www.google.com/";
        this.driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        this.verificationErrors = new StringBuffer();

        this.navigation = new NavigationHelper(this, baseUrl);
        this.login = new LoginHelper(this);
        this.researchGroup = new ResearchGroupHelper(this);
    }

    private void destruct(){
        try {
            driver.quit();
        }
        catch (Exception ignored) {}
    }

    public static ApplicationManager getInstance()
    {
        if (applicationManager.get()==null)
        {
            ApplicationManager newInstance = new ApplicationManager();
//            newInstance.getNavigation().openLoginPage();
            applicationManager.set(newInstance);
        }
        return applicationManager.get();
    }

//    public void stop(){
//        driver.quit();
//        String verificationErrorString = verificationErrors.toString();
//        if (!"".equals(verificationErrorString)) {
//            fail(verificationErrorString);
//        }
//    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public StringBuffer getVerificationErrors() {
        return verificationErrors;
    }

    public void setVerificationErrors(StringBuffer verificationErrors) {
        this.verificationErrors = verificationErrors;
    }

    public NavigationHelper getNavigation() {
        return navigation;
    }

    public void setNavigation(NavigationHelper navigation) {
        this.navigation = navigation;
    }

    public LoginHelper getLogin() {
        return login;
    }

    public void setLogin(LoginHelper login) {
        this.login = login;
    }

    public ResearchGroupHelper getResearchGroup() {
        return researchGroup;
    }

    public void setResearchGroup(ResearchGroupHelper researchGroup) {
        this.researchGroup = researchGroup;
    }


}
