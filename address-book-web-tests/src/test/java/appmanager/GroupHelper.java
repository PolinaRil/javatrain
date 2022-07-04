package appmanager;

import model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GroupHelper {
    public WebDriver driver;

    public GroupHelper(WebDriver driver) {
        this.driver=driver;
    }

    public void returntoGroupPage() {
        driver.findElement(By.linkText("group page")).click();
    }

    public void submitGroupPage() {
        driver.findElement(By.name("submit")).click();
    }

    public void fillGroupPage(GroupData groupData) {
        driver.findElement(By.xpath("//div[@id='content']/form/input[4]")).click();
        driver.findElement(By.name("group_name")).click();
        driver.findElement(By.name("group_name")).click();
        driver.findElement(By.name("group_name")).clear();
        driver.findElement(By.name("group_name")).sendKeys(groupData.name());
        driver.findElement(By.name("group_header")).click();
        driver.findElement(By.name("group_header")).clear();
        driver.findElement(By.name("group_header")).sendKeys(groupData.header());
        driver.findElement(By.name("group_footer")).click();
        driver.findElement(By.name("group_footer")).clear();
        driver.findElement(By.name("group_footer")).sendKeys(groupData.footer());
    }

    public void deleteSelectedGroup() {
      driver.findElement(By.name("delete")).click();
    }

    public void selectGroup() {
      driver.findElement(By.name("selected[]")).click();
    }
}
