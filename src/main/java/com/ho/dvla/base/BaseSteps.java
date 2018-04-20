package com.ho.dvla.base;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;




import com.ho.dvla.pages.*;
import com.ho.autotest.common.*;
import com.ho.autotest.model.Vehicle;
import com.ho.autotest.service.FileService;
import com.ho.autotest.service.FileServiceFactory;

import static com.ho.dvla.base.BaseDriver.getDriver;

public class BaseSteps 
{


	
	protected static BasePage basePage=new BasePage();;
	protected static VehicleEnquiryPage vehicleEnquiryPage = new VehicleEnquiryPage();;
	protected static VehicleDetailsPage vehicleDetailsPage = new VehicleDetailsPage ();;
	protected static DVLAStartPage startPage = new DVLAStartPage();
	protected static Utility utils = new Utility();
	protected static Properties propObj = utils.loadProperties("testconfig.properties");
	protected static int totalcar=0; 
	protected static int incorrectDetails=0;
	protected static WebDriver driver;
	protected static FileService service;
	protected static Vehicle vehicle = null;
	protected static FileServiceFactory serviceFactory = utils.getServiceFactory();
	
	protected static String url = "https://vehicleenquiry.service.gov.uk/ViewVehicle";
	protected static List<Vehicle> resultList = new ArrayList<Vehicle>();
	
	
	
	
	
	public BaseSteps(){
			driver = getDriver();
        	initializePageFactory();
	} 
	

	
	public void initializePageFactory()
	{
		startPage = PageFactory.initElements(driver, DVLAStartPage.class);
		vehicleEnquiryPage = PageFactory.initElements(driver, VehicleEnquiryPage.class);
		vehicleDetailsPage = PageFactory.initElements(driver, VehicleDetailsPage.class);
	}
	

    public File saveFailScreenshotsToFolder(String name)
    {
    	String folderDestination = utils.createTestFolder(System.getProperty("user.dir")+"/screenshots/"+utils.getTodayDate());
    	String imagePath = "/"+name+".png";
    
    	File destination = null;
		try{
			File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			destination = new File(folderDestination+imagePath);
			FileUtils.copyFile(source, destination);   
		}
		catch(IOException ioe){
			ioe.printStackTrace();
		}
		return destination;
    }	

}
