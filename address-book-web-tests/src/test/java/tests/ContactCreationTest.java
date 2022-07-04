package tests;

import org.testng.annotations.*;
import model.ContactData;
import ru.javatrain.addressbook.TestBase;

public class ContactCreationTest extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    app.gotoContacts();
    app.createnewContact();
    app.fillNewContact(new ContactData("Cont2", "Cont3", "Cont", "title", "COMPANY", "Novosibirsk", "nope", "nope", "999999999", "tester", "999999991", "neveragain1@gmail.com", "neveragain2@gmail.com", "neveragain2@gmail.com"));
    app.submitnewContact();
    app.returntoContact();
  }

}
