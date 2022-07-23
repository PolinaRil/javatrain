package tests;

import model.GroupData;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.javatrain.addressbook.TestBase;

import java.util.List;

public class GroupDeleteTest  extends TestBase {
    @Test
    public void testGroupDelete()  {
      app.getNavigationHelper().gotoGroupPage();

      if (!app.isElementPresent(By.name("selected[]"))) {
          app.getGroupHelper().initGroupModification();
          app.getGroupHelper().fillGroupPage(new GroupData("test1", null, null));
          app.getGroupHelper().submitGroupPage();
          app.getGroupHelper().returntoGroupPage();
      }

      List<GroupData> before = app.getGroupHelper().getGroupList();
      app.getGroupHelper().selectGroup(before.size()-1);
      app.getGroupHelper().deleteSelectedGroup();
      app.getGroupHelper().returntoGroupPage();
      List<GroupData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size() - 1);
    }
}

