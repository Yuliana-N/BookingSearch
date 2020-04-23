Feature: Search of hotels using booking.com
  Scenario: Search for Alfa Radon
    Given Hotel name is "Альфа Радон"
    When User open booking.com
    And Does Search
    Then Hotel "Alfa Radon Health Resort" should be on the first page
    And has rating "9.2"
