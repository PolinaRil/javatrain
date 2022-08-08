package tests;

import model.Groups;
import org.testng.Assert;
import org.testng.annotations.*;
import model.GroupData;
import ru.javatrain.addressbook.TestBase;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTest extends TestBase {
    @Test
    public void testGroupCreation() throws Exception {
        app.goTo().groupPage();

       Groups before = app.group().all();

        app.group().initGroupModification();
        GroupData group = new GroupData().withName("test2");
        app.group().create(group);
        app.group().submitGroupPage();
        app.group().returntoGroupPage();

        Groups after = app.group().all();

        assertThat(after.size(), equalTo(before.size() +1));

        assertThat(after, equalTo(before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    }
}