package tests;

import org.testng.annotations.*;
import model.GroupData;
import ru.javatrain.addressbook.TestBase;

public class GroupCreationTest extends TestBase {

    @Test
    public void testGroupCreation() throws Exception {
        app.gotoGroupPage();
        app.fillGroupPage(new GroupData("test1", "test2", "test3"));
        app.submitGroupPage();
        app.returntoGroupPage();
    }

}
