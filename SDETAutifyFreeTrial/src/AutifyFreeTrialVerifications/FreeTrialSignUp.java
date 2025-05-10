package AutifyFreeTrialVerifications;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FreeTrialSignUp {

	public static void main(String[] args) {
		//path to the ChromeDriver executable
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Shiva\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
		
		//WebDriver Initialization
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		try {
			//Navigate to the Autify NoCode website
			driver.get("https://nocode.autify.com");
			
			//Handling PrivacyConsent popup
			WebElement privacyConsent=driver.findElement(By.xpath("//button[text()='Accept All']"));
			if(privacyConsent.isEnabled())	
				privacyConsent.click();

			//Click on Start Free Trial button
			WebElement startFreeTrialButton=driver.findElement(By.linkText("Start Free Trial"));
			startFreeTrialButton.click();
		
			//Verify that new tab is opened 
			//Note: On Clicking Start Free Trial button the Sign up page is loading on same tab so not verifying this step
			
			//Verify The Title of the Page
			String actualPageTitle=driver.getTitle();
			String expectedPageTitle="Trial";
			if(actualPageTitle.contains(expectedPageTitle))
				System.out.println("The Expected Free Trial Page was loaded and Verified Title of the page");
			else
				System.out.println("The Expected Free Trial Page was not loaded, please check");
			
			//Click on Sign Up button
			driver.findElement(By.xpath("//button[@name='commit']")).click();
		
			//Wait for Error Messages to load and visible
			WebDriverWait wait=new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[@class='sc-gsDJrp jXLjZO form-error-message']")));
			
			//Verify the Error Messages
			List<WebElement> error=driver.findElements(By.xpath("//span[@class='sc-gsDJrp jXLjZO form-error-message']"));
			for(WebElement ele: error) {
				if(ele.isDisplayed())
					System.out.println("Error Message was displayed : "+ele.getText());
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			driver.quit();
		}
	}

}
