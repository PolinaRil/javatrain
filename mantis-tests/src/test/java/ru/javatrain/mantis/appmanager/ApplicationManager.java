package ru.javatrain.mantis.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    private final Properties properties;
    private WebDriver driver;

    private String browser;
    private RegistrationHelper registrationHelper;

    public ApplicationManager(String browser) throws IOException {
        this.browser = browser;
        properties = new Properties();
    }

    public void init() throws IOException {
        String target = System.getProperty("target", "local");
        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));

        System.setProperty("webdriver.gecko.driver", properties.getProperty("webdriver.gecko.driver"));
        System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
        System.setProperty("webdriver.ie.driver", properties.getProperty("webdriver.ie.driver"));

    }

    public void stop() {
       if (driver!= null) {
           driver.quit();
       }
    }

    public HttpSession newSession() {
        return new HttpSession(this);
    }

    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }


    public Object getProperty(String key) {
        return properties.getProperty(key);
    }

    public RegistrationHelper registration() {
        if(registrationHelper ==null) {
            registrationHelper = new RegistrationHelper(this);
        }
        return registrationHelper;
    }

    public WebDriver getDriver() {
        if (driver ==null) {
            switch (browser) {
                case BrowserType.CHROME:
                    driver = new ChromeDriver();
                    break;
                case BrowserType.IE:
                    driver = new InternetExplorerDriver();
                    break;
                default:
                    driver = new FirefoxDriver();
                    break;
            }

            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.get(properties.getProperty("web.baseUrl"));
        }
        return driver;
    }
}
