Feature: This is a example feature file

  @saucedemo
  Scenario: This is scenario to test suacedemo login with positive credentials
    Given User navigated to url "https://www.saucedemo.com/"
    When User enters username "standard_user"
    And user enters password "secret_sauce"
    And User clicks on login button
    Then User should be able to see the homepage

  @saucedemomultiplecases
  Scenario Outline: This is scenario to test suacedemo login with positive credentials
    Given User navigated to url "https://www.saucedemo.com/"
    When User enters username "<username>"
    Then user enters password "<password>"
    And User clicks on login button
    Then User should see a error message "<errorMessage>"

    Examples:
      |username        |password    |errorMessage                          |
      |locked_out_user |secret_sauce| Sorry, this user has been locked out.|
      |Invalid_user    |secret_sauce|Username and password do not match any user in this service|