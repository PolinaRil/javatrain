package tests;

import model.ContactData;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.javatrain.addressbook.TestBase;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactInfoTest extends TestBase {
    @Test(enabled = true)
    public void testContactInfo() throws Exception {
        app.contact().returnToContact();

        if (!app.isElementPresent(By.name("selected[]"))) {
            app.contact().createNewContact();
            app.contact().fillNewContact(new ContactData().withName("cont1").withLastname("lastname").withAddress("address").withHomePhone("123").withMobPhone("456").withWorkPhone("789").withEmail1("test1@mail.ru").withEmail2("test2@mail.ru").withEmail3("test3@mail.ru"));

            app.contact().submitContactCreation();
        }

        ContactData contact = app.contact().all().iterator().next();

        ContactData contactInfoFromInfoForm = app.contact().infoFromInfoForm(contact);
        ContactData contactInfoFromEditForm = app.contact().infoFromModificationForm(contact);

        assertThat(contactInfoFromInfoForm.getName(), equalTo(contactInfoFromEditForm.getName()));
        assertThat(contactInfoFromInfoForm.getLastname(), equalTo(contactInfoFromEditForm.getLastname()));
        assertThat(contactInfoFromInfoForm.getAddress(), equalTo(contactInfoFromEditForm.getAddress()));
        assertThat(contactInfoFromInfoForm.getAllPhones(), equalTo(contactInfoFromEditForm.getAllPhones()));
        assertThat(contactInfoFromInfoForm.getAllEmails(), equalTo(contactInfoFromEditForm.getAllEmails()));
    }
}