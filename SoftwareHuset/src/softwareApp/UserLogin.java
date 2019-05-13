package softwareApp;
import java.util.ArrayList;
//Anton Schousen, Simon
import softwareDomain.Project;
import softwareDomain.User;
import softwarePersistence.*;
public class UserLogin 
{
	//Udarbejdet af Anton
	private static ArrayList<Project> nullAsProjectList = new ArrayList<Project>();
	private static ArrayList<Project> nullProjectList = new ArrayList<Project>();
	
	public static void registerUser(String userName) throws Exception
	{
		assert true; // precondition
		boolean userExist = checkifuserexist(userName);
		if (userName.matches("^[A-Z]*$") && userName.length() >=
				1 && userName.length() < 5 && userExist == false)
		{
			assert (userName.matches("^[A-Z]*$") && userName.length() >=
					1 && userName.length() < 5 && userExist == false); //Precondition
			User user = new User(userName,nullProjectList,
					nullAsProjectList);
			userManagement.addUser(user);
			assert (userManagement.companyList.contains(user)); //postcondition
		}
		else
		{
			throw new IllegalArgumentException("User name cannot contain numbers,"
					+ " and should have a length between one and four.");
		}
	}

	public static void loginUser(String userName) throws Exception
	{
		boolean userExist = checkifuserexist(userName);
		if(!(userExist))
		{
			throw new IllegalArgumentException("User does not exist");
		}
	}
	
	public static boolean checkifuserexist(String user)
	{
		return userManagement.companyList.stream().anyMatch(b-> b.USERNAME.matches(user));
	}
	
}
