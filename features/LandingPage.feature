Feature: Checking the landing page actions

  @scenario1
  Scenario: Validate the Contact us
    Given I am on the landing page
    When I click on "contact us"
    Then I should navigate to "contact us" page

  @scenario2
  Scenario: Validate the Signin
    Given I am on the landing page
    When I click on "sign in"
    Then I should navigate to "sign in" page