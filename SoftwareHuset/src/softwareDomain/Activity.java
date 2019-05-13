package softwareDomain;
import java.util.*;
public class Activity {
	//Udarbejdet af Christian
	public String projectName;
	public String name;
	public String startDate;
	public String endDate;
	public int timeEstimate;
	public int timeExpenditure;
	public ArrayList<User> employees = new ArrayList<User>();
	public ArrayList<Integer> contributions = new ArrayList<Integer>(); 

	public Activity(String projectName, String name, String startDate, String endDate, int timeEstimate, int timeExpenditure, ArrayList<User> employees, ArrayList<Integer> contriList)
	{
		this.projectName=projectName;
		this.name=name;
		this.startDate=startDate;
		this.endDate=endDate;
		this.timeEstimate=timeEstimate;
		this.timeExpenditure=timeExpenditure;
		this.employees=employees;
		this.contributions=contriList;
	}
	
}
