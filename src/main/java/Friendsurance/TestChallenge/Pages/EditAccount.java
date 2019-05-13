package Friendsurance.TestChallenge.Pages;

import java.util.concurrent.TimeUnit;

/*This class change the password with the new one which can be passed through the config properties file*/
public class EditAccount extends LoginPage{

	public String editAccountPageMethod(){
		pwd.sendKeys(prop.getProperty("newuser_pass"));
		newpwd1.sendKeys(prop.getProperty("newpassword"));
		newpwd2.sendKeys(prop.getProperty("newpassword"));
		loginbtn.click();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		log.info("User has successfully perform the activity in Edit Account Tab");
		return driver.getCurrentUrl();
	}
}
