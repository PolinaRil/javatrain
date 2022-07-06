package appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase{
    public WebDriver driver;

    public NavigationHelper(WebDriver driver) {
      // this.driver=driver;
        super(driver);

    }

    public void gotoGroupPage() {
    click(By.linkText("groups"));
  }
}
