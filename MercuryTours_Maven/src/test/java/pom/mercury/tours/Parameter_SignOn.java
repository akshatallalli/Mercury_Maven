package pom.mercury.tours;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Parameter_SignOn {
  
	WebDriver driver;
	
	
	  @Test
	  @Parameters({"uname","upass"})
	  public void Sign_On(String uname,String upass) {
		  driver.findElement(By.linkText("SIGN-ON")).click();
			driver.findElement(By.name("userName")).sendKeys(uname);
			driver.findElement(By.name("password")).sendKeys(upass);
			
			driver.findElement(By.name("login")).getText();
			driver.findElement(By.name("login")).click();
			
		  
	  }
	  @BeforeTest
	  public void LaunchBrowser() {
		  System.setProperty("webdriver.chrome.driver","C:\\Selenium_Training\\Selenium_Softwares\\workspace(akshata)\\MercuryTours\\chromedriver.exe");
		    driver=new ChromeDriver();
			driver.get("http://newtours.demoaut.com/mercurywelcome.php");
			driver.manage().window().maximize();
		 
	  }

	  @AfterTest
	  public void CloseBrowser() {
		//  driver.quit();
	  }


}
