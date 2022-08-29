package tests;


import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.AnyTypePermission;
import model.ContactData;
import model.Contacts;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.javatrain.addressbook.TestBase;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ContactCreationTest extends TestBase {
    @DataProvider
    public Iterator<Object[]> validContacts() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.xml")));
        String xml = "";
        String line = reader.readLine();

        while (line != null) {
            xml += line;
            line = reader.readLine();
        }

        XStream xstream = new XStream();
        xstream.addPermission(AnyTypePermission.ANY);
        xstream.processAnnotations(ContactData.class);

        List<ContactData> contacts = (List<ContactData>) xstream.fromXML(xml);

        return contacts.stream().map((c) -> new Object[]{c}).collect(Collectors.toList()).iterator();
    }

    @Test(dataProvider = "validContacts")
    public void testContactCreation(ContactData contact) throws Exception {
        app.contact().returnToContact();

        Contacts before = app.db().contacts();
        System.out.println(before.stream().count());
        app.contact().createNewContact();
        //File photo = new File("src/test/resources/photo_2021-09-01_07-53-55.jpg");

        app.contact().fillNewContact(contact);
        app.contact().submitContactCreation();

        Thread.sleep(2000);

        Contacts after = app.db().contacts();
        before.add(contact);
        System.out.println(after.stream().count());

        assertThat(after.size(), equalTo(before.size()));
    }
}
