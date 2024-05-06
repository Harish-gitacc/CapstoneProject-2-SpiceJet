package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BasicSpiceJet.BasicFile;

public class FlightBookingPage extends BasicFile{
	
	
	@FindBy(xpath = "//div[@data-testid='to-testID-origin']//input[@type='text']")
	WebElement From;

	@FindBy(xpath = "//div[@class='css-1dbjc4n r-b5h31w r-95jzfe']//div[text()='MAA']")
	WebElement To;

	@FindBy(xpath = "//div[@data-testid='departure-date-dropdown-label-test-id']")
	WebElement Date;

	//@FindBy(xpath ="//div[@class='css-76zvg2 r-jwli3a r-ubezar r-16dba41']")
	//WebElement DepartureDate;

	@FindBy(xpath = " //div[text()='Passengers']")
	WebElement Passenger;
	 
    @FindBy(xpath="//div[@class='r-1awozwy r-19m6qjp r-y47klf r-1loqt21 r-eu3ka r-1777fci r-1otgn73 r-1i6wzkk r-lrvibr r-1aockid css-1dbjc4n']//*[name()='svg']")	
    WebElement AdultAdd;
     
	@FindBy(xpath = " //div[text()='Done']")
	WebElement Passengerdone;

	@FindBy(xpath = "//div[contains(text(),'Currency')]")
	WebElement currency;

	@FindBy(xpath = "//div[contains(text(),'INR')]")
	WebElement Selectcurrency;

	@FindBy(xpath = "//div[@class='css-1dbjc4n r-1niwhzg r-1p0dtai r-1d2f490 r-1udh08x r-u8s1d r-zchlnj r-ipm5af']")
	WebElement SearchFlight;

	@FindBy(xpath = "//div[@class='css-76zvg2 r-jwli3a r-1i10wst r-1kfrs79']")//
	WebElement Next;

	@FindBy(xpath = "//div[@data-testid='continue-search-page-cta']")
	WebElement ClickNext;
//------------------------------------------------------------------------------------------------------------------------------------------------	
	@FindBy(xpath="//div[text()='Mr']")
	WebElement ClickMr;

	@FindBy(xpath = "//input[@data-testid='first-inputbox-contact-details']")
	WebElement FirstName;
	
	@FindBy(xpath = "//input[@data-testid='last-inputbox-contact-details']")
	WebElement LastName;
	
	@FindBy(xpath = "//input[@data-testid='contact-number-input-box']")
	WebElement PhoneNumber;
	
	@FindBy(xpath = "//input[@data-testid='emailAddress-inputbox-contact-details']")
	WebElement Email;
	
	@FindBy(xpath = "//div[text()='India']")
	WebElement SelectCountry;
	
	@FindBy(xpath = "//input[@data-testid='city-inputbox-contact-details']")
	WebElement City;

	@FindBy(xpath = "//div[text()='I am flying as the primary passenger']")
	WebElement CheckBox;
	
	@FindBy(xpath ="//div[@class='css-1dbjc4n r-18u37iz r-1g94qm0 r-mhe3cw']//div[@class='css-1dbjc4n r-1awozwy r-lfiufh r-z2wwpe r-1phboty r-rs99b7 r-18u37iz r-1ugchlj r-l0gwng']//input[@type='text']")
	WebElement passengerfname;
	
	@FindBy(xpath = "//div[@class='css-1dbjc4n r-mvpalk r-5360zw']//input[@type='text']")
	WebElement passengerlname;
	
	@FindBy(xpath= "//div[@class='css-1dbjc4n r-18u37iz r-1hfyk0a']//input[@type='text']")
	WebElement paswsengerphonenumber;
	
	@FindBy(xpath = "//div[@class='css-1dbjc4n r-1awozwy r-1xfd6ze r-1loqt21 r-18u37iz r-1777fci r-1w50u8q r-ah5dr5 r-1otgn73']")
	WebElement continue1;
	
	@FindBy(xpath = "//div[@class='css-76zvg2 r-jwli3a r-poiln3 r-adyw6z r-1kfrs79']")
	WebElement continue2;
	
	@FindBy(xpath="//div[@class='css-1dbjc4n r-1niwhzg r-1p0dtai r-1d2f490 r-1udh08x r-u8s1d r-zchlnj r-ipm5af']")
	WebElement continue3;
//-----------------------------------------------------------------------------------------------------------------------------------
	
	@FindBy(className = "card_number_iframe")
	WebElement cardframe;

	@FindBy(xpath = "//input[@placeholder='Enter Card Number Here']")
	WebElement debitcard;

	@FindBy(className = "name_on_card_iframe")
	WebElement nameframe;

	@FindBy(id = "name_on_card")
	WebElement cardname;

	@FindBy(className = "card_exp_month_iframe")
	WebElement monthframe;

	@FindBy(xpath = "//input[@placeholder='MM']")
	WebElement expmonth;

	@FindBy(className = "card_exp_year_iframe")
	WebElement yearframe;

	@FindBy(xpath = "//input[@placeholder='YY']")
	WebElement expyear;

	@FindBy(className = "security_code_iframe")
	WebElement securityframe;

	@FindBy(xpath = "//input[@placeholder='123']")
	WebElement securitycvv;
	
	
	//--------------------------------------------------------------------------------------------------------------------
	
	public FlightBookingPage(WebDriver driver) {       //input[@placeholder='Enter Card Number Here']
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public FlightBookingPage Ticketbooking(String start) throws InterruptedException {
        
	//	Clickon(RoundTrip);
		Type(From, start);
		Clickon(To);
		ExpliciteWait(Date);
		Clickon(Date);
		Thread.sleep(5000);
	
		Thread.sleep(2);
		 Actions  act = new Actions(driver);
	     act.click(SearchFlight).build().perform();
	     Thread.sleep(5000);
	     
	     Actions  act1 = new Actions(driver);
	     act1.click(Next).build().perform();
	     
	
		Actions act3 = new Actions(driver);
		act3.click(ClickNext).build().perform();
	
		return this;
	}
	
	public  FlightBookingPage book(String Firstname, String Lastname, String PhoneNo, String Mail, String city)
			                      /*  String Cardname , String DebitCard , String PassengerFname , String PassengerLname,
			                        String PassengerPhonNo,
			                        String NameFrame , String cardname , String Monthframe,
			                        String Expiremnth , String Yearframe , String ExpireYr , String Security , String CVV)*/
			                        throws InterruptedException 
	{
		Thread.sleep(1000);
		ExpliciteWait(ClickMr);
		Clickon(ClickMr);
		TypeAndClick(FirstName, Firstname);
		TypeAndClick(LastName, Lastname);
		TypeAndClick(PhoneNumber, PhoneNo);
		TypeAndClick(Email, Mail);
		Clickon(SelectCountry);
		TypeAndClick(City, city);
		Clickon(CheckBox);
	//	TypeAndClick(passengerfname,PassengerFname);
	//	TypeAndClick(passengerlname,PassengerLname);
	//	TypeAndClick(paswsengerphonenumber,PassengerPhonNo);
		ScrollUntillElement(continue2);
		Actions act1 = new Actions(driver);
		act1.click(continue2).build().perform();
		
	/*	ScrollUntillElement(continue3);
		Actions act2 = new Actions(driver);
		act2.click(continue3).build().perform();*/
		
		return new FlightBookingPage(driver);

	}
	
	

}
