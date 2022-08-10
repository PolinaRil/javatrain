package tests;

import model.ContactData;
import model.Contacts;
import model.GroupData;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;
import ru.javatrain.addressbook.TestBase;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class ContactDeleteTest extends TestBase {
  @Test (enabled = true)
  public void testContactDelete() throws Exception {
    app.contact().returnToContact();

    if (!app.isElementPresent(By.name("selected[]"))) {
      app.contact().createNewContact();
      app.contact().fillNewContact(new ContactData().withName("cont1").withLastname("lastname"));
      app.contact().submitContactCreation();
    }

    Contacts before = app.contact().all();
    ContactData deletedContact = before.iterator().next();

    app.contact().delete(deletedContact);

    Thread.sleep(1000);
    Contacts after = app.contact().all();

    MatcherAssert.assertThat(after, CoreMatchers.equalTo(before.withoutAdded(deletedContact)));
  }
}
