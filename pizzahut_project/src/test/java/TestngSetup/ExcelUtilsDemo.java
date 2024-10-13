package TestngSetup;

public class ExcelUtilsDemo {
	
	public static void main(String[] args) {
		try {
			ExcelUtils excel = new ExcelUtils("C:\\Users\\svksh\\eclipse-workspace\\pizzahut_project\\excel\\url.xlsx", "sheet1");
			excel.getRowCount();
			excel.getCellData(0, 1);
	}catch(Exception e) {
		e.printStackTrace();
	}
	}

}
