package tests;

import model.GroupData;
import model.Groups;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
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

      Groups before = app.group().all();
      GroupData deletedGroup = before.iterator().next();

      app.group().delete(deletedGroup);
      app.group().returntoGroupPage();

      Groups after = app.group().all();

      Assert.assertEquals(after.size(), before.size() - 1);

        MatcherAssert.assertThat(after, CoreMatchers.equalTo(before.withoutAdded(deletedGroup)));
    }
}