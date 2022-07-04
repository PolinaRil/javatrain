package tests;

import org.openqa.selenium.By;
import org.testng.annotations.*;
import ru.javatrain.addressbook.TestBase;

public class ContactDeleteTest extends TestBase {

  @Test
  public void testContactDelete() throws Exception {
    app.returntoContact();
    app.driver.findElement(By.name("selected[]")).click();
    app.driver.findElement(By.cssSelector("input[value=\"Delete\"]")).click();
    app.driver.switchTo().alert().accept();
    //returntoContact();
  }
}
