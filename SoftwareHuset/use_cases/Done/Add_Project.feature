Feature: Add project
	Description: Add project to system
	Actor: User
	Udarbejdet af Anton
	
Scenario: Add project succeed[1]
	Given a new project with start date "01" "01" "2019" and end date "31" "12" "2019" and expected time "200"
	When users tries to add project
	Then and the project with the name "190001" exist
	
Scenario: Add project succeed[2]
	Given a new project with start date "01" "01" "2019" and end date "01" "01" "2019" and expected time "200"
	When users tries to add project
	Then and the project with the name "190001" exist
	
Scenario: Add project succeed[2]
	Given a new project with start date "01" "01" "2019" and end date "01" "01" "2020" and expected time "200"
	When users tries to add project
	Then and the project with the name "190001" exist

Scenario: Add project fails, because of the end date is before the start date
	Given a new project with start date "12" "01" "2019" and end date "10" "01" "2019" and expected time "200"
	When users tries to add project
	Then and the project with the name "190001" do not exist
	And get error message "End date cannot be before start date"
	
Scenario: Add project fails, because of the end date is before the start date
	Given a new project with start date "01" "03" "2019" and end date "31" "01" "2018" and expected time "200"
	When users tries to add project
	Then and the project with the name "190001" do not exist
	And get error message "End date cannot be before start date"
	
Scenario: Add project fails, because of date can only consist of numbers
	Given a new project with start date "aa" "01" "2019" and end date "31" "12" "2018" and expected time "200"
	When users tries to add project
	Then and the project with the name "190001" do not exist
	And get error message "Days should only consist of numbers"
	
Scenario: Add project fails, because of date can only consist of numbers
	Given a new project with start date "01" "aa" "2019" and end date "31" "12" "2018" and expected time "200"
	When users tries to add project
	Then and the project with the name "190001" do not exist
	And get error message "Months should only consist of numbers"
	
Scenario: Add project fails, because of date can only consist of numbers
	Given a new project with start date "01" "01" "aaaa" and end date "31" "12" "2018" and expected time "200"
	When users tries to add project
	Then and the project with the name "190001" do not exist
	And get error message "Years should only consist of numbers"
	
Scenario: Add project fails, cause of not legal day input
	Given a new project with start date "111" "01" "2019" and end date "31" "12" "2018" and expected time "200"
	When users tries to add project
	Then and the project with the name "190001" do not exist
	
Scenario: Add project fails, cause of not legal month input
	Given a new project with start date "01" "111" "2019" and end date "31" "12" "2018" and expected time "200"
	When users tries to add project
	Then and the project with the name "190001" do not exist
	
Scenario: Add project fails, cause of not legal Year input
	Given a new project with start date "01" "01" "11111" and end date "31" "12" "2018" and expected time "200"
	When users tries to add project
	Then and the project with the name "190001" do not exist
	
Scenario: Add project fails, cause of expected time need to be above 0
	Given a new project with start date "01" "01" "2019" and end date "31" "12" "2019" and expected time "0"
	When users tries to add project
	Then and the project with the name "190001" do not exist
	
Scenario: Add project fails, cause of expected time can only consist of numbers
	Given a new project with start date "01" "01" "2019" and end date "31" "12" "2019" and expected time "a.%1"
	When users tries to add project
	Then and the project with the name "190001" do not exist
	
Scenario: Add project fails, because of day is above "31"
	Given a new project with start date "32" "01" "2019" and end date "35" "01" "2019" and expected time "200"
	When users tries to add project
	Then and the project with the name "190001" do not exist
	And get error message "Illegal day input"
	
Scenario: Add project fails, because of day is above "31"
	Given a new project with start date "01" "01" "2019" and end date "31" "20" "2019" and expected time "200"
	When users tries to add project
	Then and the project with the name "190001" do not exist
	And get error message "Illegal month input"


	

