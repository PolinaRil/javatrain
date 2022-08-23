package model;

import java.util.Objects;

public class ContactData {
    private int id = Integer.MAX_VALUE;
    private String name;
    private String patrname;
    private String lastname;
    private String nickname;
    private String title;
    private String company;
    private String city;
    private String home;
    private String mobphone;
    private String workphone;
    private String fax;
    private String address;
    private String email1;
    private String email2;
    private String email3;

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

    public String getPatrname() {
        return patrname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getNickname() {
        return nickname;
    }

    public String getTitle() {
        return title;
    }

    public String getCompany() {
        return company;
    }

    public String getCity() {
        return city;
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

    public String getFax() {
        return fax;
    }

    @Override
    public String toString() {
        return "ContactData{" + "id=" + id + ", name='" + name + '\'' + ", lastname='" + lastname + '\'' + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData that = (ContactData) o;
        return Objects.equals(name, that.name) && Objects.equals(lastname, that.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastname);
    }

    public ContactData withId(int id) {
        this.id = id;
        return this;
    }

    public ContactData withName(String name) {
        this.name = name;
        return this;
    }

    public ContactData withPatrname(String patrname) {
        this.patrname = patrname;
        return this;
    }


    public ContactData withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public ContactData withNickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    public ContactData withTitle(String title) {
        this.title = title;
        return this;
    }

    public ContactData withCompany(String company) {
        this.company = company;
        return this;
    }

    public ContactData withCity(String city) {
        this.city = city;
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

    public ContactData withFax(String fax) {
        this.fax = fax;

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
}

