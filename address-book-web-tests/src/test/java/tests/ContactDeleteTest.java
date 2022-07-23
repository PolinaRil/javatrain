package tests;

import model.ContactData;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;
import ru.javatrain.addressbook.TestBase;

import java.util.List;

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

    app.getGroupHelper().driver.findElement(By.name("selected[]"));
    app.getGroupHelper().driver.findElement(By.name("selected[]")).click();
    app.getGroupHelper().driver.findElement(By.cssSelector("input[value=\"Delete\"]")).click();
    app.getGroupHelper().driver.switchTo().alert().accept();

    List<ContactData> after = app.getContactHelper().getContactList();

    Assert.assertEquals(after.size(), before.size() - 1);
  }
}
