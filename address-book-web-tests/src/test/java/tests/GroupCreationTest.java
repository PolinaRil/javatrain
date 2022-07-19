package tests;

import org.testng.annotations.*;
import model.GroupData;
import ru.javatrain.addressbook.TestBase;

public class GroupCreationTest extends TestBase {

    @Test
    public void testGroupCreation() throws Exception {
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupPage(new GroupData("test1", null, null));
        app.getGroupHelper().submitGroupPage();
        app.getGroupHelper().returntoGroupPage();
    }

}
