package tests;

import org.testng.Assert;
import org.testng.annotations.*;
import model.GroupData;
import ru.javatrain.addressbook.TestBase;

import java.util.List;

public class GroupCreationTest extends TestBase {

    @Test
    public void testGroupCreation() throws Exception {
        app.getNavigationHelper().gotoGroupPage();

        List<GroupData> before = app.getGroupHelper().getGroupList();

        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupPage(new GroupData("test1", null, null));
        app.getGroupHelper().submitGroupPage();
        app.getGroupHelper().returntoGroupPage();

        List<GroupData> after = app.getGroupHelper().getGroupList();

        Assert.assertEquals(after.size(), before.size() +1);
    }

}
