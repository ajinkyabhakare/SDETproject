package com.Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils {
	public FileOutputStream fo;//to write the value
	public FileInputStream fi;//to read the value
	public XSSFWorkbook wb;//to access the excell file
	public XSSFSheet ws;//to access sheet
	public XSSFRow row;
	public XSSFCell cell;
	
	//This is for counting the row
	public int getRowCount(String xlfile,String xlsheet) throws IOException
	{
		fi=new FileInputStream(xlfile);//accesing file
		wb=new XSSFWorkbook(fi);//accesing excell
		ws=wb.getSheet(xlsheet);//accesing sheet
		int rowcount=ws.getLastRowNum();
		wb.close();
		fi.close();
		return rowcount;
	
		
	}
	
	public int getCellCount(String xlfile,String xlsheet,int rownum) throws IOException
	{
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlsheet);
		row=ws.getRow(rownum);//accesing row
		int cellcount=row.getLastCellNum();//getting cell count
		wb.close();
		fi.close();
		
		return cellcount;
			
	}
	
	public String getCellData(String xlfile,String xlsheet,int rownum,int colnum) throws IOException, InterruptedException
	{
		
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlsheet);
		row=ws.getRow(rownum);
		cell=row.getCell(colnum);
		Thread.sleep(3000);
		String data=cell.getStringCellValue();
		
		wb.close();
		fi.close();
		
		return data;
		
	}
	
	public void setCellData(String xlfile,String xlsheet,int rownum,int colnum,String data) throws IOException
	{
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlsheet);
		row=ws.getRow(rownum);
		cell=row.getCell(colnum);
		cell.setCellValue(data);
		fo=new FileOutputStream(xlfile);
		wb.close();
		fi.close();
		fo.close();
		
	}

}
