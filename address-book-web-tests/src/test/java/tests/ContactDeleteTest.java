package tests;

import model.ContactData;
import model.GroupData;
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

    Set<ContactData> before = app.contact().all();
    ContactData deletedContact = before.iterator().next();

    app.contact().delete(deletedContact);

    app.contact().driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);

    Set<ContactData> after = app.contact().all();

    Assert.assertEquals(after.size(), before.size() - 1);
  }
}
