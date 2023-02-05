Feature: To Test the scenarios under Home-> Menu


  Scenario: Check the menu page for the main 4 Options
    Given The user at home page
    When user clicks on Menu
    Then user should be able to see the main menu options


  Scenario Outline: User clicks on the Main Menu
    Given The user is at menu page
    When user clicks on any Menu Option "<menuOption>"
    Then should be able to enter the location/postcode
    Examples:
      | menuOption |
      | Main menu    |









