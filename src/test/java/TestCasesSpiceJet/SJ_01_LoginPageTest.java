package TestCasesSpiceJet;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import BasicSpiceJet.BasicFile;
import Pages.LoginPage;

public class SJ_01_LoginPageTest extends BasicFile{
	@BeforeTest
	public void setup() {
		TestName = "SJ_01_LoginPageTest";
		TestDescription = "Login to SpiceJet website";
		TestAuthor = "Harish ";
		SheetName="signInTestData";
		
	}
	@Test(dataProvider="getFromExcel",priority = 1)
	public void TC_01_LoginTest(String PhoneNumber,String Password) throws Exception {
		LoginPage login=new LoginPage(driver);
		login.ClickLogin();
		login.LoginPage(PhoneNumber, Password);
		login.reportStep(TestName, TestDescription, TestAuthor);
		
	}

}
