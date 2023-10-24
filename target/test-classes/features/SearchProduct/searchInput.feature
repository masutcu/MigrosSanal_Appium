@SearchProduct
Feature: Search steps

  Background:  Application opens
    Given user goes main page

  Scenario: SearchBox Field
    Given user taps on searchBox
    When user enters "çay" in search input
    Then user taps on search icon on keyboard



