Feature: Google search

  @googleSearch
  Scenario Outline: I want to search on google site
    Given I am on the google site
    When I enter "<KEYWORD>" as a keyword
    And I click on the search button
    Then I should see at least <RESULT_COUNT> results

    Examples:
    | KEYWORD    | RESULT_COUNT  |
    | selenium   | 2             |
#    | java       | 5             |
#    | spring     | 7             |
