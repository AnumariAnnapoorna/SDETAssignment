package testcases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AutifyFreeTrialValidation extends BaseClass {
	@Test(groups="FreeTrial")
	public void freeStartTrialNavigationValidation() {
		
		//Handling PrivacyConsent popup
		home.clickOnAcceptAll();

		//Click on Start Free Trial button
		home.clickOnStartFreeTrial();
		
		//Verify The Title of the Page
		String actualPageTitle=driver.getTitle();
		if(actualPageTitle.contains("Trial")) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
	}
	
	@Test(dependsOnMethods="freeStartTrialNavigationValidation",groups="FreeTrial")
	public void freeStartTrialSignUpValidation() {

		// Click on Sign Up button
		signUp.clickOnSignUp();

		// Wait for Error Messages to load and visible
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions
				.visibilityOfAllElements(signUp.listOfErrors()));

		// Verify the Error Messages
		List<WebElement> error = signUp.listOfErrors();
		Assert.assertEquals(error.get(0).getText(), "First name can't be blank");
		Assert.assertEquals(error.get(1).getText(), "Last name can't be blank");
		Assert.assertEquals(error.get(2).getText(), "Company name can't be blank");
		Assert.assertEquals(error.get(3).getText(), "Company size can't be blank");
		Assert.assertEquals(error.get(4).getText(), "Email can't be blank");
		Assert.assertEquals(error.get(5).getText(), "Password cannot be blank");
		Assert.assertEquals(error.get(6).getText(), "Phone Number can't be blank");
	}
}
