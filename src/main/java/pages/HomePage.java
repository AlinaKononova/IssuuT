package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.DriverFactory;

public class HomePage extends MainClass{

  @FindBy(xpath = "//div[@class='ih-Navigation-item']/a")
  WebElement loginButton;

  public HomePage(WebDriver driver) {
    super(driver);
  }

  public HomePage openHomePage(WebDriver wd){
    getUrl("https://issuu.com/");
    return this;
  }

}
