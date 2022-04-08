package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(new File("testData.xlsx")));
			
			XSSFSheet sheet = workbook.getSheet("Sheet1");
			
			int rowCount = sheet.getPhysicalNumberOfRows();
			int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
			
			System.out.println("Number of rows in Sheet is: " + sheet.getPhysicalNumberOfRows());
			
			System.out.println("Number of Columns in Sheet is: " + sheet.getRow(0).getPhysicalNumberOfCells());
			
			
			for(int rowIndex = 1; rowIndex<rowCount; rowIndex++) {
				
				for(int colIndex = 0;colIndex<colCount;colIndex++) {
					
					String data = sheet.getRow(rowIndex).getCell(colIndex).getStringCellValue();
					System.out.println(data);
				}
				
			}
			
			
			
			
			
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
