package tests;

import model.GroupData;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.javatrain.addressbook.TestBase;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class GroupModificationTest extends TestBase {
    @Test
    public void testGroupModification() throws Exception {
        app.getNavigationHelper().gotoGroupPage();

        if (!app.isElementPresent(By.name("selected[]"))) {
            app.getGroupHelper().initGroupModification();
            app.getGroupHelper().fillGroupPage(new GroupData("test1", null, null));
            app.getGroupHelper().submitGroupPage();
            app.getGroupHelper().returntoGroupPage();
        }

        List<GroupData> before = app.getGroupHelper().getGroupList();

        app.getGroupHelper().selectGroup(before.size() - 1);
        app.getGroupHelper().editGroup();

        GroupData group = new GroupData(before.get(before.size() - 1).getId(),"test1", null, null);

        app.getGroupHelper().fillGroupPage(group);
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returntoGroupPage();

        List<GroupData> after = app.getGroupHelper().getGroupList();

        Assert.assertEquals(after.size(), before.size());

        before.remove(before.size() - 1);
        before.add(group);

        Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);

        Assert.assertEquals(before, after);
    }
}