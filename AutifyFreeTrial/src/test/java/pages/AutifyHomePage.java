package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AutifyHomePage {

	WebDriver driver;
	public AutifyHomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[text()='Accept All']")
	WebElement privacyConsentAcceptAll;
	
	public void clickOnAcceptAll() {
		if(privacyConsentAcceptAll.isEnabled())	
			privacyConsentAcceptAll.click();
	}
	
	@FindBy(linkText="Start Free Trial")
	WebElement startFreeTrialButton;
	
	public void clickOnStartFreeTrial() {
		startFreeTrialButton.click();
	}
	
}
