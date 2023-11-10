@keyboard
Feature: Search steps

  Background:  Application opens
    Given user goes main page

  @useKeyboardByKeyEvent
  Scenario: SearchBox Field
    Given user taps on searchBox
    And verify keyboard appears on Screen
    When user search ".portakal +-q" with keyboard
    Then user taps on search icon on keyboard

  @useKeyboardByRobotClass
  Scenario: SearchBox Field
    Given user taps on searchBox
    And verify keyboard appears on Screen
    When user search ".portakal +-@" with keyboard by Robot
    Then user taps on search icon on keyboard

