package ru.javatrain.addressbook;

import appmanager.ApplicationManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase {

    protected final ApplicationManager app = new ApplicationManager();

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        app.init();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        app.stop();
      //  String verificationErrorString = verificationErrors.toString();
     //   if (!"".equals(verificationErrorString)) {
      //      fail(verificationErrorString);
       // }
    }

}
