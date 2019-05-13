Feature: Add user to activity
	Description: Add user to an activity
	Actor: User
	Udarbejdet af victor
	
Scenario: Add user to activity succeed[1]
	Given A user with name "LSMD" and a project with index 1 with the activity "Housewarming"
	When user "LSMD" tries to be added to the activity "Housewarming" in the project with index 1
	Then the user "LSMD" is added to the activity "Housewarming" under project with index 1
	
Scenario: Add user to activity that does not exist fails[1]
	Given A user with name "KOOL" and a project with index 1 with the activity "Housewarming"
	When user "KOOL" tries to be added to the activity "Housewarming" in the project with index 1
	Then the system returns message "User doesn't exist" and the user is not added again.

	
