
package com.challenge.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class baseclass {

		
		public static WebDriver driver;
		static String arg1="D:\\chromedriver.exe";
		
		public static void browseropen(String browser) {
			
			switch (browser) {
			
			case "chrome": 	
							System.setProperty("webdriver.chrome.driver", arg1);
							driver = new ChromeDriver();
				
							break;
				

			}
			driver.manage().window().maximize();
			driver.get("https://cartaxcheck.co.uk/");
			
		}
	}
			



