package com.challenge.test;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.challenge.base.baseclass;
import com.challenge.pages.compare;
import com.challenge.utility.utility;

public class testcompare extends baseclass{
	
	String sheetnames="Sheet1";
	String data[][];
	String data2[][];
	compare obj;

	@BeforeClass
	public void objects() {
		
		baseclass.browseropen("chrome");
		obj=new compare();

	}
	
	@DataProvider
	public String[][] getdata() throws IOException {
	
		data2=utility.gettestdata(sheetnames,4,5);
		return data2;
	}
	
	@Test(dataProvider="getdata")
	
	public void Verify(String registration1,String make1,String model,String colour1,String year1) throws InterruptedException {
		
		obj.comparedata(registration1,make1,model,colour1,year1);
	}

}
