package autifyFreeTrialUsingTestNG;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AutifyFreeTrialTesting {
	WebDriver driver;
	@BeforeClass
	public void setUp() {
		// path to the ChromeDriver executable
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Shiva\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");

		// WebDriver Initialization
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Test(groups="FreeTrial")
	public void freeStartTrialNavigationValidation() {
		//Navigate to the Autify NoCode website
		driver.get("https://nocode.autify.com");
		
		//Handling PrivacyConsent popup
		WebElement privacyConsent=driver.findElement(By.xpath("//button[text()='Accept All']"));
		if(privacyConsent.isEnabled())	
			privacyConsent.click();

		//Click on Start Free Trial button
		WebElement startFreeTrialButton=driver.findElement(By.linkText("Start Free Trial"));
		startFreeTrialButton.click();
		
		//Verify The Title of the Page
		String actualPageTitle=driver.getTitle();
		String expectedPageTitle="Trial Application - Autify"
				+ "";
		Assert.assertEquals(actualPageTitle, expectedPageTitle, "Window title does not match!");
	}
	
	@Test(dependsOnMethods="freeStartTrialNavigationValidation",groups="FreeTrial")
	public void freeStartTrialSignUpValidation() {

		// Click on Sign Up button
		driver.findElement(By.xpath("//button[@name='commit']")).click();

		// Wait for Error Messages to load and visible
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.xpath("//span[@class='sc-gsDJrp jXLjZO form-error-message']")));

		// Verify the Error Messages
		List<WebElement> error = driver.findElements(By.xpath("//span[@class='sc-gsDJrp jXLjZO form-error-message']"));
		Assert.assertEquals(error.get(0).getText(), "First name can't be blank");
		Assert.assertEquals(error.get(1).getText(), "Last name can't be blank");
		Assert.assertEquals(error.get(2).getText(), "Company name can't be blank");
		Assert.assertEquals(error.get(3).getText(), "Company size can't be blank");
		Assert.assertEquals(error.get(4).getText(), "Email can't be blank");
		Assert.assertEquals(error.get(5).getText(), "Password cannot be blank");
		Assert.assertEquals(error.get(6).getText(), "Phone Number can't be blank");
	}
	
	@AfterClass
	public void TearDown() {
		driver.quit();
	}
}
