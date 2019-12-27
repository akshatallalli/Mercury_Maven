package pom.mercury.tours;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class NetBankingAssign1 {
	
	WebDriver driver;
	
	
  @Test
  public void Sign_On() throws InterruptedException {
	  
//	  WebElement custidobj=driver.findElement(By.name("fldLoginUserId"));
//	  custidobj.sendKeys("1234567890");
	 
	  driver.switchTo().frame("login_page");
      WebElement ele=driver.findElement(By.xpath("//input[@name='fldLoginUserId']"));
      ele.sendKeys("1234567890");
      WebElement continuebtn=driver.findElement(By.xpath("//img[@alt='continue'][1]"));
      continuebtn.click();
  }
  @BeforeTest
  public void LaunchBrowser() {
	  System.setProperty("webdriver.chrome.driver","C:\\Selenium_Training\\Selenium_Softwares\\workspace(akshata)\\MercuryTours\\chromedriver.exe");
	    driver=new ChromeDriver();
		driver.get("https://netbanking.hdfcbank.com/netbanking/");
		driver.manage().window().maximize();
	 
  }

  @AfterTest
  public void CloseBrowser() {
	 // driver.quit();
  }

}
