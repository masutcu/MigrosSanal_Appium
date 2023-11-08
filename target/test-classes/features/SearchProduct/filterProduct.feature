@filterProduct
Feature: Product steps

  Background:  Application opens and goes Filter Field
    Given user goes main page
    When user taps on searchBox
    Then user enters "elma" in search box
    And user taps on search icon on keyboard
    And user taps on filterButton

    Scenario: Filter by Discounts
      Given user select filter by "İndirimler"
      Then user select checkBox and tap on Uygula button
      And user select filter by "Markalar"
      Then user select first 3 options
      And user taps on OKButton
      Then user select filter by "Sağlıklı Yaşam"
      And user select first 2 options
      And user taps on OKButton
      And user taps on OKButton again



