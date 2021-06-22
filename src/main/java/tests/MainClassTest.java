package tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utils.DriverFactory;

import java.util.concurrent.TimeUnit;

public class MainClassTest extends DriverFactory {
  @BeforeTest
  public void setUp() {
    wd = setBrowser("chrome");
    wd.manage().deleteAllCookies();
    wd.manage().window().maximize();
    wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }
  @AfterTest
  public void quit () {
    wd.quit();
  }
}
