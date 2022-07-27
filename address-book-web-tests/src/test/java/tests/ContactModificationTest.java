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
    @Test
    public void testContactModification() throws Exception {
        app.getContactHelper().returnToContact();

        if (!app.isElementPresent(By.name("selected[]"))) {
            app.getContactHelper().createNewContact();
            app.getContactHelper().fillNewContact(new ContactData("Cont2", "Cont3", "Cont", "title", "COMPANY", "Novosibirsk", "nope", "nope", "999999999", "tester", "999999991"));
            app.getContactHelper().submitContactCreation();
        }

        List<ContactData> before = app.getContactHelper().getContactList();

        app.getContactHelper().selectContact(before.size() - 1);
        app.getContactHelper().initContactModification();

        ContactData contact = new ContactData("Cont2", "Cont3", "Cont", "title", "COMPANY", "Novosibirsk", "nope", "nope", "999999999", "tester", "999999991");

        app.getContactHelper().fillNewContact(contact);
        app.getContactHelper().submitContactModification();

        // app.getContactHelper().returnToContact();

        List<ContactData> after = app.getContactHelper().getContactList();

        Assert.assertEquals(after.size(), before.size());

        before.remove(before.size() - 1);
        before.add(contact);

        Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);

        Assert.assertEquals(before, after);
    }
}
