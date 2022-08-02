package tests;

import model.GroupData;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.javatrain.addressbook.TestBase;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class GroupModificationTest extends TestBase {

    @BeforeTest
    public void ensurePreconditions() {
        app.goTo().groupPage();

        if (app.group().list().size() == 0) {
            app.group().initGroupModification();
            app.group().create(new GroupData().withName("test1"));
            app.group().submitGroupPage();
            app.group().returntoGroupPage();
        }
    }
    @Test
    public void testGroupModification() throws Exception {
        Set<GroupData> before = app.group().all();

        GroupData modifiedGroup = before.iterator().next();
        app.group().editGroup();

        GroupData group = new GroupData().withId(modifiedGroup.getId()).withName("test1").withHeader("test2").withFooter("test3");

        app.group().modifyGroup(group);

        Set<GroupData> after = app.group().all();

        Assert.assertEquals(after.size(), before.size());

        before.remove(modifiedGroup);
        before.add(group);

        Assert.assertEquals(before, after);
    }

}