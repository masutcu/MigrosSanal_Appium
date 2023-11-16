@deliveryMethods
Feature: Search steps

  Background:  Application opens
    Given user goes main page
    Then user taps on delivery

  Scenario: Delivery Methods - deliver to home
    Given user taps on 'Adresime Gelsin' button
    Then user enters delivery address
    And user taps on search icon on keyboard
    And user selects suitable address option
    And verify address from map

