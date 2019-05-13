package softwareApp;

import java.util.ArrayList;
import softwareDomain.Activity;
import softwareDomain.User;
import softwarePersistence.*;

public class AddActivity {
	public static ArrayList<User> nullUserList = new ArrayList<User>();
	public static ArrayList<Integer> nullContributionList = new ArrayList<Integer>(); 
	
	//Udarbejdet Anton
	public static void addActivityToProject(int indexOfProject, int timeEstimate, String nameOfActivity, 
		String startDay, String startMonth, String startYear,
		String endDay, String endMonth, String endYear)
	{
		if (checkLegalInput(indexOfProject, timeEstimate, nameOfActivity, 
		startDay,  startMonth, startYear,
		 endDay, endMonth,  endYear))
		{
			String startDate = startDay+"/"+startMonth+"-"+startYear;
			String endDate = endDay+"/"+endMonth+"-"+endYear;
			Activity newActivity = new Activity(projectManagement.projectList.get(indexOfProject).name, nameOfActivity,
			startDate, endDate, timeEstimate, 0	,nullUserList, nullContributionList);
			activityManagement.addActivity(projectManagement.projectList.get(indexOfProject), newActivity);
		}
	}
	//Udarbejdet Christian
	public static boolean checkLegalInput(int indexOfProject, int timeEstimate, String nameOfActivity, 
			String startDay, String startMonth, String startYear,
			String endDay, String endMonth, String endYear) 
	{
		return ((checkLegalIndex(indexOfProject) && checkLegalTimeEstimate(timeEstimate) &&
		checkActivityName(nameOfActivity) && LegalDate.checkLegalDateFormat(startDay, startMonth, startYear)
		&& LegalDate.checkLegalDateFormat(endDay, endMonth, endYear) &&
		LegalDate.checkEndLaterThanStartDate(Integer.parseInt(startDay), Integer.parseInt(startMonth), 
				Integer.parseInt(startYear), Integer.parseInt(endDay), 
				Integer.parseInt(endMonth), Integer.parseInt(endYear))));
		
	}
	//Udarbejdet Victor
	public static boolean checkLegalIndex(int indexOfProject)
	{
		return(indexOfProject>0 && indexOfProject<projectManagement.projectList.size());
	}
	//Udarbejdet simon
	public static boolean checkLegalTimeEstimate(int timeEstimate)
	{
		return (timeEstimate>0);

	}
	//Udarbejdet Christian
	public static boolean checkActivityName(String activityName)
	{
		if (activityName.matches("Sickness") || activityName.matches("Holiday") || activityName.matches("Courses"))
		{
			throw new IllegalArgumentException("Illegal name for activity");
		}
		else
			return true;
	}
}
