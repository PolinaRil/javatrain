package tests;


import org.testng.Assert;
import org.testng.annotations.*;
import model.ContactData;
import ru.javatrain.addressbook.TestBase;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTest extends TestBase {
  @Test (enabled = true)
  public void testContactCreation() throws Exception {
    app.contact().returnToContact();

    List<ContactData> before = app.getContactHelper().getContactList();

    app.contact().createNewContact();
    ContactData contact = new ContactData().withName("cont1").withLastname("lastname");
    app.contact().fillNewContact(contact);
    app.contact().submitContactCreation();
    app.contact().returnToContact();

    List<ContactData> after = app.contact().getContactList();

    Assert.assertEquals(after.size(), before.size() + 1);

    contact.withId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
    before.add(contact);
    Comparator<? super ContactData> byId = Comparator.comparingInt(ContactData::getId);
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, before);
  }
}
