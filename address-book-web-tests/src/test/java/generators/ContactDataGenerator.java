package generators;

import model.ContactData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {

    public static void main (String[] args) throws IOException {
        int count = Integer.parseInt(args[0]);
        File file = new File(args[1]);

        List<ContactData> contacts = generateContacts(count);
        save(contacts, file);
    }

    private static void save(List<ContactData> contacts, File file) throws IOException {
        Writer writer = new FileWriter(file);
        for (ContactData contact : contacts) {
            writer.write(String.format("%s;%s;%s;%s;%s;%s;%s;%s;%s\n",
                    contact.getName(),
                    contact.getLastname(),
                    contact.getAddress(),
                    contact.getHomephone(),
                    contact.getMobphone(),
                    contact.getWorkphone(),
                    contact.getEmail1(),
                    contact.getEmail2(),
                    contact.getEmail3()));
        }
        writer.close();
    }

    private static List<ContactData> generateContacts(int count) {
        List<ContactData> contacts = new ArrayList<ContactData>();
        for (int i = 0; i < count; i++) {
            contacts.add(new ContactData()
                    .withName(String.format("name %s", i))
                    .withLastname(String.format("surname %s", i))
                    .withAddress(String.format("address %s", i))
                    .withHomePhone(String.format("123 %s", i))
                    .withMobPhone(String.format("456 %s", i))
                    .withWorkPhone(String.format("789 %s", i))
                    .withEmail1(String.format("test1@mail.ru %s", i))
                    .withEmail2(String.format("test2@mail.ru %s", i))
                    .withEmail3(String.format("test3@mail.ru %s", i)));

        }
        return contacts;
    }

}
