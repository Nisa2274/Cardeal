package com.challenge.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.challenge.base.baseclass;



	
	public class utility extends baseclass{
		
		
		//public static WebDriver driver;
		static Sheet sheets;
		static String deal="D:\\automation\\Datafile.xls";
		
		public static void  explicit(WebElement datas) {
			
			WebDriverWait wait=new WebDriverWait(driver,5);
			wait.until(ExpectedConditions.visibilityOf(datas));
			
		}
		
		
public static String[][] gettestdata(String sheetname,int totalrows,int totalcols) throws IOException {
			
			File src=new File(deal);
			FileInputStream file=new FileInputStream(src);		
			HSSFWorkbook book=new HSSFWorkbook(file);	
			sheets=book.getSheet(sheetname);	
			String[][] data=new String[totalrows][totalcols];
			for(int i=0;i<totalrows;i++) {
					
				for(int j=0;j<totalcols;j++) {
				
				data[i][j]=sheets.getRow(i+1).getCell(j).toString();
				
				}
			 
		}
		
		return data;	
		
	}

}