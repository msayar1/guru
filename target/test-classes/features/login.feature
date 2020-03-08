

Feature: Login
  I want to verify the login section

@valid_login
  Scenario: Login to user's account
    Given I want to go the home page
    And I enter username
    And I enter password
    When I click login
    Then I should be able to login my account

 