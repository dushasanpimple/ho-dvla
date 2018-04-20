package com.ho.dvla.autotest.steps;

import cucumber.api.java.en.Then;

import org.apache.commons.io.FilenameUtils;
import org.junit.Assert;

import com.ho.autotest.model.Vehicle;
import com.ho.dvla.common.Helper;
import com.ho.dvla.common.SeleniumHelpers;
import com.ho.dvla.base.BaseSteps;

import java.util.List;


public class VehicleCheckSteps extends BaseSteps{

	@Then("^I verify all the vehicles in '(.+)' files from the list of files$")
	public void verifyVechiles(String filetype) {
		
		/**
		 * Most of the code from this step can go into helper class
		 */
		String filename = propObj.getProperty(filetype);
		String ext = FilenameUtils.getExtension(filename);
		Assert.assertTrue("File type not supported", utils.isFileSupported(filename));
		service = serviceFactory.getFileService(ext);
		String expCsvFilePath = System.getProperty("user.dir")+"/testdata/"+filename;
		List<Vehicle> vehicleList = service.getList(expCsvFilePath);
		System.out.println(" vehicleList  :"+vehicleList);
		
		checkVehicleDetails(vehicleList);
	}
	
	/**
	 * This method is to just iterate the list and call following steps/methods
	 * @param list
	 */
	public void checkVehicleDetails(List<Vehicle> list)
	{	
		for(Vehicle v:list ){
			vehicle = v;
			SeleniumHelpers.wait(10);
			enterReg();
			SeleniumHelpers.wait(10);
			checkDetails();
		}
		
	}
	
	@Then("^I enter registration number")
	public void enterReg() {
		/**
		 * We can use use back button on Vehicle Details page to start new flow.
		 * As I am iterating list, using URL to start on the registration page 
		 * So hardcoding this URL in BaseStep instead we can get from Properties file.
		 */
		driver.get(url);
		SeleniumHelpers.wait(10);
		SeleniumHelpers.inputText(vehicle.getRegNum(), vehicleEnquiryPage.regTextField);
		SeleniumHelpers.click(vehicleEnquiryPage.continueBtn);
	}
	
	@Then("^I check vehicle details")
	public void checkDetails() 
	{
		System.out.println("REGNUmber :"+vehicleDetailsPage.carReg.getText());
		System.out.println("Make :"+vehicleDetailsPage.make.getText());
		
		/**
		 * We can assert the values. As I need to take screen shot i am using if statement for comparison
		 * and taking screen shot
		 */
		if(vehicle.getMake().trim().equals(vehicleDetailsPage.make.getText().trim())
				&& vehicle.getColour().trim().equals(vehicleDetailsPage.colour.getText().trim()))
		{
				saveFailScreenshotsToFolder(vehicle.getRegNum()+"_Test_Pass");
				vehicle.setResult("PASS");
		}
		else{
			saveFailScreenshotsToFolder(vehicle.getRegNum()+"_Test_Fail");
			vehicle.setResult("FAIL");
		}
		resultList.add(vehicle);
	}
	
	
	@Then("^print out the results to a file$")
	public void printResult() {
		Helper.generateVehicleReport(resultList);
	}

}
