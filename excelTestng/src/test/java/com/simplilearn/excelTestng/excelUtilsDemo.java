package com.simplilearn.excelTestng;

import com.simplilearn.PizzahutTestNgProject.excelUtils;

public class excelUtilsDemo {
	public static void main(String[] args) {
		excelUtils excel = new excelUtils("C:\\Users\\svksh\\eclipse-workspace\\excelTestng\\src\\test\\excel\\excel.xlsx","Sheet1"); 
		excel.getRowCount();
		excel.getCellData(1, 1);
	}

}
