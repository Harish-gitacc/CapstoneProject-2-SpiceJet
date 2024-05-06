package BasicSpiceJet;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import UtilesSpiceJet.UtilesFile;



public class BasicFile extends UtilesFile {
	public String TestName;
	public String SheetName;
	
	@BeforeSuite
	 public void config()
	  {
		  String path = System.getProperty("user.dir")+"/SJReports/Chart.html";
		  
        ExtentSparkReporter  reporter = new ExtentSparkReporter(path);
		  reporter.config().setReportName("Project Report");
		  reporter.config().setDocumentTitle("Test result");		  
		  extent = new ExtentReports();
		  extent.attachReporter(reporter);
		  extent.setSystemInfo("Testing", "Harish");			   
}

	@BeforeClass
	public void testDetails() {
			test= extent.createTest(TestName);
	}

	@BeforeMethod
	public void start() throws Exception {
		launchBrowser(readProperty("brouser"));
		getURL("https://www.spicejet.com/");

	}

	@AfterMethod
	public void close() {
		driver.quit();
	} 
	
	@DataProvider
	public Object[][] getFromExcel() throws Exception{
		Object[][] data = ExcelReadForLogin(SheetName);
		return data;
	}

	@AfterSuite
	public void endReport() {
		extent.flush();
	}

}
