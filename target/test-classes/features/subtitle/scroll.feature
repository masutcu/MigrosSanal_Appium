@scrollPage
Feature: Login steps

  Background:  Application opens
    Given user goes main page

  Scenario: Scroll mainpage catalog
    Given verify campaing page count
    Then user swipe all campaing screen
    And verify last scrolable page is displayed