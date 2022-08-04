package tests;


import org.testng.Assert;
import org.testng.annotations.*;
import model.ContactData;
import ru.javatrain.addressbook.TestBase;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class ContactCreationTest extends TestBase {
  @Test (enabled = true)
  public void testContactCreation() throws Exception {
    app.contact().returnToContact();

    Set<ContactData> before = app.contact().all();

    app.contact().createNewContact();

    ContactData contact = new ContactData().withName("cont1").withLastname("lastname");

    System.out.println(before);

    app.contact().fillNewContact(contact);
    app.contact().submitContactCreation();


    app.contact().driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    Set<ContactData> after = app.contact().all();

    System.out.println(after);

    Assert.assertEquals(after.size(), before.size() + 1);

    contact.withId(after.stream().max(Comparator.comparingInt(ContactData::getId)).get().getId());
    before.add(contact);
    Assert.assertEquals(after, before);
  }
}
