package tests;

import model.Groups;
import org.testng.Assert;
import org.testng.annotations.*;
import model.GroupData;
import ru.javatrain.addressbook.TestBase;

import java.util.*;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTest extends TestBase {

    @DataProvider
    public Iterator<Object[]> validGroups() {
        List<Object[]> list = new ArrayList<Object[]>();
        list.add(new Object[] {new GroupData().withName("test1").withHeader("header1").withFooter("footer1")});
        list.add(new Object[] {new GroupData().withName("test2").withHeader("header2").withFooter("footer2")});
        list.add(new Object[] {new GroupData().withName("test3").withHeader("header3").withFooter("footer3")});
        return list.iterator();

    }

    @Test (dataProvider = "validGroups")
    public void testGroupCreation(GroupData group) throws Exception {
        app.goTo().groupPage();

       Groups before = app.group().all();

        app.group().initGroupModification();
        app.group().create(group);
        app.group().submitGroupPage();
        app.group().returntoGroupPage();

        Groups after = app.group().all();

        assertThat(app.group().count(), equalTo(before.size() +1));

        assertThat(after, equalTo(before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    }

    public void testBadGroupCreation() throws Exception {
        app.goTo().groupPage();

        Groups before = app.group().all();

        app.group().initGroupModification();
        GroupData group = new GroupData().withName("test2'");
        app.group().create(group);
        app.group().submitGroupPage();
        app.group().returntoGroupPage();

        Groups after = app.group().all();

        assertThat(app.group().count(), equalTo(before.size()));

        assertThat(after, equalTo(before));
    }


}