package UtilesSpiceJet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class UtilesFile {

	public static WebDriver driver;
	public String TestName;
	public String TestDescription;
	public String TestAuthor;
	public static ExtentTest test;
	public static ExtentReports extent;
	public String sheetName;
	
	
	public static String readProperty(String key) throws IOException {
		String projectPath = System.getProperty("user.dir");
		File file = new File(projectPath + "./SJconfigration.properties");
		FileInputStream fileinput = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fileinput);
		return prop.get(key).toString();

	}

	public static void launchBrowser(String browser) {

		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			WebDriverManager.chromedriver().setup();
			ChromeOptions object = new ChromeOptions();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions object = new FirefoxOptions();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
			WebDriverManager.edgedriver().setup();
			EdgeOptions object = new EdgeOptions();
		} else {
			ChromeOptions object = new ChromeOptions();
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	public static void ExpliciteWait(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	public static void getURL(String url) {
		driver.get(url);
	}
	
	
	public static void ExplicitWaitGetTitle(String titleToWait) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.titleIs(titleToWait));
	}
	public static String getPageTitle() {
		ExplicitWaitGetTitle(driver.getTitle());
		return driver.getTitle();
	}

	public static void Clickon(WebElement element) {
	    element.click();
	}
	public static void Type(WebElement element,String text) {
		ExpliciteWait(element);
		element.click();
		element.sendKeys(text);	    
	}
	
	public static void ScrollUntillElement(WebElement element) {
		ExpliciteWait(element);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
	}
	public static void TypeAndClick(WebElement element ,String text) {
		
		element.sendKeys(text);
		element.click();
	}
	
	public static void selectFromDropDown(WebElement element, String visibleText) {
		Select select = new Select(element);
		select.selectByVisibleText(visibleText);
	}
	
	 public static Object[][] ExcelReadForLogin(String sheetName) throws IOException
	 {
	 XSSFWorkbook workBook = new XSSFWorkbook("C:/Users/lenovo/eclipse-workspace/SpiceJetFinal/DataFile/LoginPossibility.xlsx");
		XSSFSheet sheet = workBook.getSheet(sheetName);
		int rows = sheet.getLastRowNum();
		int columns = sheet.getRow(0).getLastCellNum();
		Object[][] data = new Object[rows][columns];
		for (int r = 1; r <= rows; r++) {
			for (int c = 0; c < columns; c++) {
				data[r-1][c] = sheet.getRow(r).getCell(c).toString();
				System.out.println(sheet.getRow(r).getCell(c).toString());
				}
			}
			workBook.close();
			return data;			
		}

	public static int TakescreenShot(String TestName) throws InterruptedException, Exception, Exception {
		int randomnum = (int) (Math.random() * 100 + 10000);
		Thread.sleep(3000);
		String projectpatth = System.getProperty("user.dir");
		FileUtils.copyFile(((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE),
				new File(projectpatth + "/ScreenShot/" + TestName + randomnum + ".png"));
		return randomnum;
	}

	public void reportStep(String stepDetails, String stepStatus, String TestName) throws Exception {

			int randomnum = TakescreenShot(TestName);
			String projectPath = System.getProperty("user.dir");

			if (stepStatus.equalsIgnoreCase("pass")) {
				Assert.assertTrue(true, stepDetails);
				test.pass(stepDetails, MediaEntityBuilder
						.createScreenCaptureFromPath(projectPath + "/Screenshot/" + TestName + randomnum + ".png").build());
			} else if (stepStatus.equalsIgnoreCase("fail")) {
				Assert.fail("Step Failed: " + stepDetails);
				test.fail(stepDetails, MediaEntityBuilder
						.createScreenCaptureFromPath(projectPath + "/Screenshot/" + TestName + randomnum + ".png").build());
	    }
	}

}
