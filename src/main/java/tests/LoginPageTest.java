package tests;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginPageTest extends MainClassTest{

  @Test
  public void logInOutTest(){
    String email = "k_filtri@rambler.ru";
    String password = "Asd_asd!1";
    LoginPage logInOutTest = new LoginPage(wd);
    logInOutTest.openHomePage(wd).
            clickCTALogin().
            email(email).
            password(password).
            clickCTASignIn().
            hoverOverAvatar().
            clickCTALogOut();
  }

}
