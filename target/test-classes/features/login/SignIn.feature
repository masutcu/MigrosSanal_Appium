@SignIn
Feature: Login steps

  Background:  Application opens
    Given user goes main page

  Scenario: SignIn Field
    Given user taps on login button
    When user taps on _uyeOlVeyaGirisYap_ text
    Then user taps on _uyeOl_ button
    And user enters telnumber "5531610100"
    And user enters mailAdress "masutcu@gmail.com"
    Then user selects uyelikSozlesmesi checkBox
    And Verify that uyelikSozlesmesi box checked
    Then user selects kullanıcıIzni checkBox
    And Verify that kullanıcıIzni box checked
    Then user clicks uyeOl button
    And verify user passes the sms page


