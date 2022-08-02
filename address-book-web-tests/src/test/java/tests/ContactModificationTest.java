package tests;

import model.ContactData;
import model.GroupData;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.javatrain.addressbook.TestBase;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTest extends TestBase {
    @Test (enabled = false)
    public void testContactModification() throws Exception {
        app.contact().returnToContact();

        if (!app.isElementPresent(By.name("selected[]"))) {
            app.contact().createNewContact();
            app.contact().fillNewContact(new ContactData().withName("cont1").withLastname("lastname"));
            app.contact().submitContactCreation();
        }

        List<ContactData> before = app.contact().getContactList();

        app.contact().selectContact(before.size() - 1);
        app.contact().initContactModification();

        ContactData contact = new ContactData().withName("cont1").withLastname("lastname");

        app.contact().fillNewContact(contact);
        app.contact().submitContactModification();

        // app.getContactHelper().returnToContact();

        List<ContactData> after = app.contact().getContactList();

        Assert.assertEquals(after.size(), before.size());

        before.remove(before.size() - 1);
        before.add(contact);

        Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);

        Assert.assertEquals(before, after);
    }
}
