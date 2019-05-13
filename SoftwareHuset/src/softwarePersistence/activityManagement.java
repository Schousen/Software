package softwarePersistence;
import softwareDomain.*;

public class activityManagement 
{
	//Udarbejdet af Christian
	
	public static void addActivity(Project projectToModify, Activity activityToAdd)
	{
		projectToModify.activities.add(projectToModify.activities.size(), activityToAdd);
	}
	
	
	
}







