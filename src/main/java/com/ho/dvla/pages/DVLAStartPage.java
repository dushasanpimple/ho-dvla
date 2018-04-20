package com.ho.dvla.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.ho.dvla.base.BasePage;


public class DVLAStartPage extends BasePage
{	
	@FindBy(css="p.get-started a")
	public WebElement startButton;

}
