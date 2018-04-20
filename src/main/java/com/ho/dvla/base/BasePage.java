package com.ho.dvla.base;

import static com.ho.dvla.base.BaseDriver.getDriver;


import java.util.Properties;

import org.apache.log4j.Logger;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.ho.autotest.common.*;



public class BasePage {
	
    
    static Utility baseUtility = new Utility();   
    static Properties prop = baseUtility.getPropertyObject();
	public static RemoteWebDriver dr = getDriver();
	//public static Vehicle  car = null;
	
	protected final static Logger logger = Logger.getLogger(BasePage.class);




  }

