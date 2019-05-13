package softwarehuset.acceptance_tests;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Register_User {

	
	
	@Given("^a user \"([^\"]*)\" is logged in, and the user have worked (\\d+) hours on the activity \"([^\"]*)\"$")
	public void aUserIsLoggedInAndTheUserHaveWorkedHoursOnTheActivity(String arg1, int arg2, String arg3) throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^the user tries to register time$")
	public void theUserTriesToRegisterTime() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^the time (\\d+) is registed under the user \"([^\"]*)\" in the activity \"([^\"]*)\"$")
	public void theTimeIsRegistedUnderTheUserInTheActivity(int arg1, String arg2, String arg3) throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^the time (\\d+) is not registed under the user \"([^\"]*)\" in the activity \"([^\"]*)\"$")
	public void theTimeIsNotRegistedUnderTheUserInTheActivity(int arg1, String arg2, String arg3) throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Given("^a user \"([^\"]*)\" is logged in, and the user have worked \"([^\"]*)\" hours on the activity \"([^\"]*)\"$")
	public void aUserIsLoggedInAndTheUserHaveWorkedHoursOnTheActivity(String arg1, String arg2, String arg3) throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^the time \"([^\"]*)\" is not registed under the user \"([^\"]*)\" in the activity \"([^\"]*)\"$")
	public void theTimeIsNotRegistedUnderTheUserInTheActivity(String arg1, String arg2, String arg3) throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
}
