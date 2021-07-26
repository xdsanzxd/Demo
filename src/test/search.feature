@suite1
Feature: Perform a google search

  #Background:

  @smoketest
  Scenario Outline: Search a simple phrase in google and selected the second link
    Given Navigate to google page
    When Insert the word <phrase>
    Then The numbers of links in the first page are <links>
    And Click on link number <goLink>

    Examples: data
      | phrase      | links  | goLink |
      | chess game  | 10     | 2      |

  @smoketest
  Scenario: Search a simple phrase in google and selected the second link v2
    Given Navigate to google page
    When Insert the word chess game
    Then The numbers of links in the first page are 10
    And Click on link number 2

