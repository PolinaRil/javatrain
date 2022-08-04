package tests;

import model.GroupData;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.javatrain.addressbook.TestBase;

import java.util.List;
import java.util.Set;

public class GroupDeleteTest  extends TestBase {

    @BeforeTest
    public void ensurePreconditions() {
        app.goTo().groupPage();

        if (app.group().all().size() == 0) {
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

      Set<GroupData> before = app.group().all();
      GroupData deletedGroup = before.iterator().next();

      app.group().delete(deletedGroup);
      app.group().returntoGroupPage();

      Set<GroupData> after = app.group().all();

      Assert.assertEquals(after.size(), before.size() - 1);

      before.remove(deletedGroup);
        Assert.assertEquals(before,after);
    }
}