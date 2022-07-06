package tests;

import model.ContactData;
import org.testng.annotations.Test;
import ru.javatrain.addressbook.TestBase;

public class ContactModificationTest extends TestBase {

    @Test
    public void testContactModification() throws Exception {
        app.getContactHelper().returntoContact();
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillNewContact(new ContactData("Cont2", "Cont3", "Cont", "title", "COMPANY", "UJJJH", "NSK", "NSK", "999999999", "1234", "999999991"));
        app.getContactHelper().submitContactModification();
        app.getContactHelper().returntoContact();
    }

}
