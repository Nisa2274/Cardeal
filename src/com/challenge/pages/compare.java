package com.challenge.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.challenge.base.baseclass;
import com.challenge.utility.utility;

public class compare extends baseclass{
	
    SoftAssert softAssert1 = new SoftAssert();
	
	@FindBy(xpath="//input[@id='vrm-input']")
	WebElement regnumber;
	
	@FindBy(xpath="//button[contains(@class,'jsx-3655351943')]")
	WebElement carcheck;
	
	@FindBy(xpath="//dt[contains(text(),'Registration')]//ancestor::dl/dd")
	WebElement registration;
	
	@FindBy(xpath="//dt[contains(text(),'Make')]//ancestor::dl/dd")
	WebElement make;
	
	@FindBy(xpath="//dt[contains(text(),'Model')]//ancestor::dl/dd")
	WebElement model;
	
	@FindBy(xpath="//dt[contains(text(),'Colour')]//ancestor::dl/dd")
	WebElement colour;
	
	@FindBy(xpath="//dt[contains(text(),'Year')]//ancestor::dl/dd")
	WebElement year;
	
	@FindBy(xpath="//p[contains(@class,'jsx-2893772498')]")
	WebElement msg;

	
	public compare() {

		PageFactory.initElements(driver, this);
	}
	
	public void comparedata(String registration1,String make1,String model1,String colour1,String year1) throws InterruptedException {
		
		utility.explicit(regnumber);
		regnumber.clear();
		regnumber.sendKeys(registration1);
		utility.explicit(carcheck);
		carcheck.click();
		
			try {
			
				utility.explicit(registration);
				Thread.sleep(2000);
				/*Assert.assertEquals(registration1,registration.getText());
				Assert.assertEquals(make1,make.getText());
				Assert.assertEquals(model1,model.getText());
				Assert.assertEquals(colour1,colour.getText());
				Assert.assertEquals(year1,year.getText());*/
				softAssert1.assertEquals(registration1,registration.getText());
				softAssert1.assertEquals(make1,make.getText());
				softAssert1.assertEquals(model1,model.getText());
				softAssert1.assertEquals(colour1,colour.getText());
				softAssert1.assertEquals(year1,year.getText());
				driver.navigate().back();
				softAssert1.assertAll();
				
			
			} catch (Exception e) {
			
			utility.explicit(msg);
			String error=msg.getText();
			if(error.contains("Please check the registration and try again")) {
				
				System.out.println("Invalid number"+" "+registration1);
			}
			
		}
		
	}
}
