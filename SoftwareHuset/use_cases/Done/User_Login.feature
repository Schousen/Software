Feature: User login
	Description: The user logs into the sytem
	Actor: User
	Udarbejdet af Anton
	
Scenario: user can login
	Given a user with the user name "LSMD"
	When the user tries to login
	Then the user login succeeds

	
Scenario: User cant login, cause of wrong user name(1)
	Given a user with the user name "ABC"
	When the user tries to login 
	Then the user login fails, and get message "User does not exist"
	
Scenario: User cant login, cause of wrong user name(2)
	Given a user with the user name "123"
	When the user tries to login
	Then the user login fails, and get message "User does not exist"
	
Scenario: User cant login, cause of wrong user name(3)
	Given a user with the user name "1%a"
	When the user tries to login
	Then the user login fails, and get message "User does not exist"
	
Scenario: User cant login, cause of wrong user name(4)
	Given a user with the user name ""
	When the user tries to login
	Then the user login fails, and get message "User does not exist"

Scenario: User cant login, cause of wrong user name(5)
	Given a user with the user name "a,b."
	When the user tries to login
	Then the user login fails, and get message "User does not exist"

Scenario: User cant login, cause of wrong user name(6)
	Given a user with the user name "LSMDA"
	When the user tries to login
	Then the user login fails, and get message "User does not exist"
	

