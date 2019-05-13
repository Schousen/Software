Feature: Add Activity
	Description: Add Activiy to project
	Actor: User
	Udarbejdet af Christian
	
Scenario: Add activtiy to existing project
	Given an activity with name "troubleshooting" start date "01" "01" "2019" and end date "31" "12" "2019" and expected time "300"
	When user tries to add activity to project with index 1
	Then the activity with name "troubleshooting" is added to project with index 1
	
Scenario: Add activity with same end and start date
	Given an activity with name "troubleshooting" start date "15" "01" "2007" and end date "15" "01" "2007" and expected time "300"
	When user tries to add activity to project with index 1
	Then the activity with name "troubleshooting" is added to project with index 1

Scenario: Add activtiy with name Sickness Holiday or Courses[1]
	Given an activity with name "Sickness" start date "01" "01" "2019" and end date "31" "12" "2019" and expected time "300"
	When user tries to add activity to project with index 1
	Then the activity with name "Sickness" is not added to project with index 1
	And get the message "Illegal name for activity"
	
Scenario: Add activtiy with name Sickness Holiday or Courses[2]
	Given an activity with name "Holiday" start date "01" "01" "2019" and end date "31" "12" "2019" and expected time "300"
	When user tries to add activity to project with index 1
	Then the activity with name "Holiday" is not added to project with index 1
	And get the message "Illegal name for activity"
	
Scenario: Add activtiy with name Sickness Holiday or Courses[2]
	Given an activity with name "Courses" start date "01" "01" "2019" and end date "31" "12" "2019" and expected time "300"
	When user tries to add activity to project with index 1
	Then the activity with name "Courses" is not added to project with index 1
	And get the message "Illegal name for activity"
	
Scenario: Add activity with end year before start year fails
	Given an activity with name "troubleshooting" start date "01" "01" "2019" and end date "31" "12" "1019" and expected time "300"
	When user tries to add activity to project with index 1
	Then the activity with name "troubleshooting" is not added to project with index 1
	And get the message "End date cannot be before start date"
	
Scenario: Add activity with same start and end year and earlier end month fails
	Given an activity with name "troubleshooting" start date "31" "02" "2019" and end date "31" "01" "2019" and expected time "300"
	When user tries to add activity to project with index 1
	Then the activity with name "troubleshooting" is not added to project with index 1
	And get the message "End date cannot be before start date"
	
Scenario: Add activity with same start and end year and month and earlier end day than start day fails
	Given an activity with name "troubleshooting" start date "31" "01" "2019" and end date "05" "01" "2019" and expected time "300"
	When user tries to add activity to project with index 1
	Then the activity with name "troubleshooting" is not added to project with index 1
	And get the message "End date cannot be before start date"
	
Scenario: Add activity with none integer input in days fail
	Given an activity with name "troubleshooting" start date "au" "01" "2019" and end date "31" "01" "2019" and expected time "300"
	When user tries to add activity to project with index 1
	Then the activity with name "troubleshooting" is not added to project with index 1
	And get the message "Days should only consist of numbers"
	
Scenario: Add activity with none integer input in months fail
	Given an activity with name "troubleshooting" start date "15" "iu" "2019" and end date "31" "01" "2019" and expected time "300"
	When user tries to add activity to project with index 1
	Then the activity with name "troubleshooting" is not added to project with index 1
	And get the message "Months should only consist of numbers"
	
Scenario: Add activity with none integer input in year fail
	Given an activity with name "troubleshooting" start date "15" "01" "defr" and end date "31" "01" "2019" and expected time "300"
	When user tries to add activity to project with index 1
	Then the activity with name "troubleshooting" is not added to project with index 1
	And get the message "Years should only consist of numbers"
	

	

	
	
	