package com.mystore.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;

import com.mystore.actiondriver.Action;

public class BaseClass {
	
	public static Properties prop;
	public static ThreadLocal<RemoteWebDriver> driver=new ThreadLocal<>();
	
	public static WebDriver getDriver() {
		return driver.get();
	}
	//public static WebDriver driver;
	
	@BeforeTest
	public void loadConfig() {
		

		try {
			prop = new Properties();
			System.out.println("Super constructor invoked");
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "\\Configuration\\Config.properties");
			prop.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void launchApp() {
		//WebDriverManager.chromedriver().setup();
		String browserName = prop.getProperty("browser");
		
		if (browserName.equalsIgnoreCase("Chrome")) {
			driver.set(new ChromeDriver());
		}else if (browserName.equalsIgnoreCase("Firefox")) {
			driver.set(new FirefoxDriver());
		}else if (browserName.equalsIgnoreCase("Edge")) {
			driver.set(new EdgeDriver());
		}
		Action.implicitWait(getDriver(), 10);
		Action.pageLoadTimeOut(getDriver(), 30);
		getDriver().manage().window().maximize();
		getDriver().get(prop.getProperty("url"));
		
	}
	
	@AfterMethod
	public void teardown() {
		getDriver().close();
		//driver.quit();
		
	}
}
