package softwarePersistence;
import softwareDomain.*;
import java.util.*;
public class userManagement {
	//Udarbejdet af Anton
	
	public static ArrayList<User> companyList = new ArrayList<User>();
	
	public static void addUser(User userToAdd)
	{
		companyList.add( companyList.size(), userToAdd);
	}
	
	public static void addProjectToUser(Project projectToAdd, User userToAddTo)
	{
		userToAddTo.assignedProjects.add(userToAddTo.assignedProjects.size(), projectToAdd);
	}
}
