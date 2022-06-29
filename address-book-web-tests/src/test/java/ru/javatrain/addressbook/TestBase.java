package ru.javatrain.addressbook;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

public class TestBase {
    public WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\selecty\\Sites\\geckodriver\\geckodriver.exe");
        driver = new FirefoxDriver();
        baseUrl = "https://www.google.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        login ("admin","secret");
    }

    protected void login(String username, String password) {
        driver.get("http://localhost/addressbook/group.php");
        driver.findElement(By.name("user")).click();
        driver.findElement(By.name("user")).clear();
        driver.findElement(By.name("user")).sendKeys(username);
        driver.findElement(By.name("pass")).click();
        driver.findElement(By.name("pass")).clear();
        driver.findElement(By.name("pass")).sendKeys(password);
        driver.findElement(By.id("LoginForm")).submit();

    }

    protected void returntoGroupPage() {
        driver.findElement(By.linkText("group page")).click();
    }

    protected void submitGroupPage() {
        driver.findElement(By.name("submit")).click();
    }

    protected void fillGroupPage(GroupData groupData) {
        driver.findElement(By.xpath("//div[@id='content']/form/input[4]")).click();
        driver.findElement(By.name("group_name")).click();
        driver.findElement(By.name("group_name")).click();
        driver.findElement(By.name("group_name")).clear();
        driver.findElement(By.name("group_name")).sendKeys(groupData.name());
        driver.findElement(By.name("group_header")).click();
        driver.findElement(By.name("group_header")).clear();
        driver.findElement(By.name("group_header")).sendKeys(groupData.header());
        driver.findElement(By.name("group_footer")).click();
        driver.findElement(By.name("group_footer")).clear();
        driver.findElement(By.name("group_footer")).sendKeys(groupData.footer());
    }

    protected void gotoGroupPage() {
    driver.findElement(By.linkText("groups")).click();
  }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
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

    protected void deleteSelectedGroup() {
      driver.findElement(By.name("delete")).click();
    }

    protected void selectGroup() {
      driver.findElement(By.name("selected[]")).click();
    }

    protected void returntoContact() {
      driver.findElement(By.linkText("home")).click();
    }

    protected void submitnewContact() {
      driver.findElement(By.name("submit")).click();
    }

    protected void fillNewContact(String name, String patrname, String lastname, String nickname, String title, String company, String city, String home) {
      fillNewContact(new ContactData(name, patrname, lastname, nickname, title, company, city, home, "999999999", "tester", "999999991", "neveragain1@gmail.com", "neveragain2@gmail.com", "neveragain2@gmail.com"));
    }

    protected void fillNewContact(ContactData contactData) {
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

    protected void createnewContact() {
      driver.findElement(By.linkText("add new")).click();
    }

    protected void gotoContacts() {
      driver.findElement(By.id("content")).click();
    }
}
