//laksh
package com.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.qa.base.TestBase;

public class Utility extends TestBase {
	
public static int IMPLICIT_TIME_OUT = 20;
public static int PAGE_LOAD_TIME_OUT=20;

static Workbook book;
static Sheet sheet;
public static String TESTDATA_SHEET_PATH = "D:\\LAKSH\\Selenium\\Selenium Practice\\GTPL Project\\DDT\\GTPL_TestNG_Data_Driven.xlsx";


public static void switchToFrame() 
{
	try {
		Thread.sleep(3000);
		driver.switchTo().frame("flow_close_btn_iframe");
		Thread.sleep(1000);	
		driver.findElement(By.id("closeBtn")).click();
		System.out.println("The Video button closed successfully");
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}


public static void getScreenShot(String folderName)

{
	
	/*LocalDateTime Date=java.time.LocalDateTime.now();
	String valid_date =Date.toString();
	
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	   LocalDateTime now = LocalDateTime.now();
	  
	String dat_final=dtf.format(now).toString();
	System.out.println(dat_final);*/
		
	File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	try {
		FileUtils.copyFile(src, new File ("D:\\LAKSH\\Selenium\\Selenium Practice\\GTPL Project\\"
				+ "Snapshots"+folderName+"\\"+System.currentTimeMillis()+".png"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}


public static Object[][] getTestData(String sheetName) {
	FileInputStream file = null;
	try {
		file = new FileInputStream(TESTDATA_SHEET_PATH);
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	try {
		book = WorkbookFactory.create(file);
	}  catch (IOException e) {
		e.printStackTrace();
	}
	sheet = book.getSheet(sheetName);
	Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	// System.out.println(sheet.getLastRowNum() + "--------" +
	// sheet.getRow(0).getLastCellNum());
	for (int i = 0; i < sheet.getLastRowNum(); i++) {
		for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
			data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
			// System.out.println(data[i][k]);
		}
	}
	return data;
}











}

