package appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    public WebDriver driver;
    private SessionHelper sessionHelper;
    private  NavigationHelper navigationHelper;
    private GroupHelper groupHelper;
    private ContactHelper contactHelper;
    private final String browser;
    public ApplicationManager(String browser) {
        this.browser = browser;
    }
    public void init() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\selecty\\Sites\\geckodriver\\geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\selecty\\Sites\\geckodriver\\chromedriver.exe");
        System.setProperty("webdriver.ie.driver", "C:\\Users\\selecty\\Sites\\geckodriver\\IEDriverServer.exe");

        switch (browser) {
            case BrowserType.FIREFOX -> driver = new FirefoxDriver();
            case BrowserType.CHROME -> driver = new ChromeDriver();
            case BrowserType.IE -> driver = new InternetExplorerDriver();
            default -> driver = new FirefoxDriver();
        }

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://localhost/addressbook/");

        groupHelper = new GroupHelper(driver);
        contactHelper = new ContactHelper(driver);
        navigationHelper = new NavigationHelper(driver);

        sessionHelper = new SessionHelper(driver);
        sessionHelper.login ("admin","secret");
    }

    public void stop() {
        driver.quit();
    }

    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public ContactHelper getContactHelper() {
        return contactHelper;
    }

    public SessionHelper getSessionHelper() {
        return sessionHelper;
    }
}
