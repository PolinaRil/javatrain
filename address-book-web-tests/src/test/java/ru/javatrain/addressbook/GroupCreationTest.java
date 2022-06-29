package ru.javatrain.addressbook;

import org.testng.annotations.*;

public class GroupCreationTest extends TestBase {

    @Test
    public void testGroupCreation() throws Exception {
        gotoGroupPage();
        fillGroupPage(new GroupData("test1", "test2", "test3"));
        submitGroupPage();
        returntoGroupPage();
    }

}
