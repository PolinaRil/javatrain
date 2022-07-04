package appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper {
    public WebDriver driver;

    public NavigationHelper(WebDriver driver) {
       this.driver=driver;

    }

    public void gotoGroupPage() {
    driver.findElement(By.linkText("groups")).click();
  }
}
