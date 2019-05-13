Feature: User Registration
	Description: User is registrated to system
	Actor: User
	Udarbejdet af Simon
	
Scenario: User registration succeeds
	Given a new user with id "ABCD"
	When users tries to be registred
	Then the user registration succeeds
	And the user "ABCD" can be found in the companylist
	
Scenario: User registration succeeds
	Given a new user with id "CDF"
	When users tries to be registred
	Then the user registration succeeds
	And the user "CDF" can be found in the companylist
	
Scenario: User registration succeeds
	Given a new user with id "AB"
	When users tries to be registred
	Then the user registration succeeds
	And the user "AB" can be found in the companylist
	
Scenario: User registration succeeds
	Given a new user with id "A"
	When users tries to be registred
	Then the user registration succeeds
	And the user "A" can be found in the companylist

Scenario: User registration fails(1)
	Given a new user with id "abcd"
	When users tries to be registred
	Then the user registration fails, and get message "User name cannot contain numbers, and should have a length between one and four."
	And the user "abcd" cannot be found in the companylist
	
Scenario: User registration fails(2)
	Given a new user with id ""
	When users tries to be registred
	Then the user registration fails, and get message "User name cannot contain numbers, and should have a length between one and four."
	And the user "" cannot be found in the companylist

Scenario: User registration fails(3)
	Given a new user with id "12AB"
	When users tries to be registred
	Then the user registration fails, and get message "User name cannot contain numbers, and should have a length between one and four."
	And the user "12AB" cannot be found in the companylist
	
Scenario: User registration fails(4)
	Given a new user with id "A,B."
	When users tries to be registred
	Then the user registration fails, and get message "User name cannot contain numbers, and should have a length between one and four."
	And the user "A,B." cannot be found in the companylist
	
Scenario: User registration fails(5)
	Given a new user with id "ABCDE"
	When users tries to be registred
	Then the user registration fails, and get message "User name cannot contain numbers, and should have a length between one and four."
	And the user "ABCDE" cannot be found in the companylist
	

