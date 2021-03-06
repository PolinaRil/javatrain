package appmanager;

import model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
    public void selectGroup() {
        click(By.name("selected[]"));
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
}
