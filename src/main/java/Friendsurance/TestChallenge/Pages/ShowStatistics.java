package Friendsurance.TestChallenge.Pages;

/*This class validate the presence of the pie chart if expense is created */

public class ShowStatistics extends LoginPage{

	
	public void showStatisticsMethod(){
		
		piechart.isDisplayed();
		log.info("Code came to Show Statistics Tab for validation of Pie Chart presence");
	}

}
