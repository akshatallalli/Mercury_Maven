package pom.mercury.tours;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class ScreenShot_log {
	
	WebDriver driver;
	
	  @Test
	  public void newtoursScreenshot() throws InterruptedException {
		  driver.findElement(By.linkText("SIGN-ON")).click();
			driver.findElement(By.name("userName")).sendKeys("testing");
			driver.findElement(By.name("password")).sendKeys("testing");
			
			driver.findElement(By.name("login")).getText();
			driver.findElement(By.name("logins")).click();
			Thread.sleep(3000);
			WebElement element=driver.findElement(By.linkText("SIGN-OFF"));
			element.click();
	  }
	  
	   @AfterMethod
	   public void teardown(ITestResult result) throws IOException
	   {
		   if(ITestResult.FAILURE==result.getStatus())
		   {
			   File Browserscreenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			   FileUtils.copyFile(Browserscreenshot, new File("C:\\Selenium_Training\\Selenium_Softwares\\workspace(akshata)\\MercuryTours_Maven\\Screenshot\\Login.png"));
			   //FileUtils.copyFile(Browserscreenshot, new File(filePath+"/"result.getName()+"-"+System.nanoTime()+".png"));
			   
		   }
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
