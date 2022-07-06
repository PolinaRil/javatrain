package appmanager;

import model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactHelper {
    public WebDriver driver;
    public ContactHelper(WebDriver driver) {
        this.driver = driver;
    }
    public void returntoContact() {
        driver.findElement(By.linkText("home")).click();
    }

    public void submitnewContact() {
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
      //  driver.findElement(By.name("email")).sendKeys(contactData.email1());
      //  driver.findElement(By.name("theform")).click();
     //   driver.findElement(By.name("email")).click();
     //   driver.findElement(By.name("email2")).click();
     //   driver.findElement(By.name("email2")).clear();
      //  driver.findElement(By.name("email2")).sendKeys(contactData.email2());
      //  driver.findElement(By.name("email3")).click();
      //  driver.findElement(By.name("email3")).clear();
     //   driver.findElement(By.name("email3")).sendKeys(contactData.email3());
        //  driver.findElement(By.name("theform")).click();
    }

    public void createnewContact() {
        driver.findElement(By.linkText("add new")).click();
    }

    public void initContactModification() { driver.findElement(By.cssSelector("img[title=\"Edit\"]")).click();
    }

    public void submitContactModification() { driver.findElement(By.name("update")).click();
    }

    public void submitContactCreation() { driver.findElement(By.name("submit")).click();
    }

    //  public void gotoContacts() {
  //      driver.findElement(By.id("content")).click();
 //   }

}
