package com.ho.dvla.base;

import io.github.bonigarcia.wdm.ChromeDriverManager;


import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.service.DriverService;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import com.ho.autotest.common.*;

public class BaseDriver extends EventFiringWebDriver {	
	private static String directory = System.getProperty("user.dir");
	private static String driverPath = directory+"/_drivers/";
	private static RemoteWebDriver _driver;
	private static DesiredCapabilities _capabilities;
	private static DriverService _service;
	
	private static String chrome = "chromedriver";
	private static String firefox = "geckodriver";
    
    static Utility baseUtility = new Utility();  
    static Properties prop = baseUtility.getPropertyObject();
    private static String platform = prop.getProperty("platform");
    public static final String browser = prop.getProperty ("browser");
    private static String incognito = prop.getProperty("incognito");
    public static final String URL = prop.getProperty("browserStack_URL");

    	static
    	{
			switch (browser.toLowerCase()){
				case "chrome":
					setWebDriverToChrome();
					break;
				case "firefox":
					setWebDriverToFirefox();
					break;		
			}
    	}
    	
    	 public static void setWebDriverToFirefox()
    	 {
              
    	 }                
              
    	public static void setWebDriverToChrome()
    	{
    		_driver = (RemoteWebDriver)createChromeDriver(); 
    	}  
		   
	   	  
	   public BaseDriver() {
	    	super(getDriver());
		    //super(_driver);
	        _driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        _driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

	    }	


	   	
	    public static RemoteWebDriver getDriver() 
	    {
	        return _driver;
	    }
	    
		private static WebDriver createChromeDriver() {
			ChromeDriverManager.getInstance().setup();
			ChromeOptions chromeOptions = new ChromeOptions();
			// incse we get any
			chromeOptions.addArguments("ignore-certificate-errors");
			chromeOptions.addArguments("disable-infobars");
			return new ChromeDriver(chromeOptions);

		}
	    
    }


