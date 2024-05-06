package Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BasicSpiceJet.BasicFile;

public class RoundWayTripPage extends BasicFile{

	@FindBy(xpath="//div[text()='round trip']")
	WebElement RoundTrip;
	
	@FindBy(xpath="//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[3]/div/div[1]/div/div[2]/input")
	WebElement Form;
	
	@FindBy(xpath="//div[@class='css-1dbjc4n r-b5h31w r-95jzfe']//div[text()='MAA']")
	WebElement To;
	
	@FindBy(xpath="//div[@data-testid='undefined-month-May-2024']//div[@data-testid='undefined-calendar-day-11']")
	WebElement SelectFromDate;
	
	@FindBy(xpath="//div[@class='css-76zvg2 r-jwli3a r-ubezar r-16dba41']")
	WebElement SelecttoDate;
	
	@FindBy(id="home-page-travellers")
	WebElement Passenger;
	
	@FindBy(xpath="//div[contains(text(),'Currency')]")
	WebElement currency;
	
	@FindBy(xpath="//div[contains(text(),'INR')]")
	WebElement Selectcurrency;
	
	@FindBy(xpath="//div[@class='css-1dbjc4n r-1niwhzg r-1p0dtai r-1d2f490 r-1udh08x r-u8s1d r-zchlnj r-ipm5af']")//(xpath = "//div[contains(text(),'Search Flight')]")
	WebElement SearchFlight;
	
	@FindBy(xpath = "//div[@class='css-76zvg2 r-jwli3a r-1i10wst r-1kfrs79']")
	WebElement ClickNext;
	

	
	public RoundWayTripPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	public FlightBookingPage changetwo(String start) throws InterruptedException {
		Clickon(RoundTrip);
		ExpliciteWait(Form);
		Type(Form, start);
		Clickon(To);
		Clickon(SelectFromDate);
		Clickon(SelecttoDate);
		Actions  act = new Actions(driver);
	     act.click(SearchFlight).build().perform();
	     Thread.sleep(5000);
		Thread.sleep(5);
		 Actions  act1 = new Actions(driver);
	     act1.click(ClickNext).build().perform();
		return new FlightBookingPage(driver);
	}
	
	
}
