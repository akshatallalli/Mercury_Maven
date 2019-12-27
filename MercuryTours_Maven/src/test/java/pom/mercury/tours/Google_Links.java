package pom.mercury.tours;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Google_Links {
	
	WebDriver driver;
	
	
  @Test
  public void Sign_On() throws InterruptedException 
  {
	  
	  List<WebElement> linksize = driver.findElements(By.tagName("a"));
	  int linkscount=linksize.size();
	  System.out.println("Total number of links available:"+linkscount);
	 // Thread.sleep(2000);
	  String[] links=new String[linkscount];
	  System.out.println("List of links available:");
	  for (int i=0;i<linkscount;i++)
	  {
		  links[i]=linksize.get(i).getAttribute("href");
		  System.out.println(linksize.get(i).getAttribute("href"));
	  }
	  Thread.sleep(2000);
	  
	  //print all the links from webpage
      for(int i=0;i<linkscount;i++)
      {
    	  driver.navigate().to(links[i]);
      }
      Thread.sleep(2000);
	  
      //navigate to each link on the webpage
      for(int i=0;i<linkscount;i++)
      {
    	  driver.navigate().to(links[i]);
    	  System.out.println(driver.getTitle());
    	  driver.navigate().back();
      }
      Thread.sleep(2000);
      
	  
  }
  @BeforeTest
  public void LaunchBrowser() {
	  System.setProperty("webdriver.chrome.driver","C:\\Selenium_Training\\Selenium_Softwares\\workspace(akshata)\\MercuryTours\\chromedriver.exe");
	    driver=new ChromeDriver();
		//driver.get("https://netbanking.hdfcbank.com/netbanking/");
	    driver.navigate().to("https://www.google.co.in/");
		driver.manage().window().maximize();
	 
  }

  @AfterTest
  public void CloseBrowser() {
	 driver.quit();
  }

}
