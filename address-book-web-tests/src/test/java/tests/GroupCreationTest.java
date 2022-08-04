package tests;

import org.testng.Assert;
import org.testng.annotations.*;
import model.GroupData;
import ru.javatrain.addressbook.TestBase;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class GroupCreationTest extends TestBase {
    @Test
    public void testGroupCreation() throws Exception {
        app.goTo().groupPage();

        Set<GroupData> before = app.group().all();

        app.group().initGroupModification();
        GroupData group = new GroupData().withName("test2");
        app.group().create(group);
        app.group().submitGroupPage();
        app.group().returntoGroupPage();

        Set<GroupData> after = app.group().all();

        Assert.assertEquals(after.size(), before.size() +1);

        group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
        before.add(group);
        Assert.assertEquals(before, before);
    }
}