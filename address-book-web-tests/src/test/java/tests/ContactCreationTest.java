package tests;


import org.testng.Assert;
import org.testng.annotations.*;
import model.ContactData;
import ru.javatrain.addressbook.TestBase;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTest extends TestBase {
  @Test
  public void testContactCreation() throws Exception {
    app.getContactHelper().returnToContact();

    List<ContactData> before = app.getContactHelper().getContactList();

    app.getContactHelper().createNewContact();
    ContactData contact = new ContactData("Cont2", "Cont3", "Cont", "title", "COMPANY", "Novosibirsk", "nope", "nope", "999999999", "tester", "999999991");
    app.getContactHelper().fillNewContact(contact);
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToContact();

    List<ContactData> after = app.getContactHelper().getContactList();

    Assert.assertEquals(after.size(), before.size() + 1);

    contact.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
    before.add(contact);
    Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, before);
  }
}
