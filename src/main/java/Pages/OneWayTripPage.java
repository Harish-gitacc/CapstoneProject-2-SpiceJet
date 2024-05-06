package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BasicSpiceJet.BasicFile;

public class OneWayTripPage extends BasicFile {
	@FindBy(xpath = "//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[3]/div/div[1]/div/div[2]/input")
	WebElement From;

	@FindBy(xpath = "//div[@class='css-1dbjc4n r-b5h31w r-95jzfe']//div[text()='MAA']")
	WebElement To;

	@FindBy(xpath = "//div[@data-testid='departure-date-dropdown-label-test-id']")
	WebElement Date;

	@FindBy(xpath = "//div[@data-testid='undefined-month-May-2024']//div[@data-testid='undefined-calendar-day-25']")
	WebElement SelectDate;

	@FindBy(xpath = "//div[text()='Passengers']")
	WebElement Passenger;

	@FindBy(xpath = " //div[text()='Done']")
	WebElement Passengerdone;

	@FindBy(xpath = "//div[contains(text(),'Currency')]")
	WebElement currency;

	@FindBy(xpath = "//div[contains(text(),'INR')]")
	WebElement Selectcurrency;

	@FindBy(xpath="//div[@class='css-1dbjc4n r-1niwhzg r-1p0dtai r-1d2f490 r-1udh08x r-u8s1d r-zchlnj r-ipm5af']")//(xpath = "//div[contains(text(),'Search Flight')]")
	WebElement SearchFlight;

	@FindBy(xpath = "//div[@class='css-76zvg2 r-jwli3a r-1i10wst r-1kfrs79']")
	WebElement Next;
	                                                                              
	@FindBy(xpath = "//div[normalize-space(@class)='css-76zvg2 r-jwli3a r-1i10wst r-1kfrs79']")  
	WebElement ClickNext; 
	
	


	public OneWayTripPage(WebDriver driver) {
		this.driver = driver;
	
	PageFactory.initElements(driver, this);
	 
	}
	public RoundWayTripPage Ticketbooking(String start) throws InterruptedException {

		Type(From, start);
		Clickon(To);
		ExpliciteWait(Date);
		Clickon(Date);
		Clickon(Date);
		Clickon(SelectDate);
		 Actions  act = new Actions(driver);
	     act.click(SearchFlight).perform();
	     Thread.sleep(5000);
	     Actions  act1 = new Actions(driver);
	     act1.click(ClickNext).perform();
		
	//	Clickon(ClickNext);
		return new RoundWayTripPage(driver);

	}
	


}
