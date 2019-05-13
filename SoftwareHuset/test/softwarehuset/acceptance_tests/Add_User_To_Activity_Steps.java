package softwarehuset.acceptance_tests;

import softwareApp.*;
import java.util.ArrayList;
import softwareDomain.*;
import softwarePersistence.*;
import static org.junit.Assert.assertEquals;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
public class Add_User_To_Activity_Steps {
	//Udarbjdet af Victor
	
	private String exceptionAnswer;
	public Add_User_To_Activity_Steps()
	{
		testData.removeAllData();
		//The project with vacation, courses and sickness activities
		projectManagement.createDefaultProject();
		//Spawning test data. Executing phase shift
		testData.projectData();
		testData.activityData();
		testData.userData();
		//testData.addTestToActivity();
	}
	String userName, activityName;
	int projectIndex;
	ArrayList<Project> nullProjectList = new ArrayList<Project>();
	
	@Given("^A user with name \"([^\"]*)\" and a project with index (\\d+) with the activity \"([^\"]*)\"$")
	public void aUserWithNameAndAProjectWithIndexWithTheActivity(String userName, int projectIndex, String activityName)
	{
		this.userName = userName;
		this.projectIndex = projectIndex;
		this.activityName = activityName;
	}

	@When("^user \"([^\"]*)\" tries to be added to the activity \"([^\"]*)\" in the project with index (\\d+)$")
	public void userTriesToBeAddedToTheActivityInTheProjectWithIndex(String userName, String activityName, int projectIndex) 
	{
		try {
			AddUserToActivity.addUserToActivity(projectIndex, AddUserToActivity.retrieveActivityIndexFromName(projectManagement.projectList.get(projectIndex), activityName), userName);
		}
		catch (Exception e)
		{
			exceptionAnswer =e.getMessage();
		}
	}
	@Then("^the user \"([^\"]*)\" is added to the activity \"([^\"]*)\" under project with index (\\d+)$")
	public void theUserIsAddedToTheActivityUnderProjectWithIndex(String userName, String activityName, int projectIndex) 
	{
		assertEquals(true,AddUserToActivity.checkIfUserIsInActivity(projectIndex, activityName, userName));
	}

	@Then("^the system returns message \"([^\"]*)\" and the user is not added again\\.$")
	public void theSystemReturnsMessageAndTheUserIsNotAddedAgain(String message) 
	{
		assertEquals(exceptionAnswer,message);
	}

}