package softwareApp;

import softwareDomain.Project;
import softwareDomain.User;
import softwarePersistence.projectManagement;
import softwarePersistence.userManagement;

public class AddUserToActivity {

	//Udarbejdet af Simon
	public static void addUserToActivity(int projectIndex, int activityToModifyIndex, String userName)
	{
		User userToAdd;
		if(UserLogin.checkifuserexist(userName))
		{
			if(!checkIfUserIsInActivity(projectIndex,projectManagement.projectList.get(projectIndex).activities.get(activityToModifyIndex).name,userName))
			{
				for (int i=0; i<userManagement.companyList.size();i++)
				{
					if (userName.matches(userManagement.companyList.get(i).USERNAME))
					{
						userToAdd = userManagement.companyList.get(i);
						projectManagement.projectList.get(projectIndex).activities.get(activityToModifyIndex).employees.add(userToAdd);
						projectManagement.projectList.get(projectIndex).activities.get(activityToModifyIndex).contributions.add(projectManagement.projectList.get(projectIndex).activities.get(activityToModifyIndex).contributions.size(), 0);
					}
				}
			}
		}
		else
		{
			throw new IllegalArgumentException("User doesn't exist");
		}
	}
	
	//Udarbejdet af Simon
	public static boolean checkIfActivityExistInProject (Project projectToCheck, String activityName)
	{
		return projectToCheck.activities.stream().anyMatch(b-> b.name.matches(activityName));
	}
	//Udarbejdet af Christian
	public static int retrieveActivityIndexFromName(Project projectToCheck, String activityName)
	{
		for (int i=0; i<projectToCheck.activities.size(); i++)
		{
			if (projectToCheck.activities.get(i).name.matches(activityName))
				return i;
		}
		return -1;
	}
	//Udarbejdet af Christian
	public static boolean checkIfUserIsInActivity(int projectIndex, String activityName, String username)
	{
		int activityIndex=retrieveActivityIndexFromName(projectManagement.projectList.get(projectIndex), activityName);
		return projectManagement.projectList.get(projectIndex).activities.get(activityIndex).employees.stream().anyMatch(b ->b.USERNAME.matches(username));
	}
}
