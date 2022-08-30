package model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import jakarta.persistence.*;
import org.hibernate.annotations.Type;

import java.io.File;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@XStreamAlias("contacts")
@Entity
@Table(name = "addressbook")
public class ContactData {
    @XStreamOmitField
    @Id
    @Column(name = "id")
    private int id = Integer.MAX_VALUE;
    @Column(name = "firstname")
    private String name;
    @Column(name = "lastname")
    private String lastname;
    @Column(name = "home")
    private String home;
    @Column(name = "mobile")
    private String mobphone;
    @Column(name = "work")
    private String workphone;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "address_in_groups",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "group_id"))
    private Set<GroupData> groups = new HashSet<GroupData>();



    @Column(name = "address")
    private String address;
    @Column(name = "email")
    private String email1;
    @Column(name = "email2")
    private String email2;
    @Column(name = "email3")
    private String email3;
    @Column(name = "photo")
    private String photo;
    @Column(name = "created", columnDefinition = "TIMESTAMP")
    private Date created;
    @Column(name = "deprecated", columnDefinition = "TIMESTAMP")
    private Date deprecated;

    public File getPhoto() {
        return new File(photo);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData that = (ContactData) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(lastname, that.lastname) && Objects.equals(home, that.home) && Objects.equals(mobphone, that.mobphone) && Objects.equals(workphone, that.workphone) && Objects.equals(address, that.address) && Objects.equals(email1, that.email1) && Objects.equals(email2, that.email2) && Objects.equals(email3, that.email3) && Objects.equals(created, that.created) && Objects.equals(deprecated, that.deprecated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastname, home, mobphone, workphone, address, email1, email2, email3, created, deprecated);
    }
    public Groups getGroups() {
        return new Groups(groups);
    }
    public String getEmail1() {
        return email1;
    }

    public String getEmail2() {
        return email2;
    }

    public String getEmail3() {
        return email3;
    }

    public String getAddress() {
        return address;
    }

    public String[] getAllPhones() {
        String[] a = new String[3];

        a[0] = home;
        a[1] = mobphone;
        a[2] = workphone;

        return a;
    }

    public String[] getAllEmails() {
        String[] a = new String[3];

        a[0] = email1;
        a[1] = email2;
        a[2] = email3;

        return a;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }


    public String getHomephone() {
        return home;
    }

    public String getMobphone() {
        return mobphone;
    }

    public String getWorkphone() {
        return workphone;
    }


    @Override
    public String toString() {
        return "ContactData{" + "id=" + id + ", name='" + name + '\'' + ", lastname='" + lastname + '\'' + '}';
    }

    public ContactData withId(int id) {
        this.id = id;
        return this;
    }

    public ContactData withName(String name) {
        this.name = name;
        return this;
    }


    public ContactData withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }


    public ContactData withHomePhone(String home) {
        this.home = home;
        return this;
    }

    public ContactData withMobPhone(String mobPhone) {
        this.mobphone = mobPhone;

        return this;
    }

    public ContactData withWorkPhone(String workPhone) {
        this.workphone = workPhone;

        return this;
    }

    public ContactData withAllPhones(String[] phones) {
        this.home = phones[0];
        this.mobphone = phones[1];
        this.workphone = phones[2];

        return this;
    }

    public ContactData withAllEmails(String[] emails) {
        this.email1 = emails[0];
        this.email2 = emails[1];
        this.email3 = emails[2];

        return this;
    }

    public ContactData withAddress(String address) {
        this.address = address;
        return this;
    }

    public ContactData withEmail1(String email1) {
        this.email1 = email1;
        return this;
    }

    public ContactData withEmail2(String email2) {
        this.email2 = email2;
        return this;
    }

    public ContactData withEmail3(String email3) {
        this.email3 = email3;
        return this;
    }

    public ContactData withPhoto(File photo) {
        this.photo = photo.getPath();
        return this;
    }
}