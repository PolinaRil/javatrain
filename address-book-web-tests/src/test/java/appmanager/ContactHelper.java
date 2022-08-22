package appmanager;

import model.ContactData;
import model.Contacts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {
    public ContactHelper(WebDriver driver) {
        super(driver);
    }

    public void returnToContact() {
        driver.findElement(By.linkText("home")).click();
    }

    public void fillNewContact(ContactData contactData) {
        driver.findElement(By.name("firstname")).click();
        type(By.name("firstname"), contactData.getName());
        type(By.name("middlename"), contactData.getPatrname());
        type(By.name("lastname"), contactData.getLastname());
        type(By.name("nickname"), contactData.getNickname());
        type(By.name("title"), contactData.getTitle());
        type(By.name("company"), contactData.getCompany());
        type(By.name("address"), contactData.getAddress());
        type(By.name("home"), contactData.getHomephone());
        type(By.name("mobile"),contactData. getMobphone());
        type(By.name("work"), contactData.getWorkphone());
        type(By.name("fax"), contactData.getFax());
        type(By.name("email"), contactData.getEmail1());
        type(By.name("email2"), contactData.getEmail2());
        type(By.name("email3"), contactData.getEmail3());
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

    public int getContactCount() {
        return driver.findElements(By.name("selected[]")).size();
    }

    private Contacts contactCache = null;

    public void selectContact(int index) {
        driver.findElements(By.name("selected[]")).get(index).click();
    }

    public List<ContactData> getContactList() {
        List<ContactData> contacts = new ArrayList<ContactData>();
        List<WebElement> elements = driver.findElements(By.cssSelector("[name=\"entry\"]"));

        for (WebElement element : elements) {
            List<WebElement> attributes = element.findElements(By.tagName("td"));

            String lastName = attributes.get(1).getText();
            String firstName = attributes.get(2).getText();

            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            ContactData contact = new ContactData().
                    withId(id).
                    withName(firstName).
                    withLastname(lastName);

            contacts.add(contact);
        }

        return contacts;
    }

    public Contacts all() {
        if (contactCache != null) {
            return new Contacts(contactCache);
        }
        contactCache = new Contacts();
        List<WebElement> elements = driver.findElements(By.cssSelector("[name=\"entry\"]"));


        for (WebElement element : elements) {

            List<WebElement> attributes = element.findElements(By.tagName("td"));

            String lastName = attributes.get(1).getText();
            String firstName = attributes.get(2).getText();
            String address = attributes.get(3).getText();
            String allEmails = attributes.get(4).getText();
            String allPhones = attributes.get(5).getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            contactCache.add(new ContactData().withId(id).withName(firstName).withLastname(lastName).
                    withallPhones(allPhones).withAddress(address).
                    withallEmails(allEmails));

            System.out.println(contactCache);
            System.out.println(contactCache.size());
        }

        return contactCache;
    }
    public void modifyContact(ContactData contact) {
        fillNewContact(contact);
        submitContactModification();
        contactCache = null;
    }

    public void delete(ContactData contact) {
       driver.findElement(By.name("selected[]"));
       driver.findElement(By.name("selected[]")).click();
       driver.findElement(By.cssSelector("input[value=\"Delete\"]")).click();
       contactCache = null;
       driver.switchTo().alert().accept();
    }

    public ContactData infoFromEditForm (ContactData contact) {
        initContactModification();
        String name = driver.findElement(By.name("firstname")).getAttribute("value");
        String lastname = driver.findElement(By.name("lastname")).getAttribute("value");
        String mobphone = driver.findElement(By.name("mobile")).getAttribute("value");
        String home = driver.findElement(By.name("home")).getAttribute("value");
        String position = driver.findElement(By.name("work")).getAttribute("value");
        String address = driver.findElement(By.name("address")).getAttribute("value");
        String email1 =  driver.findElement(By.name("email")).getAttribute("value");
        String email2 =  driver.findElement(By.name("email2")).getAttribute("value");
        String email3 =  driver.findElement(By.name("email3")).getAttribute("value");
        return new ContactData().withId(contact.getId()).withName(name).withLastname(lastname).
                withHomephone(home).withMobphone(mobphone).withWorkPhone(position).withEmail1(email1).withEmail2(email2).withEmail3(email3).withAddress(address);

    }
}
