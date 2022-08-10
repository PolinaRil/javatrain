package tests;


import model.Contacts;
import org.testng.Assert;
import org.testng.annotations.*;
import model.ContactData;
import ru.javatrain.addressbook.TestBase;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ContactCreationTest extends TestBase {
  @Test (enabled = true)
  public void testContactCreation() throws Exception {
    app.contact().returnToContact();

   Contacts before = app.contact().all();

    app.contact().createNewContact();

    ContactData contact = new ContactData().withName("cont1").withLastname("lastname");

    System.out.println(before);

    app.contact().fillNewContact(contact);
    app.contact().submitContactCreation();


    app.contact().driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    Contacts after = app.contact().all();

    System.out.println(after);

    assertThat(after.size(), equalTo(before.size() + 1));

    before.add(contact);
    assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().max(Comparator.comparingInt(ContactData::getId)).get().getId()))));
  }
}
