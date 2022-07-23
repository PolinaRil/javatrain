package appmanager;

import model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

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
    public void fillGroupPage(GroupData groupData) {
        driver.findElement(By.name("group_name")).click();
        type(By.name("group_name"), groupData.name());
        type(By.name("group_header"), groupData.header());
        type(By.name("group_footer"), groupData.footer());
    }
    public void deleteSelectedGroup() {
        click(By.name("delete"));
    }
    public void selectGroup(int index) {
        driver.findElements(By.name("selected[]")).get(index).click();
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

    public List<GroupData> getGroupList() {
        List<GroupData> groups = new ArrayList<GroupData>();
        List<WebElement> elements = driver.findElements(By.cssSelector("span.group"));

        for (WebElement element: elements) {
            String name = element.getText();
            GroupData group = new GroupData (name, null, null);
            groups.add(group);
        }

        return groups;
    }
}
