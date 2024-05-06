package TestCasesSpiceJet;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import BasicSpiceJet.BasicFile;
import Pages.StatusCheckPage;

public class SJ_05_StatusCheckTest extends BasicFile{
	@BeforeTest
	public void setup() {
		TestName = "SJ_05_StatusCheckTest";
		TestDescription = "Checking the Status of SpiceJet website";
		TestAuthor = "Harish";
}
	@Test(priority = 5)
	public void TC_05_StatusTest() throws Exception {
		StatusCheckPage sc=new StatusCheckPage(driver);
		sc.status();
		sc.reportStep(TestName, TestDescription, TestAuthor);
		
	}
	
	
	
}

