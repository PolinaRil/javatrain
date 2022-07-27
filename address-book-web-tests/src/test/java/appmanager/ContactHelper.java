package appmanager;

import model.ContactData;
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
        type(By.name("address"), contactData.getCity());
        type(By.name("home"), contactData.getHome());
        type(By.name("mobile"),contactData. getMobphone());
        type(By.name("work"), contactData.getPosition());
        type(By.name("fax"), contactData.getFax());
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

    public void selectContact() {
        driver.findElement(By.name("selected[]")).click();
    }

    public List<ContactData> getContactList() {
        List<ContactData> contacts = new ArrayList<ContactData>();
        List<WebElement> elements = driver.findElements(By.cssSelector("[name=\"entry\"]"));

        for (WebElement element : elements) {
            List<WebElement> attributes = element.findElements(By.tagName("td"));

            String lastName = attributes.get(1).getText();
            String firstName = attributes.get(2).getText();

            ContactData contact = new ContactData(
                    firstName,
                    null,
                    lastName,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null
            );

            contacts.add(contact);
        }

        return contacts;
    }
}
