package appmanager;

import model.ContactData;
import model.Contacts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
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
        type(By.name("lastname"), contactData.getLastname());
        type(By.name("address"), contactData.getAddress());
        type(By.name("home"), contactData.getHomephone());
        type(By.name("mobile"), contactData.getMobphone());
        type(By.name("work"), contactData.getWorkphone());
        type(By.name("email"), contactData.getEmail1());
        type(By.name("email2"), contactData.getEmail2());
        type(By.name("email3"), contactData.getEmail3());
        attach(By.name("photo"), contactData.getPhoto());
    }

    public void createNewContact() {
        click(By.linkText("add new"));
    }

    public void initContactModification() {
        click(By.cssSelector("img[title=\"Edit\"]"));
    }

    public void initContactEdition() {
        click(By.cssSelector("input[name = \"modifiy\"]"));
    }

    public void viewContactInfo() {
        click(By.cssSelector("img[title=\"Details\"]"));
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
            ContactData contact = new ContactData().withId(id).withName(firstName).withLastname(lastName);

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

            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            String lastName = attributes.get(1).getText();
            String firstName = attributes.get(2).getText();
            String address = attributes.get(3).getText();
            String[] emails = attributes.get(4).getText().split("\n");
            String[] phones = attributes.get(5).getText().split("\n");

            contactCache.add(new ContactData().withId(id).withName(firstName).withLastname(lastName).withAllPhones(phones).withAddress(address).withAllEmails(emails));

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

    public ContactData infoFromEditForm(ContactData contact) {
        initContactModification();

        String name = driver.findElement(By.name("firstname")).getAttribute("value");
        String lastname = driver.findElement(By.name("lastname")).getAttribute("value");
        String mobphone = driver.findElement(By.name("mobile")).getAttribute("value");
        String home = driver.findElement(By.name("home")).getAttribute("value");
        String position = driver.findElement(By.name("work")).getAttribute("value");
        String address = driver.findElement(By.name("address")).getAttribute("value");
        String email1 = driver.findElement(By.name("email")).getAttribute("value");
        String email2 = driver.findElement(By.name("email2")).getAttribute("value");
        String email3 = driver.findElement(By.name("email3")).getAttribute("value");

        return new ContactData().withId(contact.getId()).withName(name).withLastname(lastname).withHomePhone(home).withMobPhone(mobphone).withWorkPhone(position).withEmail1(email1).withEmail2(email2).withEmail3(email3).withAddress(address);
    }

    public ContactData infoFromModificationForm(ContactData contact) {
        initContactEdition();

        String name = driver.findElement(By.name("firstname")).getAttribute("value");
        String lastname = driver.findElement(By.name("lastname")).getAttribute("value");
        String mobphone = driver.findElement(By.name("mobile")).getAttribute("value");
        String home = driver.findElement(By.name("home")).getAttribute("value");
        String position = driver.findElement(By.name("work")).getAttribute("value");
        String address = driver.findElement(By.name("address")).getAttribute("value");
        String email1 = driver.findElement(By.name("email")).getAttribute("value");
        String email2 = driver.findElement(By.name("email2")).getAttribute("value");
        String email3 = driver.findElement(By.name("email3")).getAttribute("value");

        return new ContactData().withId(contact.getId()).withName(name).withLastname(lastname).withHomePhone(home).withMobPhone(mobphone).withWorkPhone(position).withEmail1(email1).withEmail2(email2).withEmail3(email3).withAddress(address);
    }

    public ContactData infoFromInfoForm(ContactData contact) {
        viewContactInfo();

        String s = driver.findElement(By.id("content")).getText();
        String[] a = s.split("\n");

        List<String> contactData = Arrays.stream(a).filter(item -> !item.isEmpty()).toList();

        String[] concatName = contactData.get(0).split(" ");
        String firstname = concatName[0];
        String lastname = concatName[1];
        String address = contactData.get(1);
        String home = contactData.get(2).replaceAll("H", "").replaceAll(":", "").replaceAll(" ", "");
        String mobPhone = contactData.get(3).replaceAll("M", "").replaceAll(":", "").replaceAll(" ", "");
        String workPhone = contactData.get(4).replaceAll("W", "").replaceAll(":", "").replaceAll(" ", "");
        String email1 = contactData.get(5);
        String email2 = contactData.get(6);
        String email3 = contactData.get(7);

        return new ContactData().withId(contact.getId()).withName(firstname).withLastname(lastname).withAddress(address).withHomePhone(home).withMobPhone(mobPhone).withWorkPhone(workPhone).withEmail1(email1).withEmail2(email2).withEmail3(email3);
    }
}
