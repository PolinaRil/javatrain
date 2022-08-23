package tests;

import model.ContactData;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.javatrain.addressbook.TestBase;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneAddressEmailTest extends TestBase {
    @Test
    public void testContactPhones() {
        app.contact().returnToContact();

        if (!app.isElementPresent(By.name("selected[]"))) {
            app.contact().createNewContact();
            app.contact().fillNewContact(new ContactData().withName("cont1").withLastname("lastname").withAddress("address").withHomePhone("123").withMobPhone("456").withWorkPhone("789").withEmail1("test@mail.ru").withEmail2("test2@mail.ru").withEmail3("test3@mail.ru"));
            app.contact().submitContactCreation();
        }

        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
        assertThat(contact.getAllPhones(), equalTo(contactInfoFromEditForm.getAllPhones()));
        assertThat(contact.getAddress(), equalTo(contactInfoFromEditForm.getAddress()));
        assertThat(contact.getAllEmails(), equalTo(contactInfoFromEditForm.getAllEmails()));
    }
}
