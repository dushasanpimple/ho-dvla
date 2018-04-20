package com.ho.dvla.autotest.steps;

import com.ho.dvla.base.BaseSteps;
import com.ho.dvla.common.SeleniumHelpers;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

public class CommonStep extends BaseSteps{

	
	@Given("^I navigate to the dvla page$")
	public void navigateToPage() throws Exception {		
		String url = propObj.getProperty("base.url");
		driver.get(url);
	}
	
	@And("^I start the vehicle check$")
	public void startVehicleCheck() throws Exception {		
		SeleniumHelpers.click(startPage.startButton);
	}
}
