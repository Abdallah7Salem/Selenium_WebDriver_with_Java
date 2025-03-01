package day41;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	// fi: to open the excel file for reading
	public static FileInputStream fi;
	// fo: to open the excel file for writing
	public static FileOutputStream fo;
	// To create workbook, sheet, and cell
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	// style: to apply styles on cells
	public static CellStyle style;
	
	/*
	 * Parameters:
	 * xlfile => excel file path
	 * xlsheet => name of the excel sheet
	 */
	public static int getNumOfRows(String xlfile, String xlsheet) throws IOException
	{
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		int numOfRows = ws.getLastRowNum();
		wb.close();
		fi.close();
		return numOfRows;
	}
	
	/*
	 * Parameters:
	 * xlfile => excel file path
	 * xlsheet => name of the excel sheet
	 * rownum => row number
	 */
	public static int getnumOfCells(String xlfile, String xlsheet, int rowNumber) throws IOException
	{
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rowNumber);
		int numOfCells = row.getLastCellNum();
		wb.close();
		fi.close();
		return numOfCells;
	}
	
	/*
	 * Parameters:
	 * xlfile => excel file path
	 * xlsheet => name of the excel sheet
	 * rownum => row number
	 * colnum => column number
	 */
	public static String getCellData(String xlfile, String xlsheet, int rownum, int column) throws IOException
	{
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rownum);
		cell = row.getCell(column);
		
		String cellData;
		
		try
		{
			// cellData = cell.toString();
			DataFormatter formatter = new DataFormatter();
			cellData = formatter.formatCellValue(cell);	// Returns the formatted value of a cell as a String
		}
		catch(Exception e)
		{
			cellData = "";
		}
	
		wb.close();
		fi.close();
		return cellData;
		
	}
	
	/*
	 * Parameters:
	 * xlfile => excel file path
	 * xlsheet => name of the excel sheet
	 * rownum => row number
	 * colnum => column number
	 * data => data to be placed in the cell
	 */
	public static void setCellData(String xlfile, String xlsheet, int rownum, int colnum, String data) throws IOException
	{
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rownum);
		
		// Create a new cell in the row
		cell = row.createCell(colnum);
		cell.setCellValue(data);
		
		fo = new FileOutputStream(xlfile);
		wb.write(fo);
		
		wb.close();
		fi.close();
		fo.close();
	}
	
	/*
	 * Parameters:
	 * xlfile => excel file path
	 * xlsheet => name of the excel sheet
	 * rownum => row number
	 * colnum => column number
	 */
	public static void fillGreenColor (String xlfile, String xlsheet, int rownum, int colnum) throws IOException
	{
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rownum);
		cell = row.getCell(colnum);
		
		style = wb.createCellStyle();
		
		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	
		cell.setCellStyle(style);
		
		fo = new FileOutputStream(xlfile);
		wb.write(fo);
		
		wb.close();
		fi.close();
		fo.close();
	}
	
	
	/*
	 * Parameters:
	 * xlfile => excel file path
	 * xlsheet => name of the excel sheet
	 * rownum => row number
	 * colnum => column number
	 */
	public static void fillRedColor (String xlfile, String xlsheet, int rownum, int colnum) throws IOException
	{
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rownum);
		cell = row.getCell(colnum);
		
		style = wb.createCellStyle();
		
		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	
		cell.setCellStyle(style);
		
		fo = new FileOutputStream(xlfile);
		wb.write(fo);
		
		wb.close();
		fi.close();
		fo.close();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
