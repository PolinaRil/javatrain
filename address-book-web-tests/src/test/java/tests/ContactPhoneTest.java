package tests;

import model.ContactData;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.javatrain.addressbook.TestBase;

public class ContactPhoneTest extends TestBase {

    @Test
    public void testContactPhones() {
        app.contact().returnToContact();

        if (!app.isElementPresent(By.name("selected[]"))) {
            app.contact().createNewContact();
            app.contact().fillNewContact(new ContactData().withName("cont1").withLastname("lastname"));
            app.contact().submitContactCreation();
        }

        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().InfoFromEditForm(contact);

    }



}
