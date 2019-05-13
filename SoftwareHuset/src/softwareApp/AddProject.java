package softwareApp;

import java.util.ArrayList;

import softwareDomain.Activity;
import softwareDomain.Project;
import softwareDomain.User;
import softwarePersistence.*;

public class AddProject {
	
	private static User nullUser;
	private static ArrayList<User> nullUserList = new ArrayList<User>();
	private static ArrayList<Activity> nullActivityList = new ArrayList<Activity>();
	
	//Udarbejdet af Anton
	public static void addProjectToSystem(String startDay, String startMonth, String startYear,
			String endDay, String endMonth, String endYear, String time)
	{
		assert true; //precondition
		if (checkLegalInput(startDay,startMonth,  startYear,
				 endDay, endMonth, endYear, time))
		{
			assert startDay!=null && startDay.length()==2 && startMonth!=null &&
					startMonth.length()==2 && startYear!=null && startYear.length()==4;  // precondtion
			assert endDay!=null && endDay.length()==2 && endMonth!=null &&
					endMonth.length()==2 && endYear!=null && endYear.length()==4; // precondition
			assert time !=null; //precondition
			String name = startYear.substring(2)+"000"+(projectManagement.projectList.size()+1);
			String startDate = startDay+"/"+startMonth+"-"+startYear;
			String endDate = endDay+"/"+endMonth+"-"+endYear;
			Project newProject = new Project(name,startDate,endDate,
					0, Integer.parseInt(time), nullUserList, nullUser, nullActivityList);
					projectManagement.addProject(newProject);
			assert projectManagement.projectList.contains(newProject);  //postCondition
		}
	}
	
	//Udarbejdet af Victor
	private static boolean checkLegalInput(String startDay, String startMonth, String startYear, String endDay,
			String endMonth, String endYear, String time) {
		return (LegalDate.checkLegalDateFormat(startDay,startMonth,startYear)
				&& LegalDate.checkLegalDateFormat(endDay,endMonth,endYear) && 
				LegalDate.checkEndLaterThanStartDate(Integer.parseInt(startDay),Integer.parseInt(startMonth)
						,Integer.parseInt(startYear),Integer.parseInt(endDay),Integer.parseInt(endMonth)
						,Integer.parseInt(endYear)) && checkLegalExpectedTime(time));

	}
	
	//Udarbejdet af Victor
	private static boolean checkLegalExpectedTime(String time) {
		if (Integer.parseInt(time)>0) 
		{
			return true;
		}
		throw new IllegalArgumentException("The expected time to complete a project must be more than 0");
	}
}
