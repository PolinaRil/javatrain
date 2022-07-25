package model;

import java.util.Objects;

public class GroupData {
private final String id;
private final String name;
private final String header;
private final String footer;


    public  GroupData(String id, String name, String header, String footer){
        this.id = id;
        this.name = name;
        this.header=header;
        this.footer = footer;
        }

    public  GroupData(String name, String header, String footer){
        this.id = null;
        this.name = name;
        this.header=header;
        this.footer = footer;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getHeader() {
        return header;
    }

    public String getFooter() {
        return footer;
    }

    @Override
    public String toString() {
        return "GroupData{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupData groupData = (GroupData) o;
        return id.equals(groupData.id) && name.equals(groupData.name) && Objects.equals(header, groupData.header) && Objects.equals(footer, groupData.footer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
