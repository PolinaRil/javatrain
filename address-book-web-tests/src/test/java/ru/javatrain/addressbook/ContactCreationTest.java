package ru.javatrain.addressbook;

import org.testng.annotations.*;

public class ContactCreationTest extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    gotoContacts();
    createnewContact();
    fillNewContact(new ContactData("Cont2", "Cont3", "Cont", "title", "COMPANY", "Novosibirsk", "nope", "nope", "999999999", "tester", "999999991", "neveragain1@gmail.com", "neveragain2@gmail.com", "neveragain2@gmail.com"));
    submitnewContact();
    returntoContact();
  }

}
