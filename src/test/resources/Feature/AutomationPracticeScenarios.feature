Feature: Login Functionality Feature for AutomationPractice

@OrderTShirt
Scenario: Verify the order T-Shirt scenario
    Given I am on login page
    When I click on signIn button
    And I use the credentials to login into the website
    And I click submit
    And I click on "T-shirts" tab
    And I add "Faded Short Sleeve T-shirts" to cart
    And I click on proceed to checkout button
    And I click on processAddress
    And I click on checkbox to agree for terms
    And I confirm carrier
    And I select bankWire as payment gateway
    And I read the reference
    Then I validate reference in order history
 
@firstNameChange  
Scenario: I update and verify the firstName 
    Given I am on login page
    When I click on signIn button
    And I use the credentials to login into the website
    And I click submit
    And I click on personalInfo
    And I change the firstName to "AnkitNew"
    And I add the old and new passwords
    And I click on submit button
    And I verify the message "Your personal information has been successfully updated."	

