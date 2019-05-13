package Friendsurance.TestChallenge.Pages;

import java.util.concurrent.TimeUnit;

/*This class create new user which will take username & password to create an account */
public class NewRegistration extends LoginPage{

	
	
	public boolean newRegistrationMethod(String username,String passwrd){
		
		login.clear();
		login.sendKeys(username);
		pwd1.clear();
		pwd1.sendKeys(passwrd);
		pwd2.sendKeys(passwrd);
		loginbtn.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		log.info("Code came to new registration link where user can register itself to the application");
		if(accntlink.isDisplayed())
			return true;
		else return false;
		
	}
	
}
