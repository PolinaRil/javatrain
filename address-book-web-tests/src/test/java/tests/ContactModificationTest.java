package tests;

import model.ContactData;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.javatrain.addressbook.TestBase;

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
        app.getContactHelper().selectContact();
        //driver.findElement(By.name("selected[]"));
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillNewContact(new ContactData("Cont2", "Cont3", "Cont", "title", "COMPANY", "UJJJH", "NSK", "NSK", "999999999", "1234", "999999991"));
        app.getContactHelper().submitContactModification();
        app.getContactHelper().returnToContact();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size());
    }

}
