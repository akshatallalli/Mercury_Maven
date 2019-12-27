package pom.mercury.tours;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Flight_Login_ReadDataFrom_XLS extends ApplicationTestData {
	
	WebDriver driver;
	
	
  @Test(dataProvider="LoginDataXLS")
  public void Sign_On(String uname,String password) {
	  
	    driver.findElement(By.linkText("SIGN-ON")).click();
		driver.findElement(By.name("userName")).sendKeys(uname);
		driver.findElement(By.name("password")).sendKeys(password);
		
		
		driver.findElement(By.name("login")).getText();
		driver.findElement(By.name("login")).click();
		
	   driver.findElement(By.linkText("SIGN-OFF")).click();
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
	  driver.quit();
  }

}
