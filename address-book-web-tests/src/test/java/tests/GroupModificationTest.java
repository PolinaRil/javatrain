package tests;

import model.GroupData;
import org.testng.annotations.Test;
import ru.javatrain.addressbook.TestBase;

public class GroupModificationTest extends TestBase {

    @Test
    public void testGroupModification() throws Exception {
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().editGroup();
        app.getGroupHelper().fillGroupPage(new GroupData("test1", "test7", "test3"));
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returntoGroupPage();

    }
}
