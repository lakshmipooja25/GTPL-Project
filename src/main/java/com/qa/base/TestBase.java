package com.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ooxml.POIXMLProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.qa.util.Utility;
import com.qa.util.WebDriverListener;


public class TestBase {

	//public static WebDriver driver;
	public static ChromeDriver driver;
	public  static Properties prop;
	WebDriverListener WebDriverListenerobj;
	EventFiringWebDriver e_driver;
	public TestBase() {
	 prop = new Properties();
	FileInputStream fis;
	try {
		fis = new FileInputStream("C:\\Users\\user\\eclipse-workspace\\GTPLBankTest\\src\\main\\java\\com\\qa\\config\\config.properties");
		prop.load(fis);
	} catch (FileNotFoundException e) {
		
		e.printStackTrace();
		}
	
	 catch (IOException e) {
		
		e.printStackTrace();
	 	}
	}
	
	public  void initialisation() 
	{
		if(prop.getProperty("browser").equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "E:\\LAKSH\\Selenium\\Selenium Library\\Selenium Drivers\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addExtensions(new File("E:\\LAKSH\\Selenium\\Selenium Library\\AD Blocker\\AdBlock.crx")); 
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			options.merge(capabilities);
			driver = new ChromeDriver(options);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			//driver.manage().deleteAllCookies();
			String mainwindow=driver.getWindowHandle();
			System.out.println(mainwindow);
			driver.manage().window().maximize();
			
			Set <String> allwindows = driver.getWindowHandles();
			
			Iterator<String> i1=allwindows.iterator();
			String s1=i1.next();
			String s2=i1.next();
			System.out.println(s1);
			System.out.println(s2);
			driver.switchTo().window(s2);
			
			driver.close();
			driver.switchTo().window(s1);
			
			driver.get(prop.getProperty("url"));
			
			
		
		}
		else if (prop.getProperty("browser").equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "D:\\LAKSH\\Selenium\\Selenium Library\\Selenium Drivers\\geckodriver.exe");
			WebDriver driver=new FirefoxDriver();
			driver.get(prop.getProperty("url"));
			
		}
		
		/*e_driver = new EventFiringWebDriver(driver);
		WebDriverListenerobj = new WebDriverListener();
		e_driver.register(WebDriverListenerobj);
		driver=e_driver;
		*/
		
		//Utility.switchToFrame();
		System.out.println("The GTPL Bank Test Home Page is launched successfully ");
		
	}
}