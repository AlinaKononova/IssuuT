package tests;

import org.testng.annotations.Test;
import pages.SignupPage;

public class SignupPageTest extends MainClassTest{

  @Test
  public void signUptest(){
    String firstName = "alinatest";
    String lastName = "kontest";
    String email = "test.job.ak@gmail.com";
    String password = "Asd_asd!1";
    String username = "alikontest123";
    SignupPage signUp = new SignupPage(wd);
    String code;
    signUp.openHomePage(wd)
            .clickCtaTryNow()
            .getStartedFree()
            .firstName(firstName)
            .lastName(lastName)
            .email(email)
            .password(password)
            .username(username)
            .sleep(5)
            .clickCheckbox()
            .clickCTAButtonSignUp()
            .sleep(90);
    boolean isVisible = signUp.isSighUpVisible();
    if(isVisible == true) {
      signUp.clickCTAButtonSignUp();
    }
    signUp.sleep(60);
    code = signUp.getVerificationCode();
    signUp.insertCode(code)
            .clickCTAValidate();
  }
}
