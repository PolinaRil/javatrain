package tests;

import model.ContactData;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.javatrain.addressbook.TestBase;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneTest extends TestBase {

    @Test
    public void testContactPhones() {
        app.contact().returnToContact();

        if (!app.isElementPresent(By.name("selected[]"))) {
            app.contact().createNewContact();
            app.contact().fillNewContact(new ContactData().withName("cont1").withLastname("lastname"));
            app.contact().submitContactCreation();
        }

        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
        assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
    }

    private String mergePhones(ContactData contact) {
       return Arrays.asList(contact.getHomephone(), contact.getMobphone(), contact.getWorkphone())
               .stream().filter((s) -> !s.equals("")).
               map(ContactPhoneTest::cleaned).collect(Collectors.joining("\n"));
    }

    public static String cleaned (String phone) {
        return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
}


}
