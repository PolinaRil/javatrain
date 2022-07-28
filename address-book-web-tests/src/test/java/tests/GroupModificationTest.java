package tests;

import model.GroupData;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.javatrain.addressbook.TestBase;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class GroupModificationTest extends TestBase {

    @BeforeTest
    public void ensurePreconditions() {
        app.getNavigationHelper().gotoGroupPage();

        if (!app.isElementPresent(By.name("selected[]"))) {
            app.getGroupHelper().initGroupModification();
            app.getGroupHelper().fillGroupPage(new GroupData("test1", null, null));
            app.getGroupHelper().submitGroupPage();
            app.getGroupHelper().returntoGroupPage();
        }
    }
    @Test
    public void testGroupModification() throws Exception {
        List<GroupData> before = app.getGroupHelper().getGroupList();

        int index = before.size() - 1;
        app.getGroupHelper().selectGroup(index);
        app.getGroupHelper().editGroup();

        GroupData group = new GroupData(before.get(index).getId(),"test1", null, null);

        app.getGroupHelper().modifyGroup(index, group);

        List<GroupData> after = app.getGroupHelper().getGroupList();

        Assert.assertEquals(after.size(), before.size());

        before.remove(index);
        before.add(group);

        Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);

        Assert.assertEquals(before, after);
    }

}