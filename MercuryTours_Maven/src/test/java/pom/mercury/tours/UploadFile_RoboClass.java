package pom.mercury.tours;


import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class UploadFile_RoboClass {
	
	WebDriver driver;
	
	
  @Test
  public void testUpload() throws InterruptedException {
	  driver.get("https://gofile.io/?t=uploadFiles");
	  String absolutePath=System.getProperty("user.dir");
	  //String filePath=absolutePath+"\\Images\\Login.png";
	  String filePath="C:\\Selenium_Training\\Selenium_Softwares\\workspace(akshata)\\MercuryTours_Maven\\Images\\Login.png";
	  System.out.println(filePath);
	  Thread.sleep(6000);
	  driver.navigate().refresh();
	  driver.findElement(By.id("btnChooseFiles")).click();
	  Thread.sleep(5000);
	  uploadFile(filePath);
	  Thread.sleep(1000);
  }
  public static void uploadFile(String fileLocation)
  {
	  try{
		  StringSelection ss=new StringSelection(fileLocation);
		  Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		  Robot robot=new Robot();
		  robot.delay(1000);
		  //press ctrl+v
		  robot.keyPress(KeyEvent.VK_CONTROL);
		  robot.keyPress(KeyEvent.VK_V);
		  robot.delay(1000);
		  //release ctrl+v
		  robot.keyRelease(KeyEvent.VK_CONTROL);
		  robot.keyRelease(KeyEvent.VK_V);
		  //press enter
		  robot.delay(1000);
		  robot.keyPress(KeyEvent.VK_ENTER);
		  robot.keyRelease(KeyEvent.VK_ENTER);
		  robot.delay(1000);
	  }
	  catch (Exception e)
	  {
		  e.printStackTrace();
		  
	  }
		
	  
  }
  @BeforeTest
  public void LaunchBrowser() {
	  System.setProperty("webdriver.chrome.driver","C:\\Selenium_Training\\Selenium_Softwares\\workspace(akshata)\\MercuryTours\\chromedriver.exe");
	    driver=new ChromeDriver();
		//driver.get("http://newtours.demoaut.com/mercurywelcome.php");
		driver.manage().window().maximize();
	 
  }

  @AfterTest
  public void CloseBrowser() {
	  driver.quit();
  }

}
