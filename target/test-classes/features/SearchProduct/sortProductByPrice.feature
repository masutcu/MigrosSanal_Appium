@sortbyprice
Feature: Product steps

  Background:  Application opens
    Given user goes main page

  Scenario: Sort Product By Price
    Given user taps on searchBox
    When user enters "çay" in search input
    Then user taps on search icon on keyboard
    And user taps on sortButton
    And user taps on "Önce En Düşük Fiyat" option
    And user taps on uygulaButton
    And Verify that the products are sorted from "Önce En Düşük Fiyat"