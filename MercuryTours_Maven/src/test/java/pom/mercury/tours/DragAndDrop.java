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


public class DragAndDrop {
	
	WebDriver driver;
	
	
  @Test
  public void Sign_On() throws InterruptedException {
	  
      Actions action =new Actions(driver);
      WebElement drag=driver.findElement(By.id("draggable"));
      WebElement drop=driver.findElement(By.id("droppable"));
      action.dragAndDrop(drag,drop).build().perform();
      
  }
  @BeforeTest
  public void LaunchBrowser() {
	  System.setProperty("webdriver.chrome.driver","C:\\Selenium_Training\\Selenium_Softwares\\workspace(akshata)\\MercuryTours\\chromedriver.exe");
	    driver=new ChromeDriver();
		driver.get("https://jqueryui.com/resources/demos/droppable/default.html");
		driver.manage().window().maximize();
	 
  }

  @AfterTest
  public void CloseBrowser() {
	 // driver.quit();
  }

}
