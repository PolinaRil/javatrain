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
        System.out.println("T0");

        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.xml")));
        String xml = "";
        String line = reader.readLine();

        System.out.println("T1");

        while(line != null)    {
            xml += line;
            line = reader.readLine();
        }

        System.out.println("T2");

        XStream xstream = new XStream();
        xstream.addPermission(AnyTypePermission.ANY);
        xstream.processAnnotations(ContactData.class);

        System.out.println("T3");
        List<ContactData> contacts = (List<ContactData>) xstream.fromXML(xml);

        System.out.println("T4");
        return contacts.stream().map((c) -> new Object[]{c}).collect(Collectors.toList()).iterator();

    }

    @Test(dataProvider = "validContacts" )
    public void testContactCreation(ContactData contact) throws Exception {
        app.contact().returnToContact();

        Contacts before = app.contact().all();

        app.contact().createNewContact();
        File photo = new File("src/test/resources/photo_2021-09-01_07-53-55.jpg");

        /*ContactData contact = new ContactData().
                withName("cont1").
                withLastname("lastname").
                withAddress("address").
                withHomePhone("123").
                withMobPhone("456").
                withWorkPhone("789").
                withEmail1("test@mail.ru").
                withEmail2("test2@mail.ru").
                withEmail3("test3@mail.ru").
                withPhoto(photo);*/

        app.contact().fillNewContact(contact);
        app.contact().submitContactCreation();


        Contacts after = app.contact().all();
        after.add(contact);

        Thread.sleep(2000);
        assertThat(after.size(), equalTo(before.size() + 1));

        assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().max(Comparator.comparingInt(ContactData::getId)).get().getId()))));
    }

}
