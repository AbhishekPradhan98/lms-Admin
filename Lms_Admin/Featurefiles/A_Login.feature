#Author: your.email@your.domain.com


Feature: Admin Login functionality
  
  @sanity
  Scenario: verifying Admin can Successfully logging with email and password
    Given I am on the Login page
    When I enter "morwal89@gmail.com" in the Email/Mobile No. field
    And I enter "Exam@123" in the Password field
    And I click the Login button
    Then I should see the dashboard page
    When i verify my Profile Name and click Logout button
      
@sanity
  Scenario: Successfully logging in with mobile number and password
    Given I am on the Login page
    When I enter "9598345731" in the Email/Mobile No. field
    And I enter "Gaur@123" in the Password field
    And I click the Login button
    Then I should see the dashboard page
     When i verify my Profile Name and click Logout button

@sanity
  Scenario: Attempting to login with incorrect password
    Given I am on the Login page
    When I enter "morwal89@gmail.com" in the Email/Mobile No. field
    And I enter "wrongpassword123" in the Password field
    And I click the Login button
    Then I should see an error message Invalid password. Please try again.

@sanity
  Scenario: Attempting to login with unregistered email
    Given I am on the Login page
    When I enter "nonexistent@example.com" in the Email/Mobile No. field
    And I enter "password123" in the Password field
    And I click the Login button
    Then I should see an error message Unregistered email. Please check your email or sign up.

@sanity
  Scenario: Attempting to login with empty fields
    Given I am on the Login page
    When I enter "" in the Email/Mobile No. field
    And I enter "" in the Password field
    And I click the Login button
    Then I should see an error message User ID and Password cannot be empty. Please enter your User ID and Password.
  
