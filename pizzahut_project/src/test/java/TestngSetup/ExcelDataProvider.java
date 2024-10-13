package TestngSetup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExcelDataProvider {
	@Test(dataProvider="testData")
	public void test1(String url) {
		System.out.println(url);
		WebDriver driver = new ChromeDriver();
		WebDriverManager.chromedriver().setup();
		driver.get(url);
		
		
		
	}
	
	@DataProvider(name="testData")
	public Object[][] getDataFromExcel() {
		String excelPath="C:\\\\Users\\\\svksh\\\\eclipse-workspace\\\\pizzahut_project\\\\excel\\\\url.xlsx";
		String sheetname = "sheet1";
		Object data[][]=testData(excelPath, sheetname);
		return data;
	}
	
	public static Object[][] testData(String excelPath, String sheetName) {
		ExcelUtils excel = new ExcelUtils(excelPath, sheetName);
		int rowcount = excel.getRowCount();
		int colcount = excel.getColCount();
		Object data[][] = new Object[rowcount][colcount];
		for (int i =1; i<=rowcount;i++) {
			for(int j =0; j<=colcount;j++) {
				String cellData=excel.getCellData(i, j);
				System.out.println(cellData);
				data[i-1][j]=cellData;
			}
		}
		return data; 
	}

}
