package pom.mercury.tours;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class MouseHover_Ex {
	
	WebDriver driver;
	
	
  @Test
  public void Sign_On() throws InterruptedException {
	  

      WebElement element=driver.findElement(By.xpath("//a[contains(text(),'My Account')]"));
      Actions action =new Actions(driver);
      action.moveToElement(element).build().perform();
      driver.findElement(By.id("signInBtn")).click();
  }
  @BeforeTest
  public void LaunchBrowser() {
	  System.setProperty("webdriver.chrome.driver","C:\\Selenium_Training\\Selenium_Softwares\\workspace(akshata)\\MercuryTours\\chromedriver.exe");
	    driver=new ChromeDriver();
		driver.get("https://www.yatra.com");
		driver.manage().window().maximize();
	 
  }

  @AfterTest
  public void CloseBrowser() {
	 // driver.quit();
  }

}
