package tests;

import org.testng.annotations.Test;
import ru.javatrain.addressbook.TestBase;

public class GroupDeleteTest  extends TestBase {

    @Test
    public void testGroupDelete()  {
      app.gotoGroupPage();
      app.selectGroup();
      app.deleteSelectedGroup();
      app.returntoGroupPage();
    }
}

