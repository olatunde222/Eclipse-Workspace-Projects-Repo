Feature: Login Functionality for openCart E-commerce Website

As a user of the OpenCart Website
I want to be able to log in with my account 
So that i can access my account-related features and manage my orders

Background: 
Given I am on the openCart login page

Scenario: Successful login with valid credntials
Given I have entered a valid username and password
When I click on the login button
Then I should be logged in successfully 

Scenario Outline: Unsuccessful login with invalid or empty credentials
Given I have entered invalid <username> and <password>
When I click on the login button 
Then I should see an error message indicating "<error_message>"

Examples:
|username			     |password			   |error_message 																				 |
|invalid@gmail1.co |invalidPassword1 | Warning: No match for E-Mail Address and/or Password. |


Scenario: Navigating to the forgotten password page
When I click on the "Forgotten Password" link
Then I should be redirected to the reset page 
