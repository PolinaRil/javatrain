package model;

import java.util.Objects;

public class ContactData{
    private int id = Integer.MAX_VALUE;
    private String name;
    private  String patrname;
    private  String lastname;
    private  String nickname;
    private   String title;
    private  String company;
    private   String city;
    private   String home;
    private  String mobphone;
    private  String position;
    private  String fax;

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

    public String getHome() {
        return home;
    }

    public String getMobphone() {
        return mobphone;
    }

    public String getPosition() {
        return position;
    }

    public String getFax() {
        return fax;
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
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

    public ContactData withHome(String home) {
        this.home = home;
        return this;
    }

    public ContactData withMobphone(String mobphone) {
        this.mobphone = mobphone;
        return this;
    }

    public ContactData withPosition(String position) {
        this.position = position;
        return this;
    }

    public ContactData withFax(String fax) {
        this.fax = fax;
        return this;
    }
}

