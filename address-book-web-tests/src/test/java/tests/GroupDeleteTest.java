package tests;

import model.GroupData;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.javatrain.addressbook.TestBase;

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

      app.getGroupHelper().selectGroup();
      app.getGroupHelper().deleteSelectedGroup();
      app.getGroupHelper().returntoGroupPage();
    }
}

