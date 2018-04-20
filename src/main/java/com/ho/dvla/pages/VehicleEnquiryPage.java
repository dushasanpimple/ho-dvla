package com.ho.dvla.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.ho.dvla.base.BasePage;


public class VehicleEnquiryPage extends BasePage {
	


	@FindBy(css=".heading-large")
	public WebElement vehicleEnquiryPageHeading;
	
	@FindBy(id="Vrm")
	public WebElement regTextField;
	
	
	@FindBy(css=".button")
	public WebElement continueBtn;

}
