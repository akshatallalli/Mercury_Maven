package pom.mercury.tours;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;

public class CrossBrowser_Ex extends ApplicationTestData{
	WebDriver driver;


	@Test(dataProvider="Login")
	public void Sign_On(String userName,String password) {
		driver.get("http://newtours.demoaut.com/mercurywelcome.php");
		driver.findElement(By.linkText("SIGN-ON")).click();
		driver.findElement(By.name("userName")).sendKeys(userName);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("login")).getText();
		driver.findElement(By.name("login")).click();
	}

	@BeforeTest
	@Parameters("browser")
	public void setup(String browser) throws Exception {

		if(browser.equalsIgnoreCase("Chrome"))
		{

			String absolutepath=System.getProperty("user.dir");
			String filepath=absolutepath+"\\Drivers"+"\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", filepath);
			//System.setProperty("webdriver.chrome.driver","C:\\Selenium_Training\\Selenium_Softwares\\workspace(akshata)\\MercuryTours\\chromedriver.exe");
			driver=new ChromeDriver();
			//driver.get("http://newtours.demoaut.com/mercurywelcome.php");
			driver.manage().window().maximize();
		}
		else if(browser.equalsIgnoreCase("IE"))
		{

			String absolutepath=System.getProperty("user.dir");
			String filepath=absolutepath+"\\Drivers"+"\\IEDriverServer.exe";
			System.setProperty("webdriver.ie.driver", filepath);
			//System.setProperty("webdriver.chrome.driver","C:\\Selenium_Training\\Selenium_Softwares\\workspace(akshata)\\MercuryTours\\chromedriver.exe");
			driver=new InternetExplorerDriver();
			//driver.get("http://newtours.demoaut.com/mercurywelcome.php");
			driver.manage().window().maximize();
		}
		else
		{
			throw new Exception("Browser is not correct");
		}
	}

	@AfterTest
	public void CloseBrowser() {
		driver.quit();
	}



}
