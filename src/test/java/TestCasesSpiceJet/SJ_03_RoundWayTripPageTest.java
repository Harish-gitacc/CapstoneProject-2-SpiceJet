package TestCasesSpiceJet;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import BasicSpiceJet.BasicFile;
import Pages.RoundWayTripPage;


public class SJ_03_RoundWayTripPageTest extends BasicFile{
	@BeforeTest
	public void setup() {
		TestName = "SJ_03RoundWayTripPageTest";
		TestDescription = "Checking RoundTrip Flight Booking in SpiceJet ";
		TestAuthor = "Harish ";
	}
	@Test (priority = 3)
	public void TC_03RoundWayTripTest() throws Exception {
		RoundWayTripPage RoundWay=new RoundWayTripPage(driver);
		RoundWay.changetwo("del");
		RoundWay.reportStep(TestName, TestDescription, TestAuthor);
	}



}
