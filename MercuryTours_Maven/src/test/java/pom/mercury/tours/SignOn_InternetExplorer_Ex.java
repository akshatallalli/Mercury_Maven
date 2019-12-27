package pom.mercury.tours;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class SignOn_InternetExplorer_Ex {
	
	WebDriver driver;
	
	
  @Test
  public void Sign_On() throws InterruptedException {
	  driver.findElement(By.linkText("SIGN-ON")).click();
		driver.findElement(By.name("userName")).sendKeys("testing");
		driver.findElement(By.name("password")).sendKeys("testing");
		
		driver.findElement(By.name("login")).getText();
		driver.findElement(By.name("login")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("SIGN-OFF"));
		
	     
		
	  
  }
  @BeforeTest
  public void LaunchBrowser() {
	    System.setProperty("webdriver.ie.driver","C:\\Selenium_Training\\Selenium_Softwares\\IEDriverServer_x64_3.150.1\\IEDriverServer.exe");
	    driver=new InternetExplorerDriver();
		driver.get("http://newtours.demoaut.com/mercurywelcome.php");
		driver.manage().window().maximize();
	 
  }

  @AfterTest
  public void CloseBrowser() {
	  driver.quit();
  }

}
