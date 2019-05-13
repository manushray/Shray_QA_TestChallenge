package Friendsurance.TestChallenge.Pages;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/*This class check/list all the expense created in the Add Expense tab */

public class ListExpense extends LoginPage{

	
	
	
	public int listexpenseMethod(String category) {
		
	int count=0;	
	List<WebElement> elements = driver.findElements(By.tagName("td"));
	for(WebElement wb : elements) {
		if(wb.getText().contains(category)) {
			count++;
			break;
			
		}
	}
	log.info("Code came to List Category Tab for calculate all the available category present in the tab");
	return count;
	}
}
