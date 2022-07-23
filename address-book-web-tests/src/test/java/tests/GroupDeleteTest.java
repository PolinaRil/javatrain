package tests;

import model.GroupData;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.javatrain.addressbook.TestBase;

public class GroupDeleteTest  extends TestBase {
    @Test
    public void testGroupDelete()  {
      app.getNavigationHelper().gotoGroupPage();
        int before = app.getGroupHelper().getGroupCount();

      if (!app.isElementPresent(By.name("selected[]"))) {
          app.getGroupHelper().initGroupModification();
          app.getGroupHelper().fillGroupPage(new GroupData("test1", null, null));
          app.getGroupHelper().submitGroupPage();
          app.getGroupHelper().returntoGroupPage();
      }

      app.getGroupHelper().selectGroup(before-1);
      app.getGroupHelper().deleteSelectedGroup();
      app.getGroupHelper().returntoGroupPage();
        int after = app.getGroupHelper().getGroupCount();
        Assert.assertEquals(after, before - 1);
    }
}

