package softwareDomain;
import java.util.*;
public class User {
	//Udarbejdet af Victor
	public final String USERNAME;
	public ArrayList<Project> assignedProjects = new ArrayList<Project>();
	public ArrayList<Project> assistingProjects = new ArrayList<Project>();
	//private List<User> workWellWith;
	//private List<User> doNotWorkWellWith;
		
	public User(String userName, ArrayList<Project> assignedProjects, ArrayList<Project> assistingProjects)
	{
		this.USERNAME=userName;
		this.assignedProjects=assignedProjects;
		this.assistingProjects=assistingProjects;
		//this.workWellWith=workWellWith;
		//this.doNotWorkWellWith=doNotWorkWellWith;
	}
}
