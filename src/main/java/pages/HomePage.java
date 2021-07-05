package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverFactory;

import java.util.List;
import java.util.Set;

public class HomePage extends MainClass{

  @FindBy(xpath = "//div[@class='ih-Navigation-item']/a")
  WebElement loginButton;

  public HomePage(WebDriver driver) {
    super(driver);
  }

  public void wait (WebElement webelement){
    WebDriverWait wait = new WebDriverWait(wd, 10);
    wait.until(ExpectedConditions.visibilityOf(webelement));
  }

  public HomePage openHomePage(WebDriver wd){
    getUrl("https://issuu.com/");
    return this;
  }

}
