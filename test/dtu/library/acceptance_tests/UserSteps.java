package dtu.library.acceptance_tests;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dtu.library.app.LibraryApp;
import dtu.library.domain.Address;
import dtu.library.domain.User;

public class UserSteps {
	
	private LibraryApp libraryApp;
	private User user;
	private Address address;
	private ErrorMessageHolder errorMessage;
	public UserHelper helper;
	private int fine;
	
	public UserSteps(LibraryApp libraryApp, ErrorMessageHolder errorMessage, UserHelper helper) {
		this.libraryApp = libraryApp;
		this.errorMessage = errorMessage;
		this.helper = helper;
	}
	
	@Given("^there is a user with CPR \"([^\"]*)\", name \"([^\"]*)\", e-mail \"([^\"]*)\"$")
	public void thereIsAUserWithCPRNameEMail(String cpr, String name, String email) throws Exception {
		user = new User(cpr,name,email);
		assertThat(user.getCpr(),is(equalTo(cpr)));
		assertThat(user.getName(),is(equalTo(name)));
		assertThat(user.getEmail(),is(equalTo(email)));
	}
	
	@Given("^the user has address street \"([^\"]*)\", post code (\\d+), and city \"([^\"]*)\"$")
	public void theUserHasAddressWithStreetPostCodeAndCity(String street, int postCode, String city) throws Exception {
		address = new Address(street,postCode,city);
		assertThat(address.getStreet(),is(equalTo(street)));
		assertThat(address.getPostCode(),is(equalTo(postCode)));
		assertThat(address.getCity(),is(equalTo(city)));
		user.setAddress(address);
		assertThat(user.getAddress(),is(sameInstance(address)));
	}
	
	@When("^the administrator registers the user(?: again|)$")
	public void theAdministratorRegistersTheUser() throws Exception {
		try {
			libraryApp.registerUser(user);
		} catch (Exception e) {
			errorMessage.setErrorMessage(e.getMessage());
		}
	}
	
	@Then("^the user is a registered user of the library$")
	public void theUserIsARegisteredUserOfTheLibrary() throws Exception {
	    Optional<User> usr = libraryApp.getUsersStream().findFirst();
	    assertTrue(usr.isPresent());
	    User u = usr.get();
	    assertThat(u.getName(), is(user.getName()));
	    assertThat(u.getEmail(), is(user.getEmail()));
	}
	
	@Given("^a user is registered with the library$")
	public void aUserIsRegisteredWithTheLibrary() throws Exception {
	    user = helper.getUser();
	    libraryApp.adminLogin("adminadmin");
	    libraryApp.registerUser(user);
	    libraryApp.adminLogout();
	}
	
	@Given("^a user is not registered with the library$")
	public void aUserIsNotRegisteredWithTheLibrary() throws Exception {
		user = helper.getUser();
	}

	
	@Then("^the user has overdue books$")
	public void theUserHasOverdueBooks() throws Exception {
		assertThat(libraryApp.userHasOverdueMedia(helper.getUser()),is(true));
	}
	
	@Then("^the user has overdue CDs$")
	public void theUserHasOverdueCDs() throws Exception {
		assertThat(libraryApp.userHasOverdueMedia(helper.getUser()),is(true));
	}



	@Then("^the user has no overdue books$")
	public void theUserHasNoOverdueBooks() throws Exception {
		assertThat(libraryApp.userHasOverdueMedia(helper.getUser()),is(false));
	}

	@Then("^the user has to pay a fine of (\\d+) DKK$")
	public void theUserHasToPayAFineOfDKK(double fine) throws Exception {
		assertThat(libraryApp.getFineForUser(helper.getUser()),is(equalTo(fine)));
	}

	@Then("^the user has to pay no fine$")
	public void theUserHasToPayNoFine() throws Exception {
		theUserHasToPayAFineOfDKK(0);
	}
	
	@Given("^the fine for one overdue book is (\\d+) DKK$")
	public void theFineForOneOverdueBookIsDKK(int fine) throws Exception {
		this.fine = fine;
	}
	
	@When("^the administrator unregisters that user$")
	public void theAdministratorUnregistersThatUser() throws Exception {
		try {
			libraryApp.unregister(helper.getUser());
		} catch (Exception e) {
			errorMessage.setErrorMessage(e.getMessage());
		}
	}

	@Then("^the user is not registered with the library$")
	public void theUserIsNotRegisteredWithTheLibrary() throws Exception {
		assertFalse(libraryApp.getUsersStream()
				.anyMatch(u -> u.getCpr().equals(helper.getUser().getCpr())));
	}
	
	@Then("^the user is still registered with the library$")
	public void theUserIsStillRegisteredWithTheLibrary() throws Exception {
		assertTrue(libraryApp.getUsersStream()
				.anyMatch(u -> u.getCpr().equals(helper.getUser().getCpr())));
	}
	
}

