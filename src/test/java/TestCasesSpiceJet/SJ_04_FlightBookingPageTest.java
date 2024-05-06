package TestCasesSpiceJet;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import BasicSpiceJet.BasicFile;
import Pages.FlightBookingPage;

public class SJ_04_FlightBookingPageTest extends BasicFile{
	@BeforeTest
	public void setup() {
		TestName = "SJ_04_FlightBookingPageTest";
		TestDescription = "Checking ticket Booking Trip in SpiceJet";
		TestAuthor = "Harish ";
	}
	@Test(priority = 4)
	public void TC_04_BookingPageTest() throws Exception {
		FlightBookingPage booking =new FlightBookingPage(driver);
		booking.Ticketbooking("del");		
		booking.book("hari", "vj", "8608239250", "hariblog567@gmail.com", "Puducherry");// ,SheetName, SheetName, SheetName, SheetName, SheetName, SheetName, SheetName, SheetName, SheetName, SheetName);
		booking.reportStep(TestName, TestDescription, TestAuthor);		
	}

}
