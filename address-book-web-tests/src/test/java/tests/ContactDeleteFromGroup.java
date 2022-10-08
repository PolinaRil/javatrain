package tests;

import model.ContactData;
import model.Contacts;
import model.GroupData;
import model.Groups;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.javatrain.addressbook.TestBase;

public class ContactDeleteFromGroup extends TestBase {

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
    public void testContactDeleteFromGroup() {
        app.contact().returnToContact();
        Groups groups = app.db().groups();
        Contacts contacts = app.db().contacts();
        ContactData modifiedContact = contacts.iterator().next();

        System.out.println(modifiedContact.getGroups());
        app.contact().inAndOutGroup(modifiedContact);
    }

}
