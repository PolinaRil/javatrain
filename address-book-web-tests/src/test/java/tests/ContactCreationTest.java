package tests;


import model.ContactData;
import model.Contacts;
import org.testng.annotations.Test;
import ru.javatrain.addressbook.TestBase;

import java.io.File;
import java.util.Comparator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ContactCreationTest extends TestBase {
    @Test(enabled = true)
    public void testContactCreation() throws Exception {
        app.contact().returnToContact();

        Contacts before = app.contact().all();

        app.contact().createNewContact();
        File photo = new File("src/test/resources/photo_2021-09-01_07-53-55.jpg");

        ContactData contact = new ContactData().withName("cont1").withLastname("lastname").withAddress("address").withHomePhone("123").withMobPhone("456").withWorkPhone("789").withEmail1("test@mail.ru").withEmail2("test2@mail.ru").withEmail3("test3@mail.ru").withPhoto(photo);

        app.contact().fillNewContact(contact);
        app.contact().submitContactCreation();


        Contacts after = app.contact().all();
        after.add(contact);

        Thread.sleep(2000);
        assertThat(after.size(), equalTo(before.size() + 1));

        assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().max(Comparator.comparingInt(ContactData::getId)).get().getId()))));
    }

}
