package softwarehuset.acceptance_tests;
import static org.junit.Assert.assertEquals;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import softwareApp.*;
import softwarePersistence.*;
public class User_Registration {
	// Udarbejdet af Simon

	private String userName;
	private String actualAnswer;
	private boolean succeedOr;
	public User_Registration() {
		
		testData.removeAllData();
		//The project with vacation, courses and sickness activities
		projectManagement.createDefaultProject();
		//Spawning test data. Executing phase shift
		testData.projectData();
		testData.activityData();
		testData.userData();
	}
	
	@Given("^a new user with id \"([^\"]*)\"$")
	public void aNewUserWithId(String userName) {
		this.userName = userName;
	}

	@When("^users tries to be registred$")
	public void usersTriesToBeRegistred() {
		try {
			UserLogin.registerUser(userName);
			succeedOr = true;
		} catch (Exception e) {
			actualAnswer = e.getMessage();
			succeedOr = false;
		}
	}

	@Then("^the user registration succeeds$")
	public void theUserRegistrationSucceeds() {
		assertEquals(true,succeedOr);
	}

	@Then("^the user registration fails, and get message \"([^\"]*)\"$")
	public void theUserRegistrationFailsAndGetMessage(String answer) {
		assertEquals(answer,actualAnswer);
	}

	@Then("^the user \"([^\"]*)\" can be found in the companylist$")
	public void theUserCanBeFoundInTheCompanylist(String userName) {
		assertEquals(true,UserLogin.checkifuserexist(userName));
	}

	@Then("^the user \"([^\"]*)\" cannot be found in the companylist$")
	public void theUserCannotBeFoundInTheCompanylist(String userName) {
	assertEquals(false,UserLogin.checkifuserexist(userName));
	}

}
