Feature: I as a user I need to see the correct renovation of my plan

  @Test1
  Scenario: make recharge
    Given the user in on bemovil page
    When the user make login to the platform with LILIANACG and Miflash2021
    And  the user make a recharge to 3505082088 with 25000
    Then the user will see success message

  @Test2
  Scenario: Log in the flash mobile web
    Given the user is in the main page
    When the user log in in your account with Ip+QIsDswwfYAml3cNQwiQ== and Pvwx6o3Z+3wlV5l11d+Y0w==
    Then the user will see your current plan Power Flash
    And the user will see your correct telephone number 3505082088

  @Test3
  Scenario: notified to the user
    When the brand leader is notified Liliana y Sebastian y 12/12/12 y Power Flash y $25.000


