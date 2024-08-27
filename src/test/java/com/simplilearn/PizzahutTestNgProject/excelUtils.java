package com.simplilearn.PizzahutTestNgProject;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelUtils {
	static XSSFSheet sheet;
	static XSSFWorkbook workbook;
	public excelUtils(String excelPath, String sheetname) {
		try{
			workbook = new XSSFWorkbook(excelPath);
			sheet = workbook.getSheet(sheetname);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		getRowCount();
		getCellData(0,0);
		//getCellDataNumber(1,3);
		
	}
	public static int getRowCount() {
		int rowCount=0;
		try {
			rowCount=sheet.getPhysicalNumberOfRows();
			System.out.println("row count"+rowCount);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		return rowCount;
	}
	public static String getCellData(int rownum, int colnum) {
		String cellData=null;
		try {
			String value=sheet.getRow(rownum).getCell(colnum).getStringCellValue();
			System.out.println(value);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return cellData;
		
	}
public static int getColCount() {
	int colCount=0;
		try {
			colCount=sheet.getRow(0).getPhysicalNumberOfCells();
			System.out.println("col  count"+colCount);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		return colCount;
	}
//	public static void getCellDataNumber(int rownum, int colnum) {
//		try {
//			double numeric=sheet.getRow(rownum).getCell(colnum).getNumericCellValue();
//			System.out.println(numeric);
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		
//	}
	public static String getCellDataString(int rownum, int colnum) {
		String data=null;
		try {
			data=sheet.getRow(rownum).getCell(colnum).getStringCellValue();
			System.out.println(data);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return data;
		
	}

}
