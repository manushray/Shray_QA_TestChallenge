package Friendsurance.TestChallenge;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Friendsurance.TestChallenge.Base.Base;
import Friendsurance.TestChallenge.Pages.AddExpense;
import Friendsurance.TestChallenge.Pages.EditAccount;
import Friendsurance.TestChallenge.Pages.ListCategory;
import Friendsurance.TestChallenge.Pages.ListExpense;
import Friendsurance.TestChallenge.Pages.LoginPage;
import Friendsurance.TestChallenge.Pages.NewRegistration;
import Friendsurance.TestChallenge.Pages.ShowStatistics;
/*This Class has all the Test data, Assertions and a common method which is used to count the category 
 * of the application */

public class AppTest extends Base
{
   LoginPage loginpage;
   NewRegistration newregistration;
   ListCategory listcategory;
   AddExpense addexpense;
   ListExpense listexpense;
   ShowStatistics showstat;
   EditAccount editaccnt;
   
   private  String[] addexpenseCategory=prop.getProperty("Category").split(",");
   private  String[] addexpenseDay=prop.getProperty("Day").split(",");
   private  String[] addexpenseMonth=prop.getProperty("Month").split(",");
   private  String[] addexpenseYear=prop.getProperty("Year").split(",");
   private  String[] addexpenseAmount=prop.getProperty("Amount").split(",");
   private  String[] addexpenseReason=prop.getProperty("Reason").split(",");
   private  String[] strcategory=prop.getProperty("category").split(",");
   private  int count;
   private  int count1;
   private  boolean flag;
   private String url;
   
   /*This Method is used to call the method from the Base class where the drivers,location of config file  are initialized and opening of URL is done  */
   @BeforeClass
   	public void beforeclassmethod() throws Exception{
	   initialisation();
	   loginpage=new LoginPage();
	   newregistration=new NewRegistration();
	   listcategory=new ListCategory();
	   addexpense=new AddExpense();
	   listexpense=new ListExpense();
	   showstat=new ShowStatistics();
	   editaccnt=new EditAccount();
   	}
   
    public AppTest()
    {
        super();
    }

   /*Actual Test cases starts from here I have used Priority tag to run my test cases can also use other annotation like Depend etc*/ 
   /*This method is used to test login page*/
    @Test(priority=1)
    public void loginPageTest() throws Exception {
    	String text=loginpage.loginmethod(prop.getProperty("new_username"),prop.getProperty("newuser_pass"));
    	if(text.contains("new")){
    	Assert.assertEquals(text,"new user");
    	}
    	else{
    	Assert.assertEquals(text,"existing user");
    	}
    	log.info("Test Case 1 got passed");
    }

    /*This method is used to test Registration page*/
    @Test(priority=2)
    public void newRegistrationMethodTest() {
    	loginpage.newregisMethod();
    	flag=newregistration.newRegistrationMethod(prop.getProperty("new_username"),prop.getProperty("newuser_pass"));
    	Assert.assertEquals(true, flag);
    	log.info("Test Case 2 got passed");
    }
    
    /*This method is used to test List Category tab*/
    @Test(priority=3)
    public void listCategoryMethodTest() {
    	loginpage.listCategoryMethod();
    	listcategory.listCategoryMethod();
    	listcategory.listCategoryEditMethod();
    	flag=listcategory.listCategoryDeleteMethod();
    	Assert.assertEquals(flag, true);
    	log.info("Test Case 3 got passed");
    }
    
    /*This method is used to test Add Expense Tab*/
    @Test(priority=4)
    public void addExpenseMethodTest() {
    	
    	for(int i=0;i<addexpenseCategory.length;i++)
    	{
    	loginpage.addExpenseMethod();
    	 url=addexpense.addexpenseMethod(addexpenseDay[i],addexpenseMonth[i],addexpenseYear[i],addexpenseCategory[i],addexpenseAmount[i],addexpenseReason[i]);
    	}
    	if(url.contains("listexpense")){
    	Assert.assertTrue(true);
    	}else{
    	Assert.assertFalse(true);	
    	}
    	log.info("Test Case 4 got passed");
    }

    /*This method is used to test List Expense tab*/
    @Test(priority=5)
    public void listExpenseMethodTest() {
    	
    	countingCategoryMethod(addexpenseCategory.length,"listExpenseMethodTest" );
    	Assert.assertEquals(count1,addexpenseCategory.length);
    	log.info("Test Case 5 got passed");
    }
    
    /*This method is used to test Show Statistics page*/
    @Test(priority=6)
    public void showStatisticsMethodTest(){
    	 loginpage.showstatisticsMethod();
    	 countingCategoryMethod(strcategory.length,"showStatisticsMethodTest");
    	 Assert.assertEquals(count1, strcategory.length-1);
    	 log.info("Test Case 6 got passed");
    	
    }
    
    /*This method is used to test Edit Account tab*/
    @Test(priority=7)
    public void editAccountMethodTest() {
    	loginpage.editAccountMethod();
    	url= editaccnt.editAccountPageMethod();
    	if(url.contains("listexpense")){
    	Assert.assertTrue(true);
    	}else{
    	Assert.assertFalse(true);	
    	}
    	log.info("Test Case 7 got passed");
    }
    
    /*This method is used to test logout button*/
    @Test(priority=8)
    public void logoutMethodTest() throws Exception{
    	
    	url= loginpage.logoutMethod();
    	if(url.contains("index")){
    	Assert.assertTrue(true);
    	}else{
    	Assert.assertFalse(true);	
    	}
    	log.info("Test Case 8 got passed");
    }
    
    public void countingCategoryMethod(int len,String methodname){
    	
    	count=0;
    	count1=0;
    	for(int i=0;i<len;i++)
     	{
     	if(methodname.equals("listExpenseMethodTest")){
     	 count=listexpense.listexpenseMethod(addexpenseCategory[i]);
     	 count1+=count;
     	}else{
     		count=listexpense.listexpenseMethod(strcategory[i]);
        	 count1+=count;
     	}
     	
     	}
    	
    }
    
    @AfterClass
    public void teardownclass(){
    	driver.quit();
    }
	
}
