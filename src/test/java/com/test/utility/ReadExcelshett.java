package com.test.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelshett {

public static FileInputStream inputStream;
public static XSSFWorkbook workbook;
public static XSSFSheet Sheet;
public static XSSFRow row;
public static XSSFCell cell;
   


public static String getcellvalue(String filename,String sheetname,int rowno ,int cellno )

{

	
	try {
	inputStream =new FileInputStream(filename);
	workbook=new XSSFWorkbook(inputStream);
	Sheet= workbook.getSheet(sheetname);
	cell=workbook.getSheet(sheetname).getRow(rowno).getCell(cellno);
	
	workbook.close();
	
	return cell.getStringCellValue();
	
	} catch (Exception e) {
		return("");
	}
}
public static int getrowvalue(String filename,String sheetname)
{
try {
	inputStream=new FileInputStream(filename);
	workbook=new XSSFWorkbook(inputStream);
	Sheet=workbook.getSheet(sheetname);
	
	//get total number of rows
	
	int ttlrow= Sheet.getLastRowNum() + 1;
	
	workbook.close();
	
	 return ttlrow;
	
	
	
	
} catch (Exception e) {
	return 0;
}	

}
public static int getcellcount(String filename,String sheetname)
{
try {
	inputStream=new FileInputStream(filename);
	workbook=new XSSFWorkbook(inputStream);
    Sheet=workbook.getSheet(sheetname);
    
    //get cell count
    
    int ttlcell= Sheet.getRow(0).getLastCellNum();
    
    return ttlcell;
    
    
} catch (Exception e) {
return 0;
}	

}

}
