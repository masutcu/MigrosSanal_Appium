@searchbybarcode

Feature: Search By Barcode

  Background:  Application opens
    Given user goes main page

  Scenario: Search By barcode
    Given user taps on borcode icon
    Then verify device cam is open
    And verify frame Image View appeared