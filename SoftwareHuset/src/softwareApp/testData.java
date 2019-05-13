//For generating test data.
package softwareApp;
import java.util.*;
import softwareDomain.*;
import softwarePersistence.*;
public class testData {
	private static User nullUser;
	private static ArrayList<User> nullUserList = new ArrayList<User>();
	private static ArrayList<Activity> nullActivityList = new ArrayList<Activity>();
	private static ArrayList<Project> nullProjectList = new ArrayList<Project>();
	private static ArrayList<Integer> nullContributionList = new ArrayList<Integer>();
	
	public static void removeAllData()
	{
		for (int i=0; i<projectManagement.projectList.size(); i++)
		{
			for (int j=projectManagement.projectList.get(i).activities.size()-1; j>-1; j--)
			projectManagement.projectList.get(i).activities.remove(j);
		}
	userManagement.companyList = new ArrayList<User>();
	projectManagement.projectList = new ArrayList<Project>();
	}
	
	public static void projectData()
	{
		Project project1 = new Project("190002","5/4-2019","10/9-2019",
		2000, 2500, nullUserList, nullUser, nullActivityList);
		projectManagement.addProject(project1);
		Project project2 = new Project("190003","9/4-2019","15/9-2019",
		42000, 5500, nullUserList, nullUser, nullActivityList);
		projectManagement.addProject(project2);
	}
	
	
	public static void userData()
	{
		User Lars_Midgaard = new User("LSMD",nullProjectList,
				nullProjectList);
		userManagement.addUser(Lars_Midgaard);
		userManagement.addProjectToUser(projectManagement.projectList.get(0), 
				Lars_Midgaard);
		
		User Pipi_Langstrompe = new User("PIPI",nullProjectList,
				projectManagement.projectList);
		userManagement.addUser(Pipi_Langstrompe);
		userManagement.addProjectToUser(projectManagement.projectList.get(0), 
				Pipi_Langstrompe);

		User Simon_Larsen = new User("SNLN",nullProjectList,
				nullProjectList);
		userManagement.addUser(Simon_Larsen);	
		userManagement.addProjectToUser(projectManagement.projectList.get(1),Simon_Larsen);
		
		
	}
	
	public static void activityData()
	{
		Activity housewarming = new Activity(projectManagement.projectList.get(1).name,"Housewarming","9/2-2001","9/2-2001",8,9,nullUserList, nullContributionList);
		activityManagement.addActivity(projectManagement.projectList.get(1), housewarming);
	}
}

