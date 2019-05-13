package softwareDomain;
import java.util.*;
public class Project {
	//Udarbejdet af Simon
	public String name;
	public String startDate;
	public String endDate;
	public int timeEstimate;
	public int timeExpenditure;
	public ArrayList<User> employees = new ArrayList<User>();
	public ArrayList<Activity> activities = new ArrayList<Activity>();

	public Project(String name, String startDate, String endDate, int timeEstimate, int timeExpenditure, ArrayList<User> employees, User projectLeader, ArrayList<Activity> activities)
	{
		this.name=name;
		this.startDate=startDate;
		this.endDate=endDate;
		this.timeEstimate=timeEstimate;
		this.timeExpenditure=timeExpenditure;
		this.employees=employees;
		this.activities=activities;
	}



}
