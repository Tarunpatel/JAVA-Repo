package Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import bsh.This;

public class ReadExcel {

	public static File currentDir = new File("");

	public static String datafilepath = "\\resources\\testdata.xlsx";
	
	public static DataFormatter objDefaultFormat;
	
	public static FormulaEvaluator objFormulaEvaluator;

	public static XSSFSheet getSheet(String sheetname) throws Exception {

		String url = currentDir.getAbsolutePath() + datafilepath;
		FileInputStream fis = new FileInputStream(url);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet(sheetname);
				
		objDefaultFormat = new DataFormatter();
		objFormulaEvaluator = new XSSFFormulaEvaluator((XSSFWorkbook)wb);
		
		return sheet;

	}

	public static Object syncPageData(Object obj, String sheetname) {
		try {
			XSSFSheet sheet = getSheet(sheetname);

			XSSFRow headerRow = sheet.getRow(0);
			XSSFRow dataRow = sheet.getRow(1);

			for (int i = 0; headerRow.getCell(i) != null; i++) {
				Cell cell = dataRow.getCell(i);
				
				Field field = obj.getClass().getDeclaredField(headerRow.getCell(i).getStringCellValue());
				field.setAccessible(true);
				
				objFormulaEvaluator.evaluate(cell);
				String cellValueStr = objDefaultFormat.formatCellValue(cell, objFormulaEvaluator);
				System.out.println(cellValueStr);
				
				field.set(obj, cellValueStr);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	public static String[][] readTestData() throws IOException
	{
		String[][] returnData = null;
		
		String url = currentDir.getAbsolutePath() + datafilepath;
		FileInputStream fis = new FileInputStream(url);
		
		XSSFWorkbook workbook =  new XSSFWorkbook(fis);
		
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		int totalRows = sheet.getLastRowNum();
		int totalCols = 20;
		
		returnData = new String[totalRows][totalCols];

		int c = 0;
		int r = 0;
		
		for(int i = 0; i <= totalRows; i++)
		{
			if(i > 0)
			{
				Row row = sheet.getRow(i);
				
				for(int j = 0; j < totalCols; j++)
				{
					Cell cell = row.getCell(j);
					try
					{
						returnData[r][c] = cell.getStringCellValue();
					}
					catch(NullPointerException e)
					{
						returnData[r][c] = "";
					}
					c++;
				}
				c = 0;
				r++;
			}
		}
		
		fis.close();
		
		return returnData;
	}

	
}
