package tests;

import org.testng.annotations.Test;
import ru.javatrain.addressbook.TestBase;

public class GroupDeleteTest  extends TestBase {

    @Test
    public void testGroupDelete()  {
      app.getNavigationHelper().gotoGroupPage();
      app.getGroupHelper().selectGroup();
      app.getGroupHelper().deleteSelectedGroup();
      app.getGroupHelper().returntoGroupPage();
    }
}

