package tests;

import model.ContactData;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.javatrain.addressbook.TestBase;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactInfoTest extends TestBase {

    @Test(enabled = true)
    public void testContactInfo() throws Exception {
        app.contact().returnToContact();

        if (!app.isElementPresent(By.name("selected[]"))) {
            app.contact().createNewContact();
            app.contact().fillNewContact(new ContactData().withName("cont1").withLastname("lastname").withAddress("address").withHomephone("123").withMobphone("456").withWorkPhone("789")
                    .withEmail1("test@mail.ru").withEmail2("test2@mail.ru").withEmail3("test3@mail.ru"));
            app.contact().submitContactCreation();

        }
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromInfoForm = app.contact().infoFromInfoForm(contact);
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm2(contact);
 //       assertThat(contact.getContactName(), equalTo(mergecontactName(contactInfoFromEditForm)));
       assertThat(contact.getAddress(), equalTo(contactInfoFromEditForm.getAddress()));
//        assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
//        assertThat(contact.getAllEmails(), equalTo(mergeEmails(contactInfoFromEditForm)));
    }



        private String mergecontactName(ContactData contact) {
            return Arrays.asList(contact.getName(), contact.getLastname()).stream().filter((s) -> !s.equals("")).collect(Collectors.joining(" "));
        }

}