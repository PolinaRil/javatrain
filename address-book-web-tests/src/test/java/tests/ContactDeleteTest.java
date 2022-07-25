package tests;

import model.ContactData;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;
import ru.javatrain.addressbook.TestBase;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ContactDeleteTest extends TestBase {
  @Test
  public void testContactDelete() throws Exception {
    app.getContactHelper().returnToContact();

    if (!app.isElementPresent(By.name("selected[]"))) {
      app.getContactHelper().createNewContact();
      app.getContactHelper().fillNewContact(new ContactData("Cont2", "Cont3", "Cont", "title", "COMPANY", "Novosibirsk", "nope", "nope", "999999999", "tester", "999999991"));
      app.getContactHelper().submitContactCreation();
    }

    List<ContactData> before = app.getContactHelper().getContactList();

    app.getContactHelper().driver.findElement(By.name("selected[]"));
    app.getContactHelper().driver.findElement(By.name("selected[]")).click();
    app.getContactHelper().driver.findElement(By.cssSelector("input[value=\"Delete\"]")).click();
    app.getContactHelper().driver.switchTo().alert().accept();

    app.getContactHelper().driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    List<ContactData> after = app.getContactHelper().getContactList();

    Assert.assertEquals(after.size(), before.size() - 1);
  }
}
