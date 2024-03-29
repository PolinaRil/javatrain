package model;
import com.google.common.collect.ForwardingSet;
import java.util.HashSet;
import java.util.Set;


public class Contacts extends ForwardingSet<ContactData> {
    private Set<ContactData> delegate;

    public Contacts(Contacts contacts) {
        this.delegate = new HashSet<ContactData>(contacts.delegate);
    }

    @Override
    protected Set<ContactData> delegate() {
        return this.delegate;
    }

    public Contacts withAdded(ContactData contact) {
        Contacts contacts = new Contacts(this);
        contacts.add(contact);
        return contacts;
    }

    public Contacts withoutAdded(ContactData contact) {
        Contacts contacts = new Contacts(this);
        contacts.remove(contact);
        return contacts;
    }
    public Contacts() {
        this.delegate = new HashSet<ContactData>();
    }


}
