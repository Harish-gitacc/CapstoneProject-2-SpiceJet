package TestCasesSpiceJet;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import BasicSpiceJet.BasicFile;
import Pages.OneWayTripPage;

public class SJ_02_OneWayTripPageTest  extends BasicFile{
	@BeforeTest
	public void setup() {
		TestName = "SJ_02_OneWayTripPageTest";
		TestDescription = "Checking OneWayTrip Flight Booking in SpiceJet";
		TestAuthor = "Harish";
		
	}
	@Test(priority = 2)
	public void TC_02_OneWayTripTest() throws Exception {
		OneWayTripPage OneWay=new OneWayTripPage(driver);
        OneWay.Ticketbooking("del");
		OneWay.reportStep(TestName, TestDescription, TestAuthor);
	}

}
