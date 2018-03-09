package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

/**
 * Класс для управления приложением, управляет браузером и создает основные вспомогательные объекты
 */
public class ApplicationManager {

    WebDriver wd;

    private SessionHelper sessionHelper;
    private NavigationHelper navigationHelper;
    private GroupHelper groupHelper;
    private ContactHelper contactHelper;
    private String browserType;

    public ApplicationManager(String browserType) {
        this.browserType = browserType;
    }

    public void init() {
        if (this.browserType.equals(BrowserType.FIREFOX)) {
            System.setProperty("webdriver.gecko.driver", "/home/evg/browser/geckodriver");
            wd = new FirefoxDriver();
        } else if (this.browserType.equals(BrowserType.CHROME)) {
            System.setProperty("webdriver.chrome.driver", "/home/evg/browser/chromedriver");
            wd = new ChromeDriver();
        }

        wd.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        wd.get("http://localhost/addressbook/index.php");

        groupHelper = new GroupHelper(wd);
        contactHelper = new ContactHelper(wd);
        navigationHelper = new NavigationHelper(wd);
        sessionHelper = new SessionHelper(wd);
        sessionHelper.login("admin", "secret");

    }

    public void stop() {
        wd.quit();
    }

    public GroupHelper group() {
        return groupHelper;
    }

    public NavigationHelper goTo() {
        return navigationHelper;
    }

    public ContactHelper contact() {
        return contactHelper;
    }
}
