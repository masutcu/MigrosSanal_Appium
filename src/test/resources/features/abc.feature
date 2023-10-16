@first
Feature: Login steps
  Background:  Application opens
    Given user goes main page

    Scenario: Login Page
      Given user taps on login button
      Then user taps on _uyeOlVeyaGirisYap_ text
      Then user taps on _uyeOl_ button
      And user taps on telNumber input field
      Then user enters own number "5031010100"
      And verify user passes the sms page