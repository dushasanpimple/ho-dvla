package com.ho.dvla.common;

import static com.ho.dvla.base.BaseDriver.getDriver;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;


public class SeleniumHelpers extends EventFiringWebDriver {

	
	static RemoteWebDriver driver = getDriver();
	
	public SeleniumHelpers(){
		super(driver);
	}
	
	
	
    /**
     * Finds an input element containing the specified text using either
     * name or id attribute value.
     * @param text
     * @return
     */
	protected WebElement inputField(String text){
		try{
			return driver.findElement(By.xpath("//input[contains(@name,'"+text+"']"));
		}catch(java.util.NoSuchElementException err){
			WebElement tagName = driver.findElement(By.tagName("input"));
			
			if(tagName.getAttribute("id").contains(text)){
				return tagName;
				}else{
					throw err;
			
			}
		}
	}
	
    /*
     * Acts as a place holder for entering value into an input element
     * @param input
     * @return
     */
	protected static WebElement inTo(WebElement input){
		return input;
	}
	
    /**
     * Types a text value into an input field.
     * Note: to ensure transparency, initial value is cleared.
     * @param value
     * @param input
     */
    public static void inputText(String value, WebElement input) {
    	
    	if(input.getText()!=null){
    		input.clear();
    	}     
        inTo(input).sendKeys(value);
    }
         
    
    public static void click(final WebElement element) {
        waitUntilVisibilityOfElement(element).click();
    }
    
   
   private static Wait<RemoteWebDriver> fluentWait() {
       return new FluentWait<>(driver)
               .withTimeout(15, TimeUnit.SECONDS)
               .pollingEvery(1, TimeUnit.SECONDS)
               .ignoring(NoSuchElementException.class)
               .ignoring(StaleElementReferenceException.class);            
   }
   
   private static WebElement waitUntilVisibilityOfElement(final WebElement element) {
       return fluentWait().until(ExpectedConditions.elementToBeClickable(element));
   }
   
	public static void wait(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}





