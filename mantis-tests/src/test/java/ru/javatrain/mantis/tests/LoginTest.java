package ru.javatrain.mantis.tests;
import org.testng.annotations.Test;
import ru.javatrain.mantis.appmanager.HttpSession;
import java.io.IOException;
import static org.testng.AssertJUnit.assertTrue;

public class LoginTest extends TestBase{
    @Test
    public void testLogin() throws IOException {
        HttpSession session = app.newSession();

        assertTrue(session.login("administrator", "root"));
        assertTrue(session.isLoggedInAs("administrator"));
    }
}
