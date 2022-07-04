package tests;

import org.openqa.selenium.By;
import org.testng.annotations.*;
import ru.javatrain.addressbook.TestBase;

public class ContactDeleteTest extends TestBase {

  @Test
  public void testContactDelete() throws Exception {
    app.returntoContact();
    app.getGroupHelper().driver.findElement(By.name("selected[]")).click();
    app.getGroupHelper().driver.findElement(By.cssSelector("input[value=\"Delete\"]")).click();
    app.getGroupHelper().driver.switchTo().alert().accept();
    //returntoContact();
  }
}
