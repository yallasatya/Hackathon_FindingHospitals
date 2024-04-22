package stepDefinitionFiles;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import POM_files.Doctors;
import POM_files.HomePage;
import POM_files.Surgeries;
import Utilities.ExcelUtils;
import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GettingSurgeriesList {
	WebDriver driver;
	Properties properties;
	Logger logger;
	HomePage homePOM;
	SoftAssert sa;
	Doctors doctorsPOM;
	Surgeries surgeriesPOM;
	JavascriptExecutor js;
	
	@When("surgeries is clicked")
	public void surgeries_is_clicked() throws InterruptedException 
	{
		driver = Hooks.getDriver();
		logger = Hooks.getLogger();
		
		logger.info("Navigating to the surgeries page");
		
		boolean flag = doctorsPOM.surgeriesClick();
		logger.info("Clicked on Surgeries");
		Assert.assertTrue(flag);
		
//		js = (JavascriptExecutor)driver;
//		doctorsPOM.surgeriesClick(js);
//		Assert.assertTrue(true);
	}

	@Then("the surgeries list should be shown and list has to be retrieved")
	public void the_surgeries_list_should_be_shown_and_list_has_to_be_retrieved() throws IOException, InterruptedException {

		//Getting the Surgeries List
	
		logger.info("scrolling down to the surgeries");
		js = (JavascriptExecutor)driver;
		surgeriesPOM.scrollDown(js);
		
		TimeUnit.SECONDS.sleep(3);
		
		String[] surgeriesList = surgeriesPOM.surgeriesList();
		
		if(surgeriesList == null) {
			Assert.fail();
		}
		else {
			Assert.assertTrue(true);;
		}
				
		TimeUnit.SECONDS.sleep(3);
	}



}
