package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AutifySignUpPage {

	WebDriver driver;
	public AutifySignUpPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[@name='commit']")
	WebElement signUpButton;
	
	public void clickOnSignUp() {
		signUpButton.click();
	}
	
	@FindBy(xpath="//span[@class='sc-gsDJrp jXLjZO form-error-message']")
	List<WebElement> errorMsgs;
	
	public List<WebElement> listOfErrors(){
		return errorMsgs;
	}
}
