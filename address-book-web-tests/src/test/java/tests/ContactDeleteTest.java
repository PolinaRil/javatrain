package tests;

import model.ContactData;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;
import ru.javatrain.addressbook.TestBase;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ContactDeleteTest extends TestBase {
  @Test (enabled = false)
  public void testContactDelete() throws Exception {
    app.contact().returnToContact();

    if (!app.isElementPresent(By.name("selected[]"))) {
      app.contact().createNewContact();
      app.contact().fillNewContact(new ContactData().withName("cont1").withLastname("lastname"));
      app.contact().submitContactCreation();
    }

    List<ContactData> before = app.contact().getContactList();

    app.contact().driver.findElement(By.name("selected[]"));
    app.contact().driver.findElement(By.name("selected[]")).click();
    app.contact().driver.findElement(By.cssSelector("input[value=\"Delete\"]")).click();
    app.contact().driver.switchTo().alert().accept();

    app.contact().driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    List<ContactData> after = app.getContactHelper().getContactList();

    Assert.assertEquals(after.size(), before.size() - 1);
  }
}
