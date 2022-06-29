package ru.javatrain.addressbook;

import org.openqa.selenium.By;
import org.testng.annotations.*;

public class ContactDeleteTest extends TestBase {

  @Test
  public void testContactDelete() throws Exception {
    returntoContact();
    driver.findElement(By.name("selected[]")).click();
    driver.findElement(By.cssSelector("input[value=\"Delete\"]")).click();
    driver.switchTo().alert().accept();
    //returntoContact();
  }
}
