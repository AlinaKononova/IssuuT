package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends MainClass{

  public LoginPage(WebDriver driver) {
    super(driver);
  }

  public LoginPage openHomePage(WebDriver wd){
    getUrl("https://issuu.com/");
    return this;
  }

  @FindBy(xpath = "//div[@class='ih-Navigation-item']/a")
  WebElement loginButton;

  public LoginPage clickCTALogin(){
    click(loginButton);
    return this;
  }

  @FindBy(xpath = "//input[@name='email']")
  WebElement email;
  @FindBy(xpath = "//input[@name='password']")
  WebElement password;

  public LoginPage email(String text){
    email.sendKeys(text);
    return this;
  }

  public LoginPage password (String text){
    password.sendKeys(text);
    return this;
  }

  @FindBy(xpath = "//button[@type='submit']")
  WebElement buttonSignIn;

  public LoginPage clickCTASignIn(){
    click(buttonSignIn);
    return this;
  }

  @FindBy(xpath = "//div[@class='ih-Navigation-avatar ih-js-navigation-avatar']")
  WebElement avatar;

  @FindBy(xpath = "//div[@class='ih-DropdownMenu ih-Navigation-item']//a[text()='Log Out']")
  WebElement logout;

  public LoginPage hoverOverAvatar(){
    hoverOver(avatar);
    return this;
  }

  public LoginPage clickCTALogOut(){
    click(logout);
    return this;
  }

}
