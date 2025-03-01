package day40;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

// Excel file --> Workbook --> Sheets --> Rows --> Cells

public class WritingDataIntoExcel {

	public static void main(String[] args) throws IOException {
		
		// Create a new workbook (not connected to any excel file yet)
		XSSFWorkbook workbook = new XSSFWorkbook();
		
		// Create a new sheet in the workbook
		XSSFSheet sheet = workbook.createSheet("Data");
		
		// Create a new row in the sheet
		XSSFRow row1 = sheet.createRow(0);
			// Create cells in the row
			row1.createCell(0).setCellValue("Java");
			row1.createCell(1).setCellValue(19);
			row1.createCell(2).setCellValue("Test Automation");
		
		// Create a new row in the sheet
		XSSFRow row2 = sheet.createRow(1);
			// Create cells in the row
			row2.createCell(0).setCellValue("Python");
			row2.createCell(1).setCellValue(3);
			row2.createCell(2).setCellValue("Test Automation");
		
		// Create a new row in the sheet
		XSSFRow row3 = sheet.createRow(2);
			// Create cells in the row
			row3.createCell(0).setCellValue("C#");
			row3.createCell(1).setCellValue(5);
			row3.createCell(2).setCellValue("Test Automation");
		
		
		// Create a new excel file (in case of not found)
		FileOutputStream file = new FileOutputStream(System.getProperty("user.dir") + "\\testData\\myFile.xlsx");
		
		// Connect the workbook to the excel file
		workbook.write(file);
		
		workbook.close();
		file.close();
		
		System.out.println("File is created");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
