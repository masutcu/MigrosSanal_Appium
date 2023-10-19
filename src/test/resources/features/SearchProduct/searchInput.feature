@SearchProduct
Feature: Login steps

  Background:  Application opens
    Given user goes main page

  Scenario: SignIn Field
    Given user taps on searchBox
    When user enters "çay" in search input
    Then user taps on search icon on keyboard



