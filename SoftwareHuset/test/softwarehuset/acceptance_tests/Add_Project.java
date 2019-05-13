package softwarehuset.acceptance_tests;

import static org.junit.Assert.assertEquals;

import softwarePersistence.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import softwareApp.*;
public class Add_Project {
	// Udarbejdet af Anton
	private String startDay,startMonth,startYear,endDay,endMonth,endYear,expectedTime;
	private String errorMessage;
	public Add_Project()
	{
		testData.removeAllData();
	}
	
	@Given("^a new project with start date \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" and end date \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" and expected time \"([^\"]*)\"$")
	public void aNewProjectWithStartDateAndEndDateAndExpectedTime(String startDay, String startMonth,
			String startYear, String endDay, String endMonth, String endYear, String expectedTime) {
		this.startDay = startDay;
		this.startMonth = startMonth;
		this.startYear = startYear;
		this.endDay = endDay;
		this.endMonth = endMonth;
		this.endYear = endYear;
		this.expectedTime = expectedTime;
	}
	
	@When("^users tries to add project$")
	public void usersTriesToAddProject() {
		try {
			AddProject.addProjectToSystem(startDay,startMonth,startYear,
					endDay, endMonth, endYear, expectedTime);
		} catch (Exception e)
		{
			errorMessage = e.getMessage();
		}
	}
	@Then("^and the project with the name \"([^\"]*)\" exist$")
	public void andTheProjectWithTheNameExist(String projectName) {
		assertEquals(true,projectManagement.projectList.stream().anyMatch(b-> b.name.matches(projectName)));
	}

	@Then("^and the project with the name \"([^\"]*)\" do not exist$")
	public void andTheProjectWithTheNameDoNotExist(String projectName) {
		assertEquals(false,projectManagement.projectList.stream().anyMatch(b-> b.name.matches(projectName)));
	
	}
	
	@Then("^get error message \"([^\"]*)\"$")
	public void getErrorMessage(String expectedError) {
		assertEquals(errorMessage,expectedError);
	}
	
}

