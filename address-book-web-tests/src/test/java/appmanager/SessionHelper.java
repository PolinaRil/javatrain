package appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase {
    public WebDriver driver;
    public SessionHelper(WebDriver driver) {
       // this.driver = driver;
        super(driver);
    }
    public void login(String username, String password) {
        type(By.name("user"), username);
        type(By.name("pass"), password);
        submit(By.id("LoginForm"));
    }
}
