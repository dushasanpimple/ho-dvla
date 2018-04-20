package com.ho.dvla.autotest;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.remote.RemoteWebDriver;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import static com.ho.dvla.base.BaseDriver.getDriver;

@RunWith(Cucumber.class)
@CucumberOptions(

					features="src/test/resources/features",
					glue="com.ho.dvla.autotest.steps",
					tags = {"@dvla"},
					plugin = {"html:target/cucumber-html-report", "json:target/cucumber-json-report.json"}					
				)

public class TestRunner 
{

	public static RemoteWebDriver dr = getDriver(); 


   @AfterClass
    public static void tearDown()
    {

        try{
             if(dr != null) 
             {
                 dr.close();
             }
         }
         catch(Exception ex){
                 ex.printStackTrace();
         }
         finally {
             dr.quit();
         }
    }
}


