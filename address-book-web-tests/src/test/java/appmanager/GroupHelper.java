package appmanager;

import model.GroupData;
import model.Groups;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GroupHelper extends HelperBase {
    public GroupHelper(WebDriver driver) {
        super(driver);
    }
    public void returntoGroupPage() {
        click(By.linkText("group page"));
    }
    public void submitGroupPage() {
        click(By.name("submit"));
    }
    public void create(GroupData groupData) {
        driver.findElement(By.name("group_name")).click();
        type(By.name("group_name"), groupData.getName());
        type(By.name("group_header"), groupData.getHeader());
        type(By.name("group_footer"), groupData.getFooter());
    }

    public void modifyGroup(GroupData group) {
        create(group);
        submitGroupModification();
        returntoGroupPage();
    }
    public void deleteSelectedGroup() {
        click(By.name("delete"));
    }

    public void selectGroupById(int id) {
        driver.findElement(By.cssSelector("input[value='" + id + "']")).click();
    }
    public void editGroup() {
        click(By.name ("edit"));
    }
    public void submitGroupModification() {
        click(By.name ("update"));
    }
    public void initGroupModification() {
        click(By.name ("new"));
    }

    public int getGroupCount() {
        return   driver.findElements(By.name("selected[]")).size();
    }

    public Groups all() {
        Groups groups = new Groups();
        List<WebElement> elements = driver.findElements(By.cssSelector("span.group"));

        for (WebElement element: elements) {
            String name = element.getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            groups.add(new GroupData().withId(id).withName(name));
        }

        System.out.println(groups);
        System.out.println(groups.size());

        return groups;
    }

    public void delete(GroupData group) {
        selectGroupById(group.getId());
        deleteSelectedGroup();
        returntoGroupPage();
    }
}
