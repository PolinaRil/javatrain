package tests;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.AnyTypePermission;
import model.Groups;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;
import model.GroupData;
import ru.javatrain.addressbook.TestBase;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTest extends TestBase {
    Logger logger = LoggerFactory.getLogger(GroupCreationTest.class);
    @DataProvider
    public Iterator<Object[]> validGroups() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/groups.xml")));
        String xml = "";
        String line = reader.readLine();

        while (line != null) {
            xml += line;
            line = reader.readLine();
        }

        XStream xstream = new XStream();
        xstream.addPermission(AnyTypePermission.ANY);
        xstream.processAnnotations(GroupData.class);

        List<GroupData> groups = (List<GroupData>) xstream.fromXML(xml);

        return groups.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
    }

    @Test(dataProvider = "validGroups")
    public void testGroupCreation(GroupData group) throws Exception {
        logger.info("Start GroupCreationTest");
        app.goTo().groupPage();

        Groups before = app.db().groups();

        app.group().initGroupModification();
        app.group().create(group);
        app.group().submitGroupPage();
        app.group().returntoGroupPage();

        Groups after = app.db().groups();

        assertThat(app.group().count(), equalTo(before.size() + 1));
        assertThat(after, equalTo(before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
        logger.info("Start GroupCreationTest");
    }
    @Test
    public void testBadGroupCreation() throws Exception {
        app.goTo().groupPage();

        Groups before = app.db().groups();

        app.group().initGroupModification();
        GroupData group = new GroupData().withName("test2'");
        app.group().create(group);
        app.group().submitGroupPage();
        app.group().returntoGroupPage();

        Groups after = app.db().groups();

        assertThat(app.group().count(), equalTo(before.size()));
        assertThat(after, equalTo(before));
    }
}