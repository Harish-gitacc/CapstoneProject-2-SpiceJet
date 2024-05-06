package Pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import BasicSpiceJet.BasicFile;

public class LoginPage extends BasicFile{
	
	@FindBy (xpath="//div[text()='Login']")
	WebElement LoginButton;
	@FindBy(xpath  ="//input[@data-testid='user-mobileno-input-box']")
	WebElement LoginMobilNo;
	@FindBy(xpath ="//input[@data-testid='password-input-box-cta']")
	WebElement LoginPassword;
	@FindBy(xpath ="//div[@data-testid='login-cta']")
	WebElement ClickLogin;
	@FindBy(xpath ="//div[text()='Hi hari']")
	WebElement LoginBy;

	public  LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this );		
	}
	public LoginPage ClickLogin() {
		ExpliciteWait(LoginButton);
		Clickon(LoginButton);
		return this;
		}
	
	public static boolean booleanValue(WebElement element) {
	    element.getText();
	    return true;
	}
	
	public LoginPage LoginPage(String PhoneNumber,String Password) throws Exception 
	{
		Thread.sleep(3000);
		Type(LoginMobilNo, PhoneNumber);
		Type(LoginPassword, Password);
		Clickon(ClickLogin);
		/*test.log(booleanValue(LoginType) ? Status.PASS : Status.FAIL, 
		         booleanValue(LoginType) ? "Hi hari is visible-Test is Passed" : "Hi hari is invisible-Test is Failed");
	
		return new LoginSFPage(driver);*/
		
		if (booleanValue(LoginBy)) 
		{
			 test.pass("Login is Successful");
		} else {
            test.fail("Login is failure");  
		}		
		return new LoginPage(driver);
	}

}
