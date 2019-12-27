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


public class Following_Preceding_Sibling_xpath {
	
	WebDriver driver;
	
	
  @Test
  public void Sign_On() throws InterruptedException {
	  

	  driver.navigate().to("http://demoaut.com/mercurywelcome.php");
	  driver.findElement(By.xpath("//td[@width='67']//following-sibling::td[1]/a")).click();
	 Thread.sleep(6000);
	  driver.findElement(By.xpath("//td[@width='77']//preceding-sibling::td[1]/a")).click();
	  
	  
  }
  @BeforeTest
  public void LaunchBrowser() {
	  System.setProperty("webdriver.chrome.driver","C:\\Selenium_Training\\Selenium_Softwares\\workspace(akshata)\\MercuryTours\\chromedriver.exe");
	    driver=new ChromeDriver();
		driver.get("http://demoaut.com/mercurywelcome.php");
		driver.manage().window().maximize();
	 
  }

  @AfterTest
  public void CloseBrowser() {
	 // driver.quit();
  }

}
