package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverFactory;

public class MainClass extends DriverFactory {
  public MainClass(WebDriver driver){
    this.wd = driver;
    PageFactory.initElements(driver, this);
  }

  public void waitDisplayedBy(WebElement webelement){
    WebDriverWait wait = new WebDriverWait(wd, 10);
    wait.until(ExpectedConditions.visibilityOf(webelement));
  }

  public void getUrl(String URL){
    wd.get(URL);
  }

  public void click(WebElement element){
    element.click();
  }

  public void type(WebElement element, String text){
    element.sendKeys(text);
  }

  public void tapEnter(WebElement element){
    element.sendKeys(Keys.ENTER);
  }

  public void hoverOver(WebElement element){
    Actions mouseOver = new Actions(wd);
    mouseOver.moveToElement(element).build().perform();
  }
}
