package softwarePersistence;
import softwareDomain.*;
import java.util.ArrayList;
	
public class projectManagement 
{
	//Udarbejdet af Victor
	private static ArrayList<User> nullUserList = new ArrayList<User>();
	private static User nullUser;
	private static ArrayList<Integer> nullContributionList = new ArrayList<Integer>();
	public static ArrayList<Project> projectList = new ArrayList<Project>();
	private static ArrayList<Activity> nullActivityList = new ArrayList<Activity>();
	public static Project Default = new Project(
			"Default0001","N/A","N/A",
	-1, 0, userManagement.companyList, nullUser, nullActivityList);
	
	public static void addProject(Project projectToAdd)
	{
		projectList.add( projectList.size(), projectToAdd);
	}
	
	public static void createDefaultProject()
	{
		addProject(Default);
		Activity Sickness = new Activity(projectManagement.projectList.get(0).name,"Sickness","N/A","N/A",-1,0,nullUserList,nullContributionList);
		Activity Holiday = new Activity(projectManagement.projectList.get(0).name,"Holiday","N/A","N/A",-1,0,nullUserList,nullContributionList);
		Activity Courses = new Activity(projectManagement.projectList.get(0).name,"Courses","N/A","N/A",-1,0,nullUserList,nullContributionList);
		activityManagement.addActivity(Default, Sickness);
		activityManagement.addActivity(Default, Holiday);
		activityManagement.addActivity(Default, Courses);
	}
}
