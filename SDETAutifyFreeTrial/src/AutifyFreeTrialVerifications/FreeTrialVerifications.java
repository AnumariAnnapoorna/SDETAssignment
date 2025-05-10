package AutifyFreeTrialVerifications;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FreeTrialVerifications {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;	
		//path to the ChromeDriver executable
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Shiva\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
		
		//WebDriver Initialization
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		try {
			//Navigate to the Autify NoCode website
			driver.get("https://nocode.autify.com");
		
			Thread.sleep(5000);
			System.out.println(driver.getTitle());
			
			//Handling PrivacyConsent popup
			WebElement privacyConsent=driver.findElement(By.xpath("//button[text()='Accept All']"));
			if(privacyConsent.isEnabled())	
				privacyConsent.click();
	
			//Click on Start Free Trial button
			driver.findElement(By.linkText("Start Free Trial")).click();
			
			//Verify that new tab is opened 
			//Note: On Clicking Start Free Trial button the Sign up page is loading on same tab so not verifying this step
			
			//Verify The Title of the Page
			String actualPageTitle=driver.getTitle();
			String expectedPageTitle="Trial";
			if(actualPageTitle.contains(expectedPageTitle))
				System.out.println("The Expected Free Trial Page was loaded and Verified Title of the page");
			else
				System.out.println("The Expected Free Trial Page was not loaded, please check");
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			driver.quit();
		}
				
		

	}
}
