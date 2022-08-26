package tests;

import model.Groups;
import org.testng.Assert;
import org.testng.annotations.*;
import model.GroupData;
import ru.javatrain.addressbook.TestBase;

import java.io.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTest extends TestBase {

    @DataProvider
    public Iterator<Object[]> validGroups() throws IOException {
        List<Object[]> list = new ArrayList<Object[]>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/groups.csv")));
        String line = reader.readLine();
        while(line != null)    {
            String[] split = line.split(";");
            list.add(new Object[] {new GroupData().
                    withName(split[0]).
                    withHeader(split[1]).
                    withFooter(split[2])});
            line = reader.readLine();
        }
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