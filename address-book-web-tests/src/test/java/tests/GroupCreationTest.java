package tests;

import org.testng.Assert;
import org.testng.annotations.*;
import model.GroupData;
import ru.javatrain.addressbook.TestBase;
import java.util.HashSet;
import java.util.List;

public class GroupCreationTest extends TestBase {
    @Test
    public void testGroupCreation() throws Exception {
        app.getNavigationHelper().gotoGroupPage();

        List<GroupData> before = app.getGroupHelper().getGroupList();

        app.getGroupHelper().initGroupModification();
        GroupData group = new GroupData("test2", null, null);
        app.getGroupHelper().fillGroupPage(group);
        app.getGroupHelper().submitGroupPage();
        app.getGroupHelper().returntoGroupPage();

        List<GroupData> after = app.getGroupHelper().getGroupList();

        Assert.assertEquals(after.size(), before.size() +1);

        group.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
        before.add(group);

        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    }
}