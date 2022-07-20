package tests;

import org.testng.annotations.*;
import model.ContactData;
import ru.javatrain.addressbook.TestBase;

public class ContactCreationTest extends TestBase {
  @Test
  public void testContactCreation() throws Exception {
    app.getContactHelper().returnToContact();
    app.getContactHelper().createNewContact();
    app.getContactHelper().fillNewContact(new ContactData("Cont2", "Cont3", "Cont", "title", "COMPANY", "Novosibirsk", "nope", "nope", "999999999", "tester", "999999991"));
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToContact();
  }

}
