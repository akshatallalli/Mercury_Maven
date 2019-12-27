package pom.mercury.tours;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class RadioButton_Ex {
	
	WebDriver driver;
	
	
  @Test
  public void Sign_On() throws InterruptedException {
	  driver.findElement(By.linkText("SIGN-ON")).click();
		driver.findElement(By.name("userName")).sendKeys("testing");
		driver.findElement(By.name("password")).sendKeys("testing");
		
		driver.findElement(By.name("login")).getText();
		driver.findElement(By.name("login")).click();
		Thread.sleep(3000);
		
//		WebElement radio1=driver.findElement(By.xpath("//input[@value='roundtrip']"));//input[@value='oneway']
//		WebElement radio1=driver.findElement(By.xpath("//input[@value='oneway']"));
//		radio1.click();
//		boolean res=radio1.isSelected();
//		System.out.println(res);

		String str=driver.findElement(By.xpath("//input[@value='roundtrip']")).getAttribute("checked");
		if(str.equalsIgnoreCase("true"))
		{
			System.out.println("Round trip is selected");
			
		}
		
		//WebElement element=driver.findElement(By.xpath("//input[@value='oneway']"));
		//Assert.assertEquals(element.isSelected(), true);
		WebElement element2= driver.findElement(By.cssSelector("input[value='Business']"));
		element2.click();
		boolean res=element2.isSelected();
		System.out.println(res);
		

		
	  
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
