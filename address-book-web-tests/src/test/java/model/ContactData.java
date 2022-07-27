package model;

import java.util.Objects;

public class ContactData{
    private int id;
    private final    String name;
    private final   String patrname;
    private final String lastname;
    private final String nickname;
    private final  String title;
    private final String company;
    private final  String city;
    private final  String home;
    private final String mobphone;
    private final String position;
    private final String fax;

    public  ContactData (String name, String patrname, String lastname, String nickname, String title, String company,String city, String home, String mobphone, String position, String fax) {
        this.name = name;
        this.patrname = patrname;
        this.lastname = lastname;
        this.nickname = nickname;
        this.title = title;
        this.company = company;
        this.city = city;
        this.home = home;
        this.mobphone = mobphone;
        this.position = position;
        this.fax = fax;
    }

    public ContactData (int id, String name, String patrname, String lastname, String nickname, String title, String company,String city, String home, String mobphone, String position, String fax) {
        this.id = Integer.MAX_VALUE;
        this.name = name;
        this.patrname = patrname;
        this.lastname = lastname;
        this.nickname = nickname;
        this.title = title;
        this.company = company;
        this.city = city;
        this.home = home;
        this.mobphone = mobphone;
        this.position = position;
        this.fax = fax;
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
        return Objects.hash(name, lastname);
    }

    public void setId(int id) {
        this.id = id;
    }
}

