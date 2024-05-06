package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import BasicSpiceJet.BasicFile;

public class StatusCheckPage extends BasicFile{
	@FindBy (xpath="//div[text()='check-in']")
	WebElement CheckIn;
	@FindBy (xpath="//div[text()='Web Check-In']")
	WebElement WebCheclkIn;
	@FindBy (xpath="//div[text()='flight status']")
	WebElement FlightStatus;
	@FindBy (xpath ="//div[text()='Flight Status']")
	WebElement FStatus;
	@FindBy (xpath ="//div[text()='manage booking']")
	WebElement Booking;
	@FindBy (xpath ="//div[text()='View / Manage Booking']")
	WebElement ManageBooking;
	
	
	
	public  StatusCheckPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public StatusCheckPage status() throws Exception {

		Clickon(CheckIn);
		Assert.assertTrue(WebCheclkIn.isDisplayed(), "Checkin validation failed");
		reportStep("Pass", "Checkin validation", TestName);
		Thread.sleep(2000);

		Clickon(FlightStatus);
		Assert.assertTrue(FStatus.isDisplayed(), "Flight Status validation failed");
		reportStep("Pass", "Flight Status validation", TestName);
		Thread.sleep(2000);

		Clickon(Booking);
		Assert.assertTrue(ManageBooking.isDisplayed(), "Manage Booking validation failed");
		reportStep("Pass", "Manage Booking validation", TestName);
		Thread.sleep(2000);
		return this;
		
	}

}
