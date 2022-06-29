package ru.javatrain.addressbook;

import org.testng.annotations.Test;
public class GroupDeleteTest  extends TestBase {

    @Test
    public void testGroupDelete()  {
      gotoGroupPage();
      selectGroup();
      deleteSelectedGroup();
      returntoGroupPage();
    }
}

