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


public class DropDown {
	
	WebDriver driver;
	
	
  @Test
  public void Sign_On() throws InterruptedException {
	  driver.findElement(By.linkText("SIGN-ON")).click();
		driver.findElement(By.name("userName")).sendKeys("testing");
		driver.findElement(By.name("password")).sendKeys("testing");
		
		driver.findElement(By.name("login")).getText();
		driver.findElement(By.name("login")).click();
		Thread.sleep(3000);
		
		WebElement radio1=driver.findElement(By.cssSelector("input[value='oneway']"));
		radio1.click();
		
		Select drop1=new Select(driver.findElement(By.name("passCount")));
		drop1.selectByValue("4");
		
		Select drop2=new Select(driver.findElement(By.name("fromPort")));
		drop2.selectByValue("New York");
		
		Select drop3=new Select(driver.findElement(By.name("fromMonth")));
		drop3.selectByValue("2");
		Select drop4=new Select(driver.findElement(By.name("fromDay")));
		drop4.selectByValue("8");
		
		Select drop5=new Select(driver.findElement(By.name("toPort")));
		drop5.selectByValue("Paris");
		
		Select drop6=new Select(driver.findElement(By.name("toMonth")));
		drop6.selectByVisibleText("June");
		
		Select drop7=new Select(driver.findElement(By.name("toDay")));
		drop7.selectByValue("4");
		
		WebElement radio2=driver.findElement(By.xpath("//input[@name='servClass'][2]"));
		radio2.click();
		
		Select airlineobj=new Select(driver.findElement(By.name("airline")));
		airlineobj.selectByVisibleText("Unified Airlines");
		
		driver.findElement(By.name("findFlights")).click();
		
		
		//td[@class='title']//font[contains(text(),'DEPART')]"
		
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
	 // driver.quit();
  }

}
