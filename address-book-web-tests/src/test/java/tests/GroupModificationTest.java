package tests;

import model.GroupData;
import model.Groups;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.javatrain.addressbook.TestBase;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.AssertJUnit.assertEquals;

public class GroupModificationTest extends TestBase {

    @BeforeTest
    public void ensurePreconditions() {
        app.goTo().groupPage();

        if (app.db().groups().size() == 0) {
            app.group().initGroupModification();
            app.group().create(new GroupData().withName("test1"));
            app.group().submitGroupPage();
            app.group().returntoGroupPage();
        }
    }

    @Test
    public void testGroupModification() throws Exception {
        Groups before = app.db().groups();

        GroupData modifiedGroup = before.iterator().next();
        app.group().editGroup();

        GroupData group = new GroupData().withId(modifiedGroup.getId()).withName("test1").withHeader("test2").withFooter("test3");

        app.group().modifyGroup(group);

        assertEquals(app.group().count(), before.size());

        Groups after = app.db().groups();

        assertThat(after, equalTo(before.withoutAdded(modifiedGroup).withAdded(modifiedGroup)));
    }

}