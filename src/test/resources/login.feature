Feature: Login to saucedemo.com

  Scenario: Successful login
    Given I am on the login page
    When I enter the username "standard_user" and password "secret_sauce"
    And I click the login button
    Then I should be logged in