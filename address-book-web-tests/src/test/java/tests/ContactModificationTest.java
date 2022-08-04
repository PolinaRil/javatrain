package tests;

import model.ContactData;
import model.GroupData;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.javatrain.addressbook.TestBase;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class ContactModificationTest extends TestBase {
    @Test (enabled = true)
    public void testContactModification() throws Exception {
        app.contact().returnToContact();

        if (!app.isElementPresent(By.name("selected[]"))) {
            app.contact().createNewContact();
            app.contact().fillNewContact(new ContactData().withName("cont1").withLastname("lastname"));
            app.contact().submitContactCreation();
        }

        Set<ContactData> before = app.contact().all();

        app.contact().selectContact(before.size() - 1);
        app.contact().initContactModification();

        ContactData contact = new ContactData().withName("cont1").withLastname("lastname");

        app.contact().modifyContact(contact);
//        app.contact().fillNewContact(contact);
//        app.contact().submitContactModification();


        Set<ContactData> after = app.contact().all();

        Assert.assertEquals(after.size(), before.size());

        before.remove(before.size() - 1);
        before.add(contact);

        Assert.assertEquals(before, after);
    }
}
