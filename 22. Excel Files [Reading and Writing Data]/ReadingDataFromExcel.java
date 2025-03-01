package day40;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

// Excel File --> Workbook --> Sheets --> Rows --> Cells


public class ReadingDataFromExcel {

	public static void main(String[] args) throws IOException {
		
		// Open the excel sheet in the reading mode
		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\testData\\data.xlsx");
		
		// Open the workbook from the excel file
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		
		// Extract specific sheet from the workbook using sheet index
		// XSSFSheet sheet = workbook.getSheetAt(0);
		
		// Extract specific sheet from the workbook using sheet name
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		
		// Get number of rows in the excel sheet
		int totalRowsNum = sheet.getLastRowNum();
		
		// Get number of cells in the excel row
		int totalCellsNum = sheet.getRow(1).getLastCellNum(); 
		
		System.out.println("Number of rows: " + totalRowsNum);	// 5 (starting from 0)
		System.out.println("Number of cells: " + totalCellsNum);	// 4 (starting from 1)
		
		for (int r = 0; r <= totalRowsNum; r++)
		{
			
			XSSFRow currentRow = sheet.getRow(r);
			
			for (int c = 0; c < totalCellsNum; c++)
			{
				XSSFCell cell = currentRow.getCell(c);
				System.out.print(cell.toString() + "\t"); 
			}
			
			System.out.println();
		}
		
		
		workbook.close();
		file.close();
		
		
		
		
		
		

	}

}
