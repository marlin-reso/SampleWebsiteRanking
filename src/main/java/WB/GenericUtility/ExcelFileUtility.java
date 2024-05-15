package WB.GenericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class contains generic methods related to excel file.
 * @author SanjayGiri
 */

public class ExcelFileUtility {
	
	/**
	 * This method will return the value from the excel sheet.
	 * @param sheet
	 * @param row
	 * @param cell
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readDataFromExcelFile(String sheet, int row, int cell) throws EncryptedDocumentException, IOException
	{
		try {
		FileInputStream fis = new FileInputStream(IConstantUtility.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheet);
		Row rw = sh.getRow(row);
		Cell ce = rw.getCell(cell);
		String value = ce.getStringCellValue();
		wb.close();
		return value;
		}catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
			
	}
	
	/**
	 * This method will return only integer value from excel sheet.
	 * @param row
	 * @param cell
	 * @param sheet
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public int readDataFromExcelFile(int row, int cell,String sheet ) throws EncryptedDocumentException, IOException
	{
		try {
		FileInputStream fis = new FileInputStream(IConstantUtility.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheet);
		Row rw = sh.getRow(row);
		Cell ce = rw.getCell(cell);
		int value = (int) ce.getNumericCellValue();
		wb.close();
		return value;
		}catch(Exception e)
		{
			e.printStackTrace();
			return 0;
		}
			
	}
	
	
	/**
	 * This method will return the total number of Row.
	 * @param sheet
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public int getRowCount(String sheet) throws EncryptedDocumentException, IOException
	{
		try {
		FileInputStream fis = new FileInputStream(IConstantUtility.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheet);
		int rowCount = sh.getLastRowNum();
		wb.close();
		return rowCount;
		}catch(Exception e)
		{
			e.printStackTrace();
			return 0;
		}
		
		
	}
	
	
	/**
	 * This method will help you to write the data into excel sheet.
	 * @param sheet
	 * @param row
	 * @param cell
	 * @param value
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void writeDataIntoExcel(String sheet, int row, int cell,String value) throws EncryptedDocumentException, IOException
	{
		try {
		FileInputStream fis = new FileInputStream(IConstantUtility.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		 Row rw = wb.getSheet(sheet).getRow(row);
		 rw.createCell(cell).setCellValue(value);
		 
		 
		 FileOutputStream fos = new FileOutputStream(IConstantUtility.excelFilePath);
		 wb.write(fos);
		 System.out.println("---Data Added----");
		 wb.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}
	
	

}
