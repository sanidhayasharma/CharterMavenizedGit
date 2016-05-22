package com.test.charter.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.test.charter.utilities.ExcelReader;

public class Base
{
private  WebDriver driver;
private  Properties properties;
private  FileInputStream fis;
private int browser;
private String baseURL;
private ExcelReader reader;


public WebDriver getDriver()
{
	return driver;
}

public void setDriver(int browser , java.lang.String baseURL) throws IOException
{	
	switch(browser)
	{
	case 1:
		driver=initFirefoxDriver(baseURL);
		System.out.println("Firefox is launching");
		System.out.println("GIT Launched.....");
		break;		
		
	case 2:
		driver=initChromeDriver(baseURL);
		System.out.println("Chrome is launching");
		break;
		
	default:
		System.out.println("Selecting Default browser as Firefox");
		driver=initFirefoxDriver(baseURL);
		
	}	
	
}

public int getBrowserDetail(java.lang.String browser)
{
	try
	{
		if(browser.equals("firefox"))
		{
			
			System.out.println("FireFox Driver Selected");
			return 1;
			
		}
		else if(browser.equals("chrome"))
		{
			System.out.println("Chrome Driver Selected");
			return 2;
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
		System.out.println("Browser not Selected");
		
	}
	return 0;	
}

public WebDriver initFirefoxDriver(String baseURL)
{

	driver = new FirefoxDriver();
	driver.manage().timeouts().implicitlyWait(30L, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.navigate().to(baseURL);
	return driver;
		
}
	
public WebDriver initChromeDriver(String baseURL)
{
	driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.navigate().to(baseURL);
	return driver;
}

public void getIntializeProperties() throws IOException
{
	try
	{
	fis = new FileInputStream("D:\\SeleniumStuff\\MavenProject\\CharterMavenized\\src\\test\\java\\com\\test\\charter\\repository\\Configuration.properties");
	properties= new Properties();
	properties.load(fis);
	}
	catch(Exception e)
	{
		e.printStackTrace();
		System.out.println("Properties File not Intialized");
	}
}

public ExcelReader getExcelReader()
{
	try
	{
		reader = new ExcelReader("D:\\SeleniumStuff\\MavenProject\\CharterMavenized\\src\\test\\java\\com\\test\\charter\\repository\\TestData.xlsx");
	}
	catch(Exception e)
	{
		e.printStackTrace();
		System.out.println("Excel was not intialized");
	}
	return reader;
}

@BeforeClass
public void initializeBaseTest()
{
	try
	{
		getIntializeProperties();
		browser=getBrowserDetail(properties.getProperty("browser"));
		baseURL=properties.getProperty("baseURL");
		setDriver(browser, baseURL);
	}
	catch(Exception e)
	{
		e.printStackTrace();
		System.out.println("BaseURL and Browser not Intialized");
	}
}

@AfterClass
public void closeBrowser() throws IOException
{
	try
	{
	TakesScreenshot screen =(TakesScreenshot)driver;
	File source=screen.getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(source, new File("D:\\MavenProject\\CharterMavenized\\Screenshot\\Failed.png"), true);
	driver.quit();
	}
	catch(Exception e)
	{
		e.printStackTrace();
		System.out.println("Unable to close the browser with screen shot");
	}
}



}
