package tests;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import files.Payload;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class AddBookAPI {
  @Test(dataProvider = "GetBooksFromExcel")
  public void addBooks(String bookName, String isbnCode) {
	  
	  RestAssured.baseURI = "http://216.10.245.166";
	  
	  given().header("Content-Type","application/json").log().all().body(Payload.addBook(bookName,isbnCode))
	  .when().post("Library/Addbook.php")
	  .then().log().all().assertThat().statusCode(200);  	  
  }
  
  
  public Object[][] getBooksData() {
	  Object[][] data = new Object[][] {{"MyBook123","MyCode123"}, {"MyBook1234","MyCode124"}, {"MyBook1235","MyCode125"}};
	  return data;
  }
  
  
  @DataProvider(name = "GetBooksFromExcel")
  public Object[][] getDataFromExcel() throws FileNotFoundException, IOException {
	  XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(new File("testData.xlsx")));
		
		XSSFSheet sheet = workbook.getSheet("Sheet2");
		
		int rowCount = sheet.getPhysicalNumberOfRows();
		int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
		
		Object[][] dataProvider = new Object[rowCount-1][colCount];
		
		System.out.println("Number of rows in Sheet is: " + sheet.getPhysicalNumberOfRows());
		
		System.out.println("Number of Columns in Sheet is: " + sheet.getRow(0).getPhysicalNumberOfCells());
		
		
		for(int rowIndex = 1; rowIndex<rowCount; rowIndex++) {
			
			for(int colIndex = 0;colIndex<colCount;colIndex++) {
				
				dataProvider[rowIndex-1][colIndex] = sheet.getRow(rowIndex).getCell(colIndex).getStringCellValue();
			}
			
		}
		
		return dataProvider;
  }
}
