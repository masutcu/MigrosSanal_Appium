@product
Feature: Product steps

  Background:  Application opens
    Given user goes main page

  Scenario: ProductPage Field
    Given user taps on searchBox
    When user enters "çay" in search input
    Then user taps on search icon on keyboard
    And Verify that the product displayed is correct

