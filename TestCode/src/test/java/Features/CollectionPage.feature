Feature: To Test the scenarios under Home-> Collection


  @demotest
  Scenario: Add an starter to Basket for Collection
    Given The user at Collection page
    And Add restaurant for collection 'Reading'
    When User adds a starter to basket
    Then user should be able to see the added item in the basket


  Scenario: Add an starter to Basket for Collection
    Given The user at Collection page
    And Add restaurant for collection <location> , <RestaurantName>
    When User adds a starter to basket
    Then user should be able to see the added item in the basket
      |location   | RestaurantName   |
      |Reading  |Reading Oracle Shopping Centre|

