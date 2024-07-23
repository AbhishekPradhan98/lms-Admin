#Author: Abhishek Gaur

Feature: Admin Users Module

 @sanity  
Scenario Outline: Verifying Admin or SuperAdmin Add a new user
    Given I am on the Add User page
    When I enter "<Name>" in the Name field
    And I enter "<Email>" in the Email field
    And I enter "<Mobile>" in the Mobile No. field
    And I enter "<City>" in the City field
    And I enter "<AboutUser>" in the About user field
    And I select "<UserRole>" from the User Role dropdown
    And I enter "<Password>" in  Password field and enter "<PasswordConfirm>" in the Password (Confirm) field
    And I check the Visibility features toggle
    And I assign course says "<course>"
    And I attach "<UploadImagePath>" to the Upload Image field
    And I click the create user button
    Then I should see a confirmation message "<ConfirmationMessage>"
    And the user "<Name>" should be listed in the Users table

Examples:
    | Name     |     Email                   | Mobile       | City       | AboutUser              | UserRole | Password | PasswordConfirm |course         | UploadImagePath     | ConfirmationMessage      |
    | Abhishek | abhishek.gaur12@example.com | 12345ABC6789 | Gorakhpur  | A brief about Abhishek | Admin    | Gaur@123 | Gaur@123        |Cyber Security |\\images\\images.png | User created successfully|
 
 #@sanity
  #Scenario Outline: Verifying existing user creation and validation messages
    #Given I am on the Add User page
    #When I enter "<Name>" in the Name field
    #And I enter "<Email>" in the Email field
    #And I enter "<Mobile>" in the Mobile No. field
    #And I enter "<City>" in the City field
    #And I enter "<AboutUser>" in the About user field
    #And I select "<UserRole>" from the User Role dropdown
    #And I enter "<Password>" in  Password field and enter "<PasswordConfirm>" in the Password (Confirm) field
    #And I check the Visibility features toggle
    #And I assign course says "<course>"
    #And I attach "<UploadImagePath>" to the Upload Image field
    #And I click the create user button
    #Then I should see validation message says "<ResultErrorMessage>" 
#
#Examples:
    #| Name     |     Email                   | Mobile     | City       | AboutUser              | UserRole | Password | PasswordConfirm |course         | UploadImagePath       |   ResultErrorMessage                         |
    #| Abhishek | abhishek.gaur12@example.com | 9698359879 | Gorakhpur  | A brief about Abhishek | Admin    | Gaur@123 | Gaur@123        | Cyber Security | \\images\\images.png | This mobile number already exists! |
    #| Abhishek | abhishek.gaur12@example.com | 9698359879 | Gorakhpur  | A brief about Abhishek | Admin    | 12345678 | 12345678        | Cyber Security | \\images\\images.png | Password must have at least 8 characters including at least one special character, uppercase letter, lowercase letter and number. |   
      
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
   #@smoke
 #Scenario: Verifying Whether the Admin Can Edit Required Details in My Profile Section
 #
      #Given User navigates to My Profile Section
      #When user move to Users section 
      #And see My profile in dropdown then user click My Profile link and see Edit User page
      #Then user can see Edit user page
      #When user Move to Edit Profile as for Requirement and Edit in about users textbox as "someone having executive control over a network"
      #And click Save&List Button
      #Then System Navigate to All Users Page and see list of Users in table
 
  #@smoke
  #Scenario Outline: Verifying Admin's Ability to Create a New Role, Search for the Created Role, and Attempt Deletion
  #
      #Given User navigates to Role Section
      #When click Roles link and see list of roles that already created by Admin
      #And user move to click Add role + icon and see Add Role page
      #When user Enter Name say "<Name>" and enter key say "<Keys>"
      #And user click Add Permission button and see Module name with permission
      #And user click checkboxes to give permission and click Save&List Button
      #Then user navigate to Add Role Page
      #When user searches for the created Role
      #Then search result should display the created role
      #When the Admin attempts to delete the created role
      #Then the Role should be successfully deleted  
      
   
   #Examples:
           #|    Name      |  Keys     | 
           #|    Admin1    |  admin1   |
           
