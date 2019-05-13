package Friendsurance.TestChallenge.Pages;


/*This class create category,check/list all the category,edit and delete functionality in the List Category tab */
public class ListCategory extends LoginPage {


	//This method will add the category , which can be n number depend how many is mentioned in the config file
public void listCategoryMethod(){
	String [] strcategory=prop.getProperty("category").split(",");
	for(int i=0;i<strcategory.length;i++){
	categoryAddbtn.click();
	categoryaddname.sendKeys(strcategory[i]);
	loginbtn.click();
	log.info("Code came to List Category Tab for adding the Category");
	}
	
}

//To validate the Edit functionality present in the List Category tab
public void listCategoryEditMethod(){
	
	editcategorybtn.click();
	categoryaddname.clear();
	categoryaddname.sendKeys(prop.getProperty("editedCategoryName"));
	loginbtn.click();
	log.info("Code came to List Category Tab for edit the existed Category");
}

//To validate the Delete functionality present in the List Category tab
public boolean listCategoryDeleteMethod(){
	deletecategorybtn.click();
	driver.switchTo().alert().accept();
	log.info("Code came to handle the delete confirmation pop-up in Category");
	return true;
}


}
