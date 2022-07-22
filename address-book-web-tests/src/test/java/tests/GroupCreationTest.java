package tests;

import org.testng.Assert;
import org.testng.annotations.*;
import model.GroupData;
import ru.javatrain.addressbook.TestBase;

public class GroupCreationTest extends TestBase {

    @Test
    public void testGroupCreation() throws Exception {
        app.getNavigationHelper().gotoGroupPage();
        int before = app.getGroupHelper().getGroupCount();
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupPage(new GroupData("test1", null, null));
        app.getGroupHelper().submitGroupPage();
        app.getGroupHelper().returntoGroupPage();
        int after = app.getGroupHelper().getGroupCount();
        Assert.assertEquals(after, before +1);
    }

}
