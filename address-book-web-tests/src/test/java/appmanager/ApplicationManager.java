package appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import model.ContactData;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    public WebDriver driver;

    private SessionHelper sessionHelper;
    private  NavigationHelper navigationHelper;
    private GroupHelper groupHelper;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    public void init() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\selecty\\Sites\\geckodriver\\geckodriver.exe");
        driver = new FirefoxDriver();
        baseUrl = "https://www.google.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        groupHelper = new GroupHelper(driver);
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

    public boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    public String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }

    public void returntoContact() {
      driver.findElement(By.linkText("home")).click();
    }

    public void submitnewContact() {
      driver.findElement(By.name("submit")).click();
    }

    public void fillNewContact(String name, String patrname, String lastname, String nickname, String title, String company, String city, String home) {
      fillNewContact(new ContactData(name, patrname, lastname, nickname, title, company, city, home, "999999999", "tester", "999999991", "neveragain1@gmail.com", "neveragain2@gmail.com", "neveragain2@gmail.com"));
    }

    public void fillNewContact(ContactData contactData) {
      driver.findElement(By.name("firstname")).click();
      driver.findElement(By.name("firstname")).click();
      driver.findElement(By.name("firstname")).clear();
      driver.findElement(By.name("firstname")).sendKeys(contactData.name());
      driver.findElement(By.name("middlename")).click();
      driver.findElement(By.name("middlename")).clear();
      driver.findElement(By.name("middlename")).sendKeys(contactData.patrname());
      driver.findElement(By.name("lastname")).click();
      driver.findElement(By.name("lastname")).clear();
      driver.findElement(By.name("lastname")).sendKeys(contactData.lastname());
      driver.findElement(By.name("nickname")).click();
      driver.findElement(By.name("nickname")).clear();
      driver.findElement(By.name("nickname")).sendKeys(contactData.nickname());
      driver.findElement(By.name("title")).click();
      driver.findElement(By.name("title")).clear();
      driver.findElement(By.name("title")).sendKeys(contactData.title());
      driver.findElement(By.name("company")).click();
      driver.findElement(By.name("company")).clear();
      driver.findElement(By.name("company")).sendKeys(contactData.company());
      driver.findElement(By.name("address")).click();
      driver.findElement(By.name("address")).clear();
      driver.findElement(By.name("address")).sendKeys(contactData.city());
      driver.findElement(By.name("theform")).click();
      driver.findElement(By.name("home")).click();
      driver.findElement(By.name("home")).clear();
      driver.findElement(By.name("home")).sendKeys(contactData.home());
      driver.findElement(By.name("mobile")).click();
      driver.findElement(By.name("mobile")).clear();
      driver.findElement(By.name("mobile")).sendKeys(contactData.mobphone());
      driver.findElement(By.name("work")).click();
      driver.findElement(By.name("work")).clear();
      driver.findElement(By.name("work")).sendKeys(contactData.position());
      driver.findElement(By.name("fax")).click();
      driver.findElement(By.name("fax")).clear();
      driver.findElement(By.name("fax")).sendKeys(contactData.fax());
      driver.findElement(By.name("email")).click();
      driver.findElement(By.name("email")).clear();
      driver.findElement(By.name("email")).sendKeys(contactData.email1());
      driver.findElement(By.name("theform")).click();
      driver.findElement(By.name("email")).click();
      driver.findElement(By.name("email2")).click();
      driver.findElement(By.name("email2")).clear();
      driver.findElement(By.name("email2")).sendKeys(contactData.email2());
      driver.findElement(By.name("email3")).click();
      driver.findElement(By.name("email3")).clear();
      driver.findElement(By.name("email3")).sendKeys(contactData.email3());
      driver.findElement(By.name("theform")).click();
    }

    public void createnewContact() {
      driver.findElement(By.linkText("add new")).click();
    }

    public void gotoContacts() {
      driver.findElement(By.id("content")).click();
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }
}
