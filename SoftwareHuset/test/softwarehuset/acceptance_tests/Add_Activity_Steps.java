package softwarehuset.acceptance_tests;

import static org.junit.Assert.assertEquals;
import softwarePersistence.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import softwareApp.*;
public class Add_Activity_Steps {
	//Udarbejdet af Christian
	private String activityName, startDay,startMonth,startYear,endDay,endMonth,endYear,expectedTime;
	private String errorMessage;
	public Add_Activity_Steps()
	{
		testData.removeAllData();
		//The project with vacation, courses and sickness activities
		projectManagement.createDefaultProject();
		//Spawning test data. Executing phase shift
		testData.projectData();
		testData.activityData();
		testData.userData();
	}
	
	@Given("^an activity with name \"([^\"]*)\" start date \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" and end date \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" and expected time \"([^\"]*)\"$")
	public void anActivityWithNameStartDateAndEndDateAndExpectedTime(String activityName, 
			String startDay, String startMonth, String startYear, String endDay, 
			String endMonth, String endYear, String expectedTime) {
		this.activityName = activityName;
		this.startDay = startDay;
		this.startMonth = startMonth;
		this.startYear = startYear;
		this.endDay = endDay;
		this.endMonth = endMonth;
		this.endYear = endYear;
		this.expectedTime = expectedTime;
	}

	@When("^user tries to add activity to project with index (\\d+)$")
	public void userTriesToAddActivityToProjectWithIndex(int projectIndex) {
		try {
			AddActivity.addActivityToProject(projectIndex,Integer.parseInt(expectedTime), activityName, 
					startDay, startMonth, startYear, 
					endDay, endMonth, endYear);
		} catch (Exception e) {
			errorMessage = e.getMessage();
		}
		
	}
	
	@Then("^the activity with name \"([^\"]*)\" is added to project with index (\\d+)$")
	public void theActivityWithNameIsAddedToProjectWithIndex(String activityName, int projectIndex)  {
		assertEquals(true, AddUserToActivity.checkIfActivityExistInProject(projectManagement.projectList.get(projectIndex), activityName));
	}

	@Then("^the activity with name \"([^\"]*)\" is not added to project with index (\\d+)$")
	public void theActivityWithNameIsNotAddedToProjectWithIndex(String activityName, int projectIndex) {
		assertEquals(false, AddUserToActivity.checkIfActivityExistInProject(projectManagement.projectList.get(projectIndex), activityName));
	}

	@Then("^get the message \"([^\"]*)\"$")
	public void getTheMessage(String expectedErrorMessage) {
		assertEquals(expectedErrorMessage,errorMessage);
	}
}