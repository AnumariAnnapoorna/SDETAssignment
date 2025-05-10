package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import pages.AutifyHomePage;
import pages.AutifySignUpPage;

public class BaseClass {
	WebDriver driver;
	AutifyHomePage home;
	AutifySignUpPage signUp;
	
	@BeforeClass
	public void setUp() {
		// path to the ChromeDriver executable
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Shiva\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");

		// WebDriver Initialization
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		home=new AutifyHomePage(driver);
		signUp=new AutifySignUpPage(driver);
		driver.get("https://nocode.autify.com");
	}
	
	@AfterClass
	public void TearDown() {
		driver.quit();
	}
}
