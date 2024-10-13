package TestngSetup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class pizzahutTest {
	WebDriver driver;
	ExtentReports reports;
	ExtentTest test;
	ExtentSparkReporter spark;
	Reusable resObj;
	
	@BeforeClass
	public void setUp() {
	       reports = new ExtentReports();
	       resObj = new Reusable();
	       spark = new ExtentSparkReporter(System.getProperty("user.dir") + "/pizzahutCheckout.html");
	       reports.attachReporter(spark);
	       reports.setSystemInfo("Host Name", "StarHealth Application - Home Plan");
	       reports.setSystemInfo("Environment", "Production");
	       reports.setSystemInfo("User Name", "Test Team");
	       spark.config().setDocumentTitle("pizzahutCheckout Application QA ");
	       // Name of the report
	       spark.config().setReportName("pizzahutCheckout Application Using Selenium testNG ");
	       // Dark Theme
	       spark.config().setTheme(Theme.STANDARD);
	       test = reports.createTest("Validate pizzahutCheckout Application Using Selenium testNG");
	       
		
		
	}
	@BeforeSuite
	public void browserOpen() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		
	}
	@Test
	public void pizzahut001(String url) {
		driver.get(resObj.read_data_from_XL(url));
	}
	
	
	
	
	
	
	@DataProvider(name="testData")
	public Object[][] getDataFromExcel() {
		String excelPath="C:\\\\Users\\\\svksh\\\\eclipse-workspace\\\\pizzahut_project\\\\excel\\\\url.xlsx";
		String sheetname = "sheeet1";
		Object data[][]=testData(excelPath, sheetname);
		return data;
	}
	
	public static Object[][] testData(String excelPath, String sheetName) {
		ExcelUtils excel = new ExcelUtils(excelPath, sheetName);
		int rowcount = excel.getRowCount();
		int colcount = excel.getColCount();
		Object data[][] = new Object[rowcount][colcount];
		for (int i =0; i<=rowcount;i++) {
			for(int j =0; j<=colcount;j++) {
				String cellData=excel.getCellData(i, j);
				System.out.println(cellData);
				data[i-1][j]=cellData;
			}
		}
		return data; 
	}

}
