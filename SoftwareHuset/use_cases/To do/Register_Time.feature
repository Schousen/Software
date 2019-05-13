Feature: Register time to an activity
	Description: a user, tries to register time to an activity, 
	then the time is listed under the user in the activity, 
	the activity is an activity made for testing purpose
	Actor: User
	
Scenario: users time registration succeed
	Given a user "LSMD" is logged in, and the user have worked 7 hours on the activity "sickness"
	When the user tries to register time
	Then the time 7 is registed under the user "LSMD" in the activity "Housewarming"
	
Scenario: trying to register 0 hours
	Given a user "LSMD" is logged in, and the user have worked 0 hours on the activity "sickness"
	When the user tries to register time
	Then the time 0 is not registed under the user "LSMD" in the activity "Housewarming"

Scenario: Trying to register time, to an activity that do not exist
	Given a user "LSMD" is logged in, and the user have worked 7 hours on the activity "Make GUI"
	When the user tries to register time
	Then the time 7 is not registed under the user "LSMD" in the activity "Make GUI"
	
Scenario: trying to register over 24 hours on an activity
	Given a user "LSMD" is logged in, and the user have worked 25 hours on the activity "sickness"
	When the user tries to register time
	Then the time 25 is not registed under the user "LSMD" in the activity "sickness"
	
Scenario: trying to register none integer
	Given a user "LSMD" is logged in, and the user have worked "a" hours on the activity "sickness"
	When the user tries to register time
	Then the time "a" is not registed under the user "LSMD" in the activity "sickness"