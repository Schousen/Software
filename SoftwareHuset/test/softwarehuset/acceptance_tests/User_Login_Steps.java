package softwarehuset.acceptance_tests;
import static org.junit.Assert.assertEquals;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import softwareApp.*;
import softwarePersistence.projectManagement;

// Udarbejdet af Anton 
public class User_Login_Steps {
	
	private String userName;
	private String actualAnswer;
	private boolean succeedOr;
	public User_Login_Steps() {
		//The project with vacation, courses and sickness activities
		projectManagement.createDefaultProject();
		//Spawning test data. Executing phase shift
		testData.projectData();
		testData.activityData();
		testData.userData();
	}
	
	@Given("^a user with the user name \"([^\"]*)\"$")
	public void aUserWithTheUserName(String userName) {
		this.userName = userName;
	}

	@When("^the user tries to login$")
	public void theUserTriesToLogin() {
		
		try {
			UserLogin.loginUser(userName);
			succeedOr = true;
		} catch (Exception e) {
			actualAnswer = e.getMessage();
			succeedOr = false;
		}
	}

	@Then("^the user login succeeds$")
	public void theUserLoginSucceeds() {
		assertEquals(true,succeedOr);
	}
	
	@Then("^the user login fails, and get message \"([^\"]*)\"$")
	public void theUserLoginFailsAndGetMessage(String expectededmessage) {
		assertEquals(expectededmessage,actualAnswer);
	}
	
}
