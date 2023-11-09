@keyboard
Feature: Search steps

  Background:  Application opens
    Given user goes main page

  Scenario: SearchBox Field
    Given user taps on searchBox
    When user search "sab ah.kah,ves+i" with keyboard
    Then user taps on search icon on keyboard
