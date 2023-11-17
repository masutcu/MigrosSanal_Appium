@deliveryMethods
Feature: Search steps

  Background:  Application opens
    Given user goes main page
    Then user taps on delivery

  @deliverToHome
  Scenario: Delivery Methods - deliver to home
    Given user taps on 'Adresime Gelsin' button
    Then user enters delivery address
    And user taps on search icon on keyboard
    And user selects suitable address option
    And verify address from map

  @fromMarket
  Scenario: Delivery Methods - From Market
    Given user taps on 'Mağazadan Alacağım' button
    Then user taps on 'Ankara' button
    And user taps on 'Yenimahalle' button
    And user taps on 'GALA SOKAĞI ANKARA MM' button
    Then verify selected market on townView field
