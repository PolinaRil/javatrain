package appmanager;

import model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactHelper extends HelperBase {
    public ContactHelper(WebDriver driver) {
        super(driver);
    }
    public void returnToContact() {
        driver.findElement(By.linkText("home")).click();
    }
    public void submitNewContact() {
        driver.findElement(By.name("submit")).click();
    }
    public void fillNewContact(String name, String patrname, String lastname, String nickname, String title, String company, String city, String home) {
        fillNewContact(new ContactData(name, patrname, lastname, nickname, title, company, city, home, "999999999", "tester", "999999991"));
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
        // driver.findElement(By.name("theform")).click();
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
    }

    public void createNewContact() {
        click(By.linkText("add new"));
    }
    public void initContactModification() {
        click(By.cssSelector("img[title=\"Edit\"]"));
    }
    public void submitContactModification() {
        click(By.name("update"));
    }
    public void submitContactCreation() {
        click(By.name("submit"));
    }
    //  public void gotoContacts() {
    //      driver.findElement(By.id("content")).click();
    //   }

    public int getContactCount() {
        return driver.findElements(By.name("selected[]")).size();
    }
}
