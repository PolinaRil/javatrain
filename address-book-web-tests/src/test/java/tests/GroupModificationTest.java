package tests;

import model.GroupData;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.javatrain.addressbook.TestBase;

import java.util.Comparator;
import java.util.List;

public class GroupModificationTest extends TestBase {

    @BeforeTest
    public void ensurePreconditions() {
        app.goTo().groupPage();

        if (app.group().list().size() == 0) {
            app.group().initGroupModification();
            app.group().create(new GroupData("test1", null, null));
            app.group().submitGroupPage();
            app.group().returntoGroupPage();
        }
    }
    @Test
    public void testGroupModification() throws Exception {
        List<GroupData> before = app.group().list();

        int index = before.size() - 1;
        app.group().selectGroup(index);
        app.group().editGroup();

        GroupData group = new GroupData(before.get(index).getId(),"test1", null, null);

        app.group().modifyGroup(index, group);

        List<GroupData> after = app.group().list();

        Assert.assertEquals(after.size(), before.size());

        before.remove(index);
        before.add(group);

        Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);

        Assert.assertEquals(before, after);
    }

}