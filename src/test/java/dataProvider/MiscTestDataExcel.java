package dataProvider;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class MiscTestDataExcel {

	XSSFWorkbook workbook;
	
	public MiscTestDataExcel(String missTestDataFilePath) {
		File source = new File(missTestDataFilePath);
		try {
			FileInputStream fis = new FileInputStream(source);
			workbook = new XSSFWorkbook(fis);
			
		} catch (Exception e) {
			System.out.println("Exception is "+e.getMessage());
		}
	}
	
	public String getdataIndex(int sheetIndex, int row, int column) {
		String data =workbook.getSheetAt(sheetIndex).getRow(row).getCell(column).getStringCellValue();
		return data;
	}
	
	public String getdataSheetName(String sheetName, int row, int column) {
		String data =workbook.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
		return data;
	}
}
