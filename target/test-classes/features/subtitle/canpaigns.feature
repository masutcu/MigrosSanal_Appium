
Feature: Subtitle steps

  Background:  Application opens
    Given user goes main page

  @canpaigns
  Scenario Outline: Canpaigns Field
    Given user taps on "Kampanyalar" button
    Then user taps on canpaigns "<titles>" in order
    And user closes the opened adv
    Examples:
      | titles        |
      | Aldım Bitti   |
      | Bitiriyoruz   |
      | Migroskop     |
      | Çoklu İndirim |
      | Money         |

  @canpaignsAdv
  Scenario Outline: Adv Field
    Given user taps on "Kampanyalar" button
    Then user taps on canpaigns "<titles>" in order
    And user enters the opened adv
    Then verify that the  opened page "<titles>" is correct
    And user taps on return button

    Examples:
      | titles        |
      | Aldım Bitti   |
      | Bitiriyoruz   |
      | Migroskop     |
      | Çoklu İndirim |
      | Money         |

