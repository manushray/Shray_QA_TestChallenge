package Friendsurance.TestChallenge.Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Friendsurance.TestChallenge.Base.Base;
/* This class is worked as primary class for all the classes present under Pages Package
 *  which contains all the web element of the application using Page Object Model also all the application tabs links  */
public class LoginPage extends Base{

	
	//Used page Object Model for identifying the elements
		@FindBy(id="login")
		WebElement login;
		
		@FindBy(id="password")
		WebElement pwd;
		
		@FindBy(id="submit")
		WebElement loginbtn;
		
		@FindBy(xpath="//div[contains(text(),'unknown login or wrong password')]")
		WebElement unkwnmsg;
		
		@FindBy(css="body > div > div > a")
		WebElement newuser;
		
		@FindBy(id="editaccount")
		WebElement accntlink;
		
		@FindBy(id="password1")
		WebElement pwd1;
		
		@FindBy(id="password2")
		WebElement pwd2;
		
		@FindBy(id="go_list_categories")
		WebElement categorybtn;
		
		@FindBy(id="go_add_category")
		WebElement categoryAddbtn;
		
		@FindBy(id="name")
		WebElement categoryaddname;
		
		@FindBy(xpath="//img[contains(@title,'edit category')]")
		WebElement editcategorybtn;
		
		@FindBy(xpath="//img[contains(@title,'delete category')]")
		WebElement deletecategorybtn;
		
		@FindBy(id="go_add_expense")
		WebElement addexpensebtn;
		
		@FindBy(id="day")
		WebElement addexpensedaybtn;
		
		@FindBy(id="month")
		WebElement addexpensemonthbtn;
		
		@FindBy(id="year")
		WebElement addexpenseyearbtn;
		
		@FindBy(id="category")
		WebElement addexpensecategorybtn;
		
		@FindBy(xpath="//option[contains(text(),'Movie')]")
		WebElement addexpensecategorylistbtn;
		
		@FindBy(xpath="//option[contains(text(),'Food')]")
		WebElement addexpensecategorylist2btn;
		
		
		@FindBy(id="amount")
		WebElement addexpenseamntbtn;
		
		@FindBy(id="reason")
		WebElement addexpensereasonbtn;
		
		@FindBy(id="go_show_statistics")
		WebElement showstatbtn;
		
		@FindBy(className="ct-slice-pie")
		WebElement piechart;
		
		@FindBy(id="newpassword1")
		WebElement newpwd1;
		
		@FindBy(id="newpassword2")
		WebElement newpwd2;
		
		@FindBy(id="logout")
		WebElement logout;
		
		//Initializing the Page Object
		public LoginPage() {
			
			PageFactory.initElements(driver, this);//this is pointing to current class object
		}
		
		//Clicking Register tab
		public void newregisMethod(){
			newuser.click();	
			log.info("Application has gone through the New User Registration Tab successfully");
		}
		
		//Clicking List Category tab
		public void listCategoryMethod(){
			categorybtn.click();
			log.info("Application has gone through the List Category tab successfully");
		}
		
		//Clicking on the Add Expense tab
		public void addExpenseMethod(){
			addexpensebtn.click();
			log.info("Application has gone through the Add Expense tab successfully");
		}
		
		//Clicking on the Show Statistics tab
		public void showstatisticsMethod(){
			showstatbtn.click();
			log.info("Application has gone through the show statistics tab successfully");
		}
		
		//Clicking on the Edit Account tab
		public void editAccountMethod(){
			accntlink.click();
			log.info("Application has gone through the edit Account tab successfully");
		}
		
		//Clicking on the logout link
		public String logoutMethod(){
			logout.click();
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			log.info("Application has gone through the logout link successfully");
			return driver.getCurrentUrl();
		}
		
		/*This method will take the username,password from the Test class and click on the submit button after which it will check whether the 
		 * user is the new User or the existing one*/
		public String loginmethod(String username, String passwrd) throws Exception {
			boolean flag=false;
			login.clear();
			login.sendKeys(username);
			pwd.clear();
			pwd.sendKeys(passwrd);
			loginbtn.click();
			log.info("Application has gone through the login page tab successfully");
			flag=waitForElement(driver,unkwnmsg);
			if(flag==false){
				accntlink.isDisplayed();
				log.info("User has successfully logged into the applciation, user existed in the application");
				return "existing user";
			}
			else
				log.info("New User trying to logging into the application");
				return "new user";		
			
		}
	
}
