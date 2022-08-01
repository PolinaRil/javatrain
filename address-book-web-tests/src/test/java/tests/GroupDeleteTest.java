package tests;

import model.GroupData;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.javatrain.addressbook.TestBase;

import java.util.List;

public class GroupDeleteTest  extends TestBase {

    @BeforeTest
    public void ensurePreconditions() {
        app.goTo().groupPage();

        if (app.group().list().size() == 0) {
            app.group().initGroupModification();
            app.group().create(new GroupData().withName("test1"));
            app.group().submitGroupPage();
            app.group().returntoGroupPage();
        }
    }
    @Test
    public void testGroupDelete()  {
      app.goTo().groupPage();

      if (!app.isElementPresent(By.name("selected[]"))) {
          app.group().initGroupModification();
          app.group().create(new GroupData().withName("test1"));
          app.group().submitGroupPage();
          app.group().returntoGroupPage();
      }

      List<GroupData> before = app.group().list();

      app.group().selectGroup(before.size()-1);
      app.group().deleteSelectedGroup();
      app.group().returntoGroupPage();

      List<GroupData> after = app.group().list();

      Assert.assertEquals(after.size(), before.size() - 1);
    }
}