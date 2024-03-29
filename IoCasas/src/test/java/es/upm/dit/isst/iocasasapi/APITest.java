package es.upm.dit.isst.iocasasapi;

// Generated by Selenium IDE
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
public class APITest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
    System.setProperty( "webdriver.chrome.driver", "/chromedriver.exe");
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void aPI() {
    driver.get("http://localhost:8083/");
    driver.manage().window().setSize(new Dimension(1296, 696));
    driver.findElement(By.id("username")).click();
    driver.findElement(By.id("username")).sendKeys("prop1@email.com");
    driver.findElement(By.name("contrasena")).sendKeys("prop1");
    driver.findElement(By.name("contrasena")).sendKeys(Keys.ENTER);
    driver.findElement(By.linkText("prop1@email.com")).click();
    {
      WebElement element = driver.findElement(By.linkText("prop1@email.com"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    {
      WebElement element = driver.findElement(By.tagName("body"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element, 0, 0).perform();
    }
    driver.findElement(By.cssSelector(".dropdown > .botonLog:nth-child(1)")).click();
    driver.findElement(By.cssSelector(".formLogin:nth-child(2)")).click();
    driver.findElement(By.id("username")).clear();
    driver.findElement(By.name("contrasena")).clear();
    driver.findElement(By.id("username")).sendKeys("inq1@email.com");
    driver.findElement(By.cssSelector("form")).click();
    driver.findElement(By.name("contrasena")).sendKeys("inq1");
    driver.findElement(By.cssSelector(".botonLog")).click();
    {
      WebElement element = driver.findElement(By.cssSelector("div:nth-child(2) > a > .botonLog"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    {
      WebElement element = driver.findElement(By.tagName("body"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element, 0, 0).perform();
    }
    driver.findElement(By.cssSelector("tr:nth-child(1) > td > .botonLog")).click();
    driver.findElement(By.cssSelector("tr:nth-child(1) img:nth-child(1)")).click();
    driver.findElement(By.cssSelector("tr:nth-child(2) > td > .botonLog")).click();
    driver.findElement(By.linkText("inq1@email.com")).click();
    driver.findElement(By.cssSelector(".dropdown > .botonLog:nth-child(1)")).click();
  }
}
