package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class SignupPage extends MainClass {
  public SignupPage(WebDriver driver) {
    super(driver);
  }

  public SignupPage openHomePage(WebDriver wd){
    getUrl("https://issuu.com/");
    return this;
  }

  @FindBy(xpath = "//a[@href=\'/pricing?issuu_product=header&issuu_subproduct=anon_home&issuu_context=link&issuu_cta=try\']")
  WebElement tryNow;

  public SignupPage clickCtaTryNow(){
    click(tryNow);
    return this;
  }

  @FindBy(xpath = "//div/table/tbody/tr[1]/td[2]/div/a[@title='Sign up for the Issuu Basic plan']")
  WebElement getStartedFree;

  public SignupPage getStartedFree(){
    click(getStartedFree);
    return this;
  }

  @FindBy(xpath = "//input[@name='firstName']")
  WebElement firstName;

  @FindBy(xpath = "//input[@name='lastName']")
  WebElement lastName;

  @FindBy(xpath = "//input[@name='email']")
  WebElement email;

  @FindBy(xpath = "//input[@name='password']")
  WebElement password;

  @FindBy(xpath = "//input[@name='username']")
  WebElement username;

  public SignupPage firstName(String text){
    firstName.sendKeys(text);
    return this;
  }

  public SignupPage lastName(String text){
   lastName.sendKeys(text);
   return this;
  }

  public SignupPage email(String text){
    email.sendKeys(text);
    return this;
  }

  public SignupPage password(String text){
    password.sendKeys(text);
    return this;
  }

  public SignupPage username(String text){
    username.sendKeys(text);
    return this;
  }

  @FindBy(xpath = "//input[@type='checkbox']")
  WebElement checkbox;

  public SignupPage clickCheckbox(){
    click(checkbox);
    return this;
  }

  @FindBy(xpath = "//button[@type='submit']")
  WebElement buttonSignUp;

  public SignupPage clickCTAButtonSignUp() {
    click(buttonSignUp);
    return this;
  }

  public boolean isSighUpVisible(){
    return buttonSignUp.isDisplayed();
  }

  public String getVerificationCode(){
    String code = new GetLinkFromEmail().getBodyFromEmail();
    //System.out.println(":888" + code);
    //getUrl(code);
    return code;
  }

  @FindBy(xpath = "//input[@name='validateCode']")
  WebElement code;

  public SignupPage insertCode(String text){
    code.sendKeys(text);
    return this;
  }

  @FindBy(xpath = "//button[@type='button']")
  WebElement buttonValidate;

  public SignupPage clickCTAValidate(){
    click(buttonValidate);
    return this;
  }

  public SignupPage sleep(Integer time){
    try {
      TimeUnit.SECONDS.sleep(time);
    }catch (Exception e){
      System.err.println("Err");
    }
    return this;
  }

}