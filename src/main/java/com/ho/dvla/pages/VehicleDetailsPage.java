package com.ho.dvla.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.ho.dvla.base.BasePage;

public class VehicleDetailsPage extends BasePage {
	
	@FindBy(css=".reg-mark")
	public WebElement carReg;
	
	@FindBy(css="ul.list-summary > li:nth-of-type(2) > span:nth-child(2)")
	public WebElement make;	

	@FindBy(css="ul.list-summary > li:nth-of-type(3) > span:nth-child(2)")
	public WebElement colour;
	
	@FindBy(css=".back-to-previous")
	public WebElement back;
		
	
}
