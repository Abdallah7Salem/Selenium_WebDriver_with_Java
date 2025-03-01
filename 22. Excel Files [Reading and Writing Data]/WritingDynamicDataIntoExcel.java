package day40;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingDynamicDataIntoExcel {

	public static void main(String[] args) throws IOException {
		
		FileOutputStream file = new FileOutputStream(System.getProperty("user.dir") + "\\testData\\myDynamicFile.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		
		// Create a sheet and name it => Dynamic Data
		XSSFSheet sheet = workbook.createSheet("Dynamic Data");
		
		// Scanner object to get data from the user
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter number of rows: ");
		int numOfRows = sc.nextInt();
		
		System.out.println("Enter number of cells: ");
		int numOfCells = sc.nextInt();
		
		for (int r = 0; r < numOfRows; r++)
		{
			// Create a new row in the sheet
			XSSFRow currentRow = sheet.createRow(r);
			
			for (int c = 0; c < numOfCells; c++)
			{
				// Create a new cell in the row
				XSSFCell cell = currentRow.createCell(c);
				
				// Enter value in the cell
				System.out.println("Enter cell " + c + " value in row " + r);
				cell.setCellValue(sc.next());
			}
		}
		
		workbook.write(file);
		
		workbook.close();
		file.close();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
