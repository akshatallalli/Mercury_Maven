package pom.mercury.tours;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class SignOn_ReadPropertiesFile {

	WebDriver driver;


	@Test
	public void Sign_On() throws InterruptedException, IOException {

		File file=new File("C:\\Selenium_Training\\Selenium_Softwares\\workspace(akshata)\\MercuryTours_Maven\\Mercury_Tours.properties");
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream(file);
		prop.load(fis);

		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.findElement(By.linkText(prop.getProperty("lsignon"))).click();
		Thread.sleep(3000);
		// driver.findElement(By.linkText("SIGN-ON")).click();
		driver.findElement(By.name(prop.getProperty("lusername"))).sendKeys("testing");
		driver.findElement(By.name(prop.getProperty("Inuserpass"))).sendKeys("testing");

		driver.findElement(By.name("login")).getText();
		driver.findElement(By.name("login")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("SIGN-OFF"));

		/*

		String ExpValue="SIGN-OFF";
		System.out.println(ActValue);
		Assert.assertEquals(ExpValue, ActValue);

		String ExpUrl="http://newtours.demoaut.com/mercuryreservation.php";
		String ActUrl=driver.getCurrentUrl();
		System.out.println(driver.getCurrentUrl());
		Assert.assertEquals(ExpUrl, ActUrl);

		String ExpTitle="Find a Flight: Mercury Tours:";
		String ActTitle=driver.getTitle();
		System.out.println(driver.getTitle());
		Assert.assertEquals(ExpTitle, ActTitle);
        element.click();
		 */


	}
	@BeforeTest
	public void LaunchBrowser() {
		System.setProperty("webdriver.chrome.driver","C:\\Selenium_Training\\Selenium_Softwares\\workspace(akshata)\\MercuryTours\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://newtours.demoaut.com/mercurywelcome.php");
		driver.manage().window().maximize();

	}

	/*
	 * @AfterTest
	 
	public void CloseBrowser() {
		driver.quit();
	}
	*/

}
