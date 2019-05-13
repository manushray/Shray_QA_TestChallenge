package Friendsurance.TestChallenge.Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

/*This class automate the functionalities of Add Expense Tab like adding of Date, Category , Amount & Reason. 
 * This code is dynamic and flexible to take the input according to the user(parameter should be passed through the config properties file and work accordingly */
public class AddExpense extends LoginPage{
	
	public String addexpenseMethod(String day, String Month, String year, String category,String amnt,String reason){
		addexpensedaybtn.clear();
		addexpensedaybtn.sendKeys(day);
		addexpensemonthbtn.clear();
		addexpensemonthbtn.sendKeys(Month);
		addexpenseyearbtn.clear();
		addexpenseyearbtn.sendKeys(year);
		addexpensecategorybtn.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//This line click the Category dynamically depend upon the input which user has given in the Test class
		driver.findElement(By.xpath("//option[contains(text(),'"+category+"')]")).click();
		addexpenseamntbtn.sendKeys(amnt);
		addexpensereasonbtn.sendKeys(reason);
		loginbtn.click();
		log.info("User has successfully perform the activity in  Add Expense Tab");
		return driver.getCurrentUrl();
	}

}
