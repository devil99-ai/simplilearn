package TestngSetup;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	static XSSFWorkbook workBook;
	static XSSFSheet sheet;
	
	public ExcelUtils(String excelPath, String sheetName) {
		try {
			workBook = new XSSFWorkbook(excelPath);
			sheet = workBook.getSheet(sheetName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		getRowCount();
		getCellData(1,0);
	}
	public static int getRowCount() {
		int rowCount=0;
		try {
			
			rowCount=sheet.getPhysicalNumberOfRows();
			System.out.println("row count: "+rowCount);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		return rowCount;
	}
	public static String getCellData(int rowNum, int colNum) {
		String cellData=null;
		try {
			cellData=sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
			System.out.println(cellData);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
			
		}
		return cellData;
	}
public static int getColCount() {
		int colCount=0;
		try {
			
			colCount=sheet.getRow(0).getPhysicalNumberOfCells();
			System.out.println("row count: "+colCount);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		return colCount;
	}
//	public static void main(String[] args) {
//		getRowCount();
//	}
//	public static void getRowCount() {
//		XSSFWorkbook workbook;
//		try {
//			
//			workbook = new XSSFWorkbook("C:\\Users\\svksh\\eclipse-workspace\\pizzahut_project\\excel\\demoxlsxtestng.xlsx");
//			XSSFSheet sheet = workbook.getSheet("Sheet");
//			int rowCount=sheet.getPhysicalNumberOfRows();
//			System.out.println(rowCount);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			System.out.println(e.getMessage());
//			System.out.println(e.getCause());
//			e.printStackTrace();
//		}
//		
//		
//	}
		}

